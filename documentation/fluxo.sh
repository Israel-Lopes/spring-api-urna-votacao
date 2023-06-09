#!/bin/bash

# Função para exibir uma mensagem de log
exibir_log() {
  echo "[LOG] $1"
}

# Função para gerar um CPF válido
gerar_cpf() {
  cpf=$(python -c 'from faker import Faker; fake = Faker(); print(fake.unique.random_number(digits=9, fix_len=True))')
}

# Função para criar um associado
criar_associado() {
  gerar_cpf
  exibir_log "Criando associado..."
  response=$(curl -sS -X POST -H "Content-Type: application/json" -d '{
    "cpf": "'"$cpf"'"
  }' http://localhost:8080/associado)
  id=$(echo "$response" | jq -r '.id')
  exibir_log "Associado criado com ID: $id"
  echo
}

# Função para criar uma pauta
criar_pauta() {
  exibir_log "Criando pauta..."
  response=$(curl -sS -X POST -H "Content-Type: application/json" -d '{
    "titulo": "Titulo da pauta",
    "descricao": "descricao da pauta"
  }' http://localhost:8080/pauta)
  id=$(echo "$response" | jq -r '.id')
  exibir_log "Pauta criada com ID: $id"
  echo
}

# Função para criar uma sessão de votação
criar_sessao() {
  exibir_log "Criando sessão de votação..."
  response=$(curl -sS -X POST -H "Content-Type: application/json" -d '{
    "tempoDaVotacao": "08:00:00"
  }' http://localhost:8080/sessao)
  sessao_id=$(echo "$response" | jq -r '.id')
  exibir_log "Sessão de votação criada com ID: $sessao_id"
  echo
}

# Função para iniciar a votação em uma sessão
iniciar_votacao() {
  exibir_log "Iniciando votação..."
  response=$(curl -sS -X PATCH -H "Content-Type: application/json" -d '{
    "votacaoEmAndamento": true
  }' "http://localhost:8080/sessao/$1")
  exibir_log "Votação iniciada na sessão com ID: $1"
  echo
}

# Função para um associado votar
associado_votar() {
  exibir_log "Associado votando..."
  response=$(curl -sS -X POST -H "Content-Type: application/json" -d '{
    "cpf": "'"$cpf"'",
    "voto": true,
    "idSessao": '"$1"'
  }' http://localhost:8080/votacao)
  exibir_log "Voto registrado com sucesso!"
  echo
}

# Execução do fluxo
exibir_log "Iniciando o fluxo..."
criar_associado
criar_pauta
criar_sessao
iniciar_votacao "$sessao_id"
associado_votar "$sessao_id"
exibir_log "Fluxo concluído com sucesso."

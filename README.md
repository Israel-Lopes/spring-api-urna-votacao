# Aplicação de votação

Identificador da instância de banco de dados: database-1

nome do usuario: admin

password: adminadmin

port: 3306

## Liberar acesso ao Mysql

Primeiro acessamos o banco pelo cloudshell ou aws cli:

``mysql -h database-2.c0qrixqdzilp.us-east-1.rds.amazonaws.com -P 3306 -u admin -p``

Agora conceder acessos ao usuario:

``GRANT CREATE ON *.* TO 'admin'@'%';
``


## Rotas

1. Associado

``POST`` Criar associado
```shell
curl -X POST -H "Content-Type: application/json" -d '{
  "cpf": "98765432109"
}' http://localhost:8080/associado
```

``GET`` Listar associados
```shell
curl -X GET -H "Content-Type: application/json" -d '{
}' http://localhost:8080/associado
```

---

2. Sessao

``POST`` Criar sessao de voto
```shell
curl -X POST -H "Content-Type: application/json" -d '{
  "tempoDaVotacao": "08:00:00"
}' http://localhost:8080/sessao
```
O campo ``tempoDaVotacao`` possui valor **default** de 1 minuto caso nao seja inserido tempo nele.

``GET`` Lista as sessoes de voto
```shell
curl -X GET http://localhost:8080/sessao
```

``PATCH`` Inicia sessao de voto
```shell
curl -X PATCH -H "Content-Type: application/json" -d '{
  "votacaoEmAndamento": true
}' http://localhost:8080/sessao/{id}
```

---

3. Pauta

``POST`` Criar pauta de votacao
```shell
curl -X POST -H "Content-Type: application/json" -d '{
  "titulo": "Titulo da pauta",
  "descricao": "descricao da pauta"
}' http://localhost:8080/pauta
```

``GET`` Listar pautas
```shell
curl -X GET http://localhost:8080/pauta
```

---

4. Votacao

``POST`` Cria um voto
```shell
curl -X POST -H "Content-Type: application/json" -d '{
  "cpf": "2222222",
  "voto": true,
  "idSessao": 1
}' http://localhost:8080/votacao
```

O campo **"voto"**, determina se o associado vota contra ou a favor. true para a favor e false para contra.
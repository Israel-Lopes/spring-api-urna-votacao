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

``GET`` Criar associado
```
curl -X POST -H "Content-Type: application/json" -d '{
  "cpf": "98765432109"
}' http://localhost:8080/associado
```


# Imagem base para o Java
FROM openjdk:17-jdk-slim-buster AS java-builder

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto Java para o contêiner
COPY . /app

# Executa o build da aplicação Java
RUN ./mvnw clean package -DskipTests

# Imagem base para o Node.js
FROM openjdk:17-jdk-slim-buster

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do Java e do Node.js para o contêiner final
COPY --from=java-builder /app/target/app-0.0.1-SNAPSHOT.jar /app/app.jar
COPY --from=java-builder /app/node-api-valida-cpf /app/node-api-valida-cpf

# Define as variáveis de ambiente
ENV PORT_JAVA=8080
ENV PORT_NODE=9090

# Expõe as portas 8080 e 9090
EXPOSE 8080 9090

# Instala o Node.js
RUN apt-get update && apt-get install -y nodejs

# Inicia a aplicação Java e o serviço Node.js
CMD java -jar /app/app.jar & cd /app/node-api-valida-cpf && node main.js

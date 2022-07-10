# Java Teste de seleção para vaga de Java

> Projeto para processo seletivo vaga de Dev Java

## 💻 Pré-requisitos

Antes de começar, verifique se você possui instalado em sua maquina as seguintes tecnologias:
* Docker
* Java 11
* Maven

## 🚀 Instalando Tinnova-test

Para instalar o projeto, siga estas etapas:

Suba o container na pasta container/:

```
sudo docker-compose up -d
```

Atualize as dependencias e rodar o liquibase execute o comando:
```
mvn clean install
```

Para acessar o swagger basta rodar a aplicação e acessar ao endereço:
```
localhost:8080/swagger-ui.html
```
Suba o back end com o spring boot em sua IDE de preferencia.

## 🍜 Licença
Projeto criado por Maria Carolina Santana Ribeiro


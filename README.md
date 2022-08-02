# Calculadora de Frete

# Pré-requisitos

Regras para calcular o valor do frete:
 * CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
 * CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
 * CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
 * O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00

Documentação da API: https://viacep.com.br/
Exemplo do GET: https://viacep.com.br/ws/<CEP_A_CONSULTAR>/json/

Antes de começar, verifique se você possui instalado em sua maquina as seguintes tecnologias:
* Docker
* Java 11
* Maven

## 🚀 Instalando

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


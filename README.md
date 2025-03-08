![Image](https://github.com/user-attachments/assets/bc1d3306-80c1-43c5-8d59-4b61ce209173)

> Status: Developing ⚠️

<h3>Essa é uma aplicação web, onde é realizado o calculo de uma sequencia numerica.</h3>
<br>

## Calculo implementado - Sequência de acordo com especificação

### Pesquisar um número e o sistema vai retornar o valor com base em regra pré definida


## Tecnologias utilizadas
<table>
  <tr>
    <td>Java</td>
    <td>Quarkus</td>
    <td>Maven</td> 
    <td>Swagger</td>
  </tr>
  <tr>
    <td>21</td>
    <td>3.19.2</td>
    <td>3.6.3</td> 
    <td>Default</td>
  </tr>
</table>

## Swagger
* Link: localhost:8080/q/swagger-ui/
* Labseq GET: http://localhost:8080/q/swagger-ui/#/Labseq%20Controller/get_labseq__n_

## Como rodar a aplicação:
1. Depois do projeto configurado (fazer clone, importar no intelliJ)
2. Executar o camando maven (./mvnw clean install)
3. Executar o app com o comando (./mvnw quarkus:dev)
4. Depois desses passos o serviço já ficará disponível
5. Exemplo de endpoint que obtém o calculo do valor (100000): http://localhost:8080/labseq/100000
6. É possível buscar os endpoints no Swagger ou executar no Postman


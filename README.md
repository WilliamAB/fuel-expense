# API: Cálculo de Gasto de Combustível

Projeto de API para cálculo de gasto de combustível, baseado no consumo médio do veículo (cidade e rodovia), no preço do combustível e na quilometragem percorrida (cidade e/ou rodovia).

## Sobre a API

A API foi desenvolvida com Java, Spring Boot e Spring Framework. A URL base da API é `/api/veiculo`.
A documentação completa com as URLs específicas, parâmetros e métodos (GET e POST) pode ser consultada no seguinte endereço [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) com a aplicação rodando.

## Como rodar
 - Instalar o banco de dados MySQL;
 - Criar um `schema` no banco, por padrão o nome já configurado na aplicação é `fuel_expense`:
	 - `CREATE SCHEMA fuel_expense;`
 - Clonar o projeto:
`git clone https://github.com/WilliamAB/fuel_expense.git`
 - Configurar o arquivo `application.resources` dentro de `src/main/resources`:
	 - URL de acesso ao banco (conforme banco instalado e nome do schema criado): `spring.datasource.url=jdbc:mysql://localhost:3306/fuel_expense`;
	 - Usuário do banco de dados: `spring.datasource.username=root`
	 - Senha do usuário do banco: `spring.datasource.password=senha`
	 - Dialeto do banco de dados (conforme banco instalado): `spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect`
 - Executar a aplicação a partir do seguinte comando dentro do diretório clonado:
 `gradlew bootRun`
 - Acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para consultar a documentação da API e poder realizar os testes de requisições.

## Como testar a API

Pelo site da documentação da API é possível realizar os testes, basta clicar em `Try it out` em cada requisição.

Outra possibilidade é utilizar o Postman. Basta baixar e enviar as requisições com os respectivos métodos, parâmetros e bodies.
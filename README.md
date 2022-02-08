# API: C�lculo de Gasto de Combust�vel

Projeto de API para c�lculo de gasto de combust�vel, baseado no consumo m�dio do ve�culo (cidade e rodovia), no pre�o do combust�vel e na quilometragem percorrida (cidade e/ou rodovia).

## Sobre a API

A API foi desenvolvida com Java, Spring Boot e Spring Framework. A URL base da API � `/api/veiculo`.
A documenta��o completa com as URLs espec�ficas, par�metros e m�todos (GET e POST) pode ser consultada no seguinte endere�o [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) com a aplica��o rodando.

## Como rodar
 - Instalar o banco de dados MySQL;
 - Criar um `schema` no banco, por padr�o o nome j� configurado na aplica��o � `fuel_expense`:
	 - `CREATE SCHEMA fuel_expense;`
 - Clonar o projeto:
`git clone https://github.com/WilliamAB/fuel_expense.git`
 - Configurar o arquivo `application.resources` dentro de `src/main/resources`:
	 - URL de acesso ao banco (conforme banco instalado e nome do schema criado): `spring.datasource.url=jdbc:mysql://localhost:3306/fuel_expense`;
	 - Usu�rio do banco de dados: `spring.datasource.username=root`
	 - Senha do usu�rio do banco: `spring.datasource.password=senha`
	 - Dialeto do banco de dados (conforme banco instalado): `spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect`
 - Executar a aplica��o a partir do seguinte comando dentro do diret�rio clonado:
 `gradlew bootRun`
 - Acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para consultar a documenta��o da API e poder realizar os testes de requisi��es.

## Como testar a API

Pelo site da documenta��o da API � poss�vel realizar os testes, basta clicar em `Try it out` em cada requisi��o.

Outra possibilidade � utilizar o Postman. Basta baixar e enviar as requisi��es com os respectivos m�todos, par�metros e bodies.
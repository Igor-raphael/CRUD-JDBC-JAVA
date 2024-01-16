# Primeiro CRUD utilizando Java Puro

Seguindo com os estudos, realizei meu primeiro CRUD utilizando JDBC, Linguagem Java. Utilizado IDE Eclipse e PostgreSql.

## 📦 Desenvolvimento

Hoje em dia os frameworks encapsulam toda essa base do Java puro mas é muito importante entender o que se passa por debaixo desses frameworks.

## 🛠️ Construído com

Ferramentas utilizadas para criar seu projeto

* [ECLIPSE](http://www.https://www.eclipse.org/) - IDE utilizada
* [POSTGRESQL](https://www.postgresql.org/) - SGBD Utilizado

## ✍🏽 Informações extras
 
* O nome do banco de dados usando nesse projeto foi "Agenda", mas é possível a sua renomeação se houver a atualização da URL na classe connectionFactory.
  ~~~java
  //url de acesso ao BD.
	private static final  String URL = "jdbc:postgresql://localhost:5432/Agenda";
  ~~~

* Na pasta resources se encontra o script.sql que foi usado nesse projeto e recomendo seu uso na forma que está estruturado para não ocorrer Erros.


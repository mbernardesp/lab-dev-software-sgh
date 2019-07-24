Notas da aula 3
- Criar as tabela do sgh.sql no banco de dados e inserir alguns registros em guest
- Apresentar a classe de conexão jdbc
- Apresentar o padrão singleton
- Apresentar o padrão factory

Exemplo em:
https://www.mkyong.com/jdbc/how-do-connect-to-postgresql-with-jdbc-driver-java/
 
Download drive jdbc para postgres
https://jdbc.postgresql.org/download.html

--------
Pattern Singleton
Não é recomendo o Singleton pois ele parte da política de que seu código deve sempre trabalhar com uma conexão abertas, 
quando é recomendado que se trabalhe com recursos fechados.

Fazendo da conexão em si um Singleton, sua aplicação ocupará recursos mesmo que esteja ociosa, e também poderá falhar 
caso o banco de dados resolva fechar a conexão por conta própria.

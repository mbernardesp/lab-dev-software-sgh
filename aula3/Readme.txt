Notas da aula 3
- Utilizar os scripts sgh-script-ddl.sql e 
  sgh-script-dml.sql para cria��o e inser��o 
  de dados
- Apresentar a classe de conex�o jdbc
- Apresentar o padr�o singleton
- Apresentar o padr�o factory

Exemplo em:
https://www.mkyong.com/jdbc/how-do-connect-to-postgresql-with-jdbc-driver-java/
 
Download drive jdbc para postgres
https://jdbc.postgresql.org/download.html

--------
Pattern Singleton
N�o � recomendo o Singleton pois ele parte da pol�tica de que seu c�digo deve sempre trabalhar com uma conex�o abertas, 
quando � recomendado que se trabalhe com recursos fechados.

Fazendo da conex�o em si um Singleton, sua aplica��o ocupar� recursos mesmo que esteja ociosa, e tamb�m poder� falhar 
caso o banco de dados resolva fechar a conex�o por conta pr�pria.

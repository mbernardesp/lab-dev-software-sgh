Notas da aula 5
- Apresentar o padr�o singleton

----------

Pattern Singleton
N�o � recomendado o Singleton pois ele parte da pol�tica de que seu c�digo deve sempre trabalhar com uma conex�o abertas, 
quando � recomendado que se trabalhe com recursos fechados.

Fazendo da conex�o em si um Singleton, sua aplica��o ocupar� recursos mesmo que esteja ociosa, e tamb�m poder� falhar 
caso o banco de dados resolva fechar a conex�o por conta pr�pria.

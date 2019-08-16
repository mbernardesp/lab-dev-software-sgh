Notas da aula 5
- Apresentar o padrão singleton

----------

Pattern Singleton
Não é recomendado o Singleton pois ele parte da política de que seu código deve sempre trabalhar com uma conexão abertas, 
quando é recomendado que se trabalhe com recursos fechados.

Fazendo da conexão em si um Singleton, sua aplicação ocupará recursos mesmo que esteja ociosa, e também poderá falhar 
caso o banco de dados resolva fechar a conexão por conta própria.

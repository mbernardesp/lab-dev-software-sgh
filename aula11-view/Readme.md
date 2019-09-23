#Criação da estrutura do projeto web 

- webapp
  - WEB-INF
    - jsp
  - resources
    - css
    - fonts
    - js 

#Ajustar o application.properties para reconhecer o caminho das páginas
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp 

#Implementação de fragments
- header.jsp
- footer.jsp   

#Implementar da página index
index.jsp

#Uso da classe model parta troca de informações entre view e controller
Model

#Aplicação do bootstrap no projeto
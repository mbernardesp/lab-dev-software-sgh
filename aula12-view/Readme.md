#Criar as pastas 

- webapp
  - WEB-INF
    - jsp

#Ajustar o application.properties para reconhecer o caminho das páginas
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp 

#Consumo de apis, podemos utilizar o RestTemplate também do spring, que oferece uma gama 
#de operações para facilitar o acesso para POST, GET, UPDATE e DELETE em apis        
RestTemplate

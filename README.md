# CRUD de Departamento

Esse projeto foi desenvolvido com proposito de avaliação pela empresa OMNI.

A API desenvolvida está no repositório BitBucket criado.

Segue o link da Pull Request para a master: 
~~~
https://bitbucket.org/omnifinanceira/java-test-willians-lorente/pull-requests/1/pr-api-cadastro-de-departamentos-master
~~~

O código do Front que consome a API desenvolvida está comitado no GIT:
~~~
https://github.com/lorentew/omni-departments-app
~~~

### Como Executar o Projeto

A API está publicada no Heroku e pode ser acessada através dos linkes:

Consultar Departamentos (GET):
~~~
https://omni-departments.herokuapp.com/api/departments/
~~~

Consultar Departamentos por ID (GET):
~~~
https://omni-departments.herokuapp.com/api/departments/1 (Consultar Departamento ID: 1)
~~~

Consultar Departamentos por Estado (GET):
~~~
https://omni-departments.herokuapp.com/api/departments/state-search?state=SP (Consultar todos Departamentos do Estado de SP)
~~~

Inserir Departamento (POST):
~~~
https://omni-departments.herokuapp.com/api/departments/
~~~
Body JSon
{
    "name": "TESTE",
    "region": "Santo Amaro",
    "city": "São Paulo",
    "state": "SP",
	"idBoard": "NEGOCIOS"
}

Alterar Departamento (PUT):
~~~
https://omni-departments.herokuapp.com/api/departments/3
~~~
Body JSon
{
    "name": "TESTE",
    "region": "Santo Amaro",
    "city": "São Paulo",
    "state": "SP",
	"idBoard": "NEGOCIOS"
}

Excluir Departamento (DELETE):
~~~
https://omni-departments.herokuapp.com/api/departments/5 (Excluir Departamento ID: 5)
~~~

A aplicação (Front) foi construída com Java 11 utilizando PrimeFaces e está dockerizada e pode ser executada através do pacote que se encontra no GitHub
~~~
https://github.com/lorentew/omni-departments-app
~~~

e criando a imagem através do comando:
~~~
docker build -t departments-api/dockerfile .
~~~

e executando através do comando:
~~~
docker run -p 8080:8080 departments-api/dockerfile:latest
~~~

e acessada pelo link:
~~~
http://localhost:8080/omni-departments-app/
~~~

Também poderá ser acessada através do DockerHub com os seguintes comandos:

~~~
docker pull lorente/omni-departments
docker run -p 8081:8081 lorente/omni-departments
~~~

E poderá ser acessada através do link:
~~~
http://localhost:8081/omni-departments-app/
~~~

Para rodar manualmente, é necessário instalar o Tomcat 9 e fazer o deploy do pacote WAR e executar a aplicação através da porta padrão configurada no servidor Tomcat

### Construido com:

* Java 11
* Maven
* Spring Boot
* Hibernate
* Spring Data JPA
* Database H2 (Testes)
* PrimeFaces
* Jersey
* Gson
* OKHTTP3
* MySql (Desenv e Prod)


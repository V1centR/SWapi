### Instalação

```sh
$ git clone https://github.com/V1centR/SWapi.git
$ mvn clean install; mvn spring-boot:run
```

### Endpoints
Nessa api é possível, listar,adicionar, editar, excluir, listar planetas da api externa. Database em MongoDb



**Registrar:**
**PUT http://localhost:8080/add**
send JSON:
```sh
{
    "name": "nomePlaneta",
    "clima": "climaPlaneta",
    "terreno": "nomeTerreno",
    "shows": "numeroDeShows em filmes"
}
```
**Listar:** **GET http://localhost:8080/search/all**
**Response:**
```sh
{id=5ef05384d2cf730e4e8c84eb, name='NomePlaneta', clima='verão',terreno='plano',shows='99'},
{id=5ef05384d2cf730e4e8cm87t, name='NomePlaneta2', clima='inverno',terreno='serrado',shows='1'}
```
**Listar por ID:** **GET http://localhost:8080/search/{id}**
**Response:**
```sh
{id=5ef05384d2cf730e4e8c84eb, name='NomePlaneta', clima='verão',terreno='plano',shows='99'}
```
**Excluir:** **DELETE http://localhost:8080/delete/{id}**
**Response:**
```sh
{void}
```
**Editar:** **PUT http://localhost:8080/edit/{id}**
send JSON:
```sh
{
    "_id": "5ef05384d2cf730e4e8c84eb"
    "name": "OutronomePlaneta",
    "clima": "climaPlaneta",
    "terreno": "nomeTerreno",
    "shows": "numeroDeShows em filmes"
}
```
**Response:**
```sh
{id=5ef05384d2cf730e4e8c84eb, name='OutronomePlaneta', clima='climaPlaneta', terreno='nomeTerreno',shows='numeroDeShows em filmes'
}
```
**Listar planetas API externa swapi.dev:** **PUT http://localhost:8080/search/all/external**

```sh
{
        "planetTatooine": {
            "clima": "arid",
            "name": "Tatooine",
            "show": "[http://swapi.dev/api/films/1/,http://swapi.dev/api/films/3/,http://swapi.dev/api/films/4/,http://swapi.dev/api/films/5/,http://swapi.dev/api/films/6/]",
            "terreno": "desert"
        }
    },
    {
        "planetAlderaan": {
            "clima": "temperate",
            "name": "Alderaan",
            "show": "[http://swapi.dev/api/films/1/,http://swapi.dev/api/films/6/]",
            "terreno": "grasslands, mountains"
        }
    },
    ... + 58 planets data

```

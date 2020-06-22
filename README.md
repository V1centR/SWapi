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
            "films": [
                "http://swapi.dev/api/films/1/",
                "http://swapi.dev/api/films/3/",
                "http://swapi.dev/api/films/4/",
                "http://swapi.dev/api/films/5/",
                "http://swapi.dev/api/films/6/"
            ],
            "edited": "2014-12-20T20:58:18.411000Z",
            "created": "2014-12-09T13:50:49.641000Z",
            "climate": "arid",
            "rotation_period": "23",
            "url": "http://swapi.dev/api/planets/1/",
            "population": "200000",
            "orbital_period": "304",
            "surface_water": "1",
            "diameter": "10465",
            "gravity": "1 standard",
            "name": "Tatooine",
            "residents": [
                "http://swapi.dev/api/people/1/",
                "http://swapi.dev/api/people/2/",
                "http://swapi.dev/api/people/4/",
                "http://swapi.dev/api/people/6/",
                "http://swapi.dev/api/people/7/",
                "http://swapi.dev/api/people/8/",
                "http://swapi.dev/api/people/9/",
                "http://swapi.dev/api/people/11/",
                "http://swapi.dev/api/people/43/",
                "http://swapi.dev/api/people/62/"
            ],
            "terrain": "desert"
        }
    },
    {
        "planetAlderaan": {
            "films": [
                "http://swapi.dev/api/films/1/",
                "http://swapi.dev/api/films/6/"
            ],
            "edited": "2014-12-20T20:58:18.420000Z",
            "created": "2014-12-10T11:35:48.479000Z",
            "climate": "temperate",
            "rotation_period": "24",
            "url": "http://swapi.dev/api/planets/2/",
            "population": "2000000000",
            "orbital_period": "364",
            "surface_water": "40",
            "diameter": "12500",
            "gravity": "1 standard",
            "name": "Alderaan",
            "residents": [
                "http://swapi.dev/api/people/5/",
                "http://swapi.dev/api/people/68/",
                "http://swapi.dev/api/people/81/"
            ],
            "terrain": "grasslands, mountains"
        }
    }
    ... + 58 planets data

```

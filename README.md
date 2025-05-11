
# Proyecto Integración

## Índice
1. [Descripción](#descripción)
2. [Instalación](#instalación)
3. [Uso](#uso)
   - [GitHubMiner](#githubminer)
   - [BitbucketMiner](#bitbucketminer)
   - [GitMiner](#gitminer)
4. [Pruebas con Postman](#pruebas-con-postman)
5. [Autores](#autores)

## Descripción
**GitMiner** es una herramienta de minería de repositorios Git que permite cargar, procesar y analizar datos de proyectos alojados en plataformas como GitHub y Bitbucket. El sistema está diseñado con una arquitectura de microservicios, lo que facilita la escalabilidad y mantenimiento del proyecto.

### Arquitectura de microservicios
El proyecto se compone de tres servicios independientes:

- **GitHubMiner**: Servicio adaptador que obtiene datos de la API REST de GitHub y los transforma al modelo de datos común.
- **BitbucketMiner**: Similar a GitHubMiner, pero conectado a la API REST de Bitbucket.
- **GitMiner**: Servicio central que almacena los datos en una base de datos H2 y los expone a través de una API REST.

## Instalación

### 1. Clona el repositorio:
   ```bash
   git clone https://github.com/usuario/ProyectoGitMiner.git
   ```

### 2. Accede al directorio del proyecto:
    
    cd ProyectoGitMiner

### 3. Abre los tres servicios en tu entorno de desarrollo

Lanza cada servicio de forma individual, asegurándote de que cada uno escuche en su puerto correspondiente:

- **GitMiner**: http://localhost:8080

- **GitHubMiner**: http://localhost:8082

- **BitbucketMiner**: http://localhost:8081

## Uso
### GitHubMiner
GitHubMiner tiene disponible las siguientes operaciones:
- Obtener los datos extraídos de GitHub, parseados en formato de salida de GitMiner:

    ```bash
    GET /apipath/{owner}/{repoName}[?sinceCommits=5&sinceIssues=30&maxPages=2]:

- Además de obtenerlos y transformarlos, enviarlos a GitMiner para que los almacene en su base de datos:

    ```bash
    POST /apipath/{owner}/{repoName}[?sinceCommits=5&sinceIssues=30&maxPages=2]:

Por ejemplo, para ambas operaciones serviría la url:

    http://localhost:8082/github/spring-projects/spring-framework?sinceCommits=1&sinceIssues=1&maxPages=1

## BitbucketMiner
BitbucketMiner tiene disponible las siguientes operaciones:

- Obtener los datos extraídos de GitHub, transformados en formato de salida de GitMiner:

    ```bash
    GET /apipath/{workspace}/{repo_slug}[?nCommits=5&nIssues=5&maxPages=2]

- Enviar los datos de la petición a GitMiner tras obtenerlos y transformarlos:

    ```bash
    POST /apipath/{workspace}/{repo_slug}[?nCommits=5&nIssues=5&maxPages=2]

Por ejemplo, para ambas operaciones seriría la siguiente url:

    http://localhost:8081/bitbucket/gentlero/bitbucket-api?nCommits=5&nIssues=5&maxPages=2

### GitMiner
Este servicio expone los datos almacenados a través de una API REST, utilizando una base de datos H2 interna.

Operaciones disponibles:

- Listar todos los proyectos
    ```bash
    GET /projects
    ```
- Añadir un nuevo proyecto (desde los otros dos servicios)
    ```bash
    POST /projects
    ```
- Listar todos los commits
    ```bash
    GET /commits

- Obtener commit por ID
    ```bash
    GET /commits/{id}

- Listar todos los issues
    ```bash
    GET /issues 

- Obtener issue por ID   
    ```bash
    GET /issues/{id}

- Filtrar issues por estado
    ```bash
    GET /issues?state={state}

- Listar todos los comentarios
    ```bash
    GET /comments 

- Obtener comentario por ID
    ```bash
    GET /comments/{id} 

Todo esto desde a través de su uri base:

    http://localhost:8080/gitminer/

## Pruebas con Postman

Puedes probar todas las operaciones usando la colección Postman incluida en el proyecto. Para ello:

1. Abre Postman e importa la colección de pruebas:
2. Ajusta las variables si es necesario (host, puertos)
3. Ejecuta las pruebas para verificar el funcionamiento completo del sistema.

## Bibliografía
La información de cada API se ha obtenido a partir de su documentación:
- BitbucketMiner: https://developer.atlassian.com/cloud/bitbucket/rest/api-group-reports/#api-repositories-workspace-repo-slug-commit-commit-reports-reportid-put
- GitHubMiner: https://docs.github.com/en/rest?apiVersion=2022-11-28

## Autores

- Adrián Muñoz Aradilla: adrmunara@alum.us.es 
- Miguel Cuesta Sánchez: migcuesan@alum.us.es 
- Rocío Morato Aguilar: rocmoragu@alum.us.es
- Raúl Romero Carmona: rauromcar1@alum.us.es 


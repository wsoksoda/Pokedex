# Pokedex
This project is a backend API built with Spring Boot, and Liquibase. 

Functionalities:
1. Retrieve paginated list of pokemon -http://localhost:8081/api/pokemon
    Add ?=offset=# to control offset
    Add ?=pageSize=# to control page size
    Add ?=offset=#&pageSize=# to control both
    

2. Retrieve a specific pokemon - http://localhost:8081/api/pokemon/#
    HTTP Response 404 Indicates that pokemon is outside of the range of existing pokemon

3. Create a trainer - http://localhost:8081/api/trainers
    {
      "username": "Ash",
      "password": "Ketchum",
     "color": "Red"
    }
    HTTP Response 422 Indicates a trainer with that username already exists
    Usernames must be unique

4. Mark a specific pokemon as captured - http://localhost:8081/api/captured
    {
      "trainerId": 2,
      "pokemonId": 6
    }
    HTTP Response 422 indicates either pokemon does not exist or trainer does not exist
    HTTP Response 409 indicates pokemon is already caught by trainer

5. Retrieve information about captured Pokemon http://localhost:8081/api/captured/#
    HTTP Response 422 indicates trainer does not exist

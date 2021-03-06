# el-springboot-restapi-mongo-1

Spring Boot rest API application with MongoDB.

# Configuration
In the application.properties file change the mongoDB URI link with your mongoDB Atlas SRV Connnection String.
Change the database cluster name to something else if you want.

### Or
Configure your application (file application properties) with the "MONGODB (MongoProperties)"
```
spring.data.mongodb.host= # the db host
spring.data.mongodb.port=27017 # the connection port (defaults to 27107)
spring.data.mongodb.uri=mongodb://localhost/test # connection URL
spring.data.mongodb.database=
spring.data.mongodb.authentication-database=
spring.data.mongodb.grid-fs-database=
spring.data.mongodb.username=
spring.data.mongodb.password=
spring.data.mongodb.repositories.enabled=true # if spring data repository support is enabled
```

# Endpoint

Online Postman API documentation :
https://documenter.getpostman.com/view/1700165/Rzfaqr8i

# Task

## Get all tasks
>GET http://localhost:8080/tasks/all

## Create task
>PUT http://localhost:8080/tasks/

>HEADERS
Content-Type
application/json

>BODY
```js
{
	"id": "5bf94984b7bca66999999999",
	"description": "Make again the EL exercise"
}
```

## Get task by Id
>GET http://localhost:8080/tasks/{taskId}

## Update task
>POST http://localhost:8080/tasks/

>HEADERS
Content-Type
application/json

>BODY
```js
{
	"id": "5bf94984b7bca66999999999",
	"description": "Make correction of the EL exercise"
}
```

## Get all all task of user by user id
>GET http://localhost:8080/tasks/usertasks/{userId}

# User

## Get all users
>GET http://localhost:8080/users/all

## Create user
>PUT http://localhost:8080/users/

>HEADERS
Content-Type
application/json

>BODY
```js

{
    "id": "5bf91318b7bca65dc51bef0d",
    "firstName": "JP",
    "lastName": "Dupont",
    "tasks": [
        {
            "id": "sdfsdfsdsd",
            "description": "Review EL exercise"
        }
]}
```

## Update user
>POST http://localhost:8080/users/

>HEADERS
Content-Type
application/json

>BODY
```js
{
    "id": "5bf91318b7bca65dc51bef0d",
    "firstName": "Jean-Phillippe",
    "lastName": "Dupont",
    "tasks": [
        {
            "id": "sdfsdfsdsd",
            "description": "Review EL exercise"
        }]
}
```

## Get User by Id task
>GET http://localhost:8080/users/task/{taskId}

## Get User by firstname
>GET http://localhost:8080/users/name/{userFisrtName}

## Get user by Id
>GET http://localhost:8080/users/{userId}

## Assign Task to User by user id and task id
>POST http://localhost:8080/users/assigntask/{userId}/{taskId}

## Delete user by user id
>DELETE http://localhost:8080/users/{userId}

## Delete task by task id
>DELETE http://localhost:8080/tasks/{taskId}

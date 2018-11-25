# el-springboot-restapi-mongo-1

Spring Boot rest API application with MongoDB.

# Endpoint

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
    "lastName": "Jacquet",
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
    "lastName": "Jacquet",
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

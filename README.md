# README.md

# Kruger-challenge Backend

### Inventario de vacunación en Spring Boot

**Table of Contents**

[TOCM]

[TOC]


## Introduction

Kruger Corporation requires an application to keep track of the inventory of the state of
employee vaccination.

Coded by: Diego Salazar

email: diegosalazarandlun@protonmail.com

github: https://github.com/diogosss

## Building process

The application was build for gradle using SpringBoot 2.7.0 for Java 11.

The structure of the project is:
+ Domain
  + Services
  + Respository
  + Commons
+ Web
  + Controllers (Api rest)
  + Config
+ Persistence
  + CrudRepository
  + Entity

It is based in the **Domain Driven Design**

The server port used is

`port:8081`

## Requirements

### Persistence

To be able to run this program without complications it is necessary the next PostgreSQL characteristics

+ PostgreSQL database name :
>testemployees
+ PostgreSQL table name :
>empleados

To create a table `empleados` with all the entities necessary, you can use this .sql file:

[empleados.sql](https://github.com/diogosss/kruger-challenge-springbknd/blob/main/files/empleados.sql)

#### Model data

Or you can create a database table with the next specifications

| Name        | Data type         | Length | Not NULL? |
|-------------|-------------------|--------|-----------|
| empleado_id | integer           |        | YES       |
| cedula      | integer           |        | YES       |
| nombres     | character varying | 100    | YES       |
| apellidos   | character varying | 100    | YES       |
| correo      | character varying | 100    | YES       |
| direccion   | character varying | 200    | NO        |
| telefono    | integer           |        | NO        |
| estadovac   | boolean           |        | NO        |
| tipovac     | character varying | 100    | NO        |
| nacimiento  | date              |        | NO        |
| fechavacuna | date              |        | NO        |
| numdosis    | integer           |        | NO        |


### Example Data

You can find example of data to insert by the application in this file:

[empleados.json](https://github.com/diogosss/kruger-challenge-springbknd/blob/main/files/exampledata.json)

Or you can send data in this format:

One employee:
```json
    {
        "cedula":1787524596,
        "nombres":"Diego Andres",
        "apellidos":"Salazar Luna",
        "correo":"diogos@hotmail.com"
    }
```

List employees:
```json
[
    {
        "nombres": "Pepito Jose",
        "apellidos": "Suarez Cespedes",
        "correo": "algo@gmail.com",
        "cedula": 1714121510
    },
    {
        "nombres": "Juanito Manuel",
        "apellidos": "Flores Arias",
        "correo": "jnnas@gmail.com",
        "cedula": 1714169501
    }
]
```



## Specifications of software used to develop this project
The present code was compiled with:
+ Java version 11
  + openjdk version "11.0.15" 2022-04-19
  + OpenJDK Runtime Environment Temurin-11.0.15+10 (build 11.0.15+10)
  + OpenJDK 64-Bit Server VM Temurin-11.0.15+10 (build 11.0.15+10, mixed mode)
+ Spring Boot version : 2.7.0
+ Swagger2 version : 2.9.2
+ Postgre Sql version : 12 



## Mode of operation
In the command line run the next line of code to start the server:

```bash
$> java -jar inventariovac-1.0.0.jar
```
The .jar file can be download from:

[inventariovac-1.0.0.jar](https://github.com/diogosss/kruger-challenge-springbknd/raw/main/files/inventariovac-1.0.0.jar)

## Test and Documentation

To test and see the documentation of this API you can with Swagger2 in the next address:

>http://localhost:8081/kruger-challenge/swagger-ui.html

## Postman

You can find a Postman collection to test this application in this file:

[KruggerChallenge.postman_collection.json](https://github.com/diogosss/kruger-challenge-springbknd/blob/main/files/KruggerChallenge.postman_collection.json)

## TODO

+ Implementation OAuth 2.0
+ Creation of Users and Passwords for Administrators and Employees
+ Authentication based in roles



## END

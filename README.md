# Spring-Boot-BookList

A Demo project practicing Spring Boot with JPA interface connecting to MySQL database.
This is the origin IntellJ IDEA project. 

## Getting Started
Clone this repo and You can just open WebApp as a project with IntellJ IDEA.

### Prerequisites
Edit src/main/java/resources/appication.yml depending on your own MySQL configuration. 

make sure there is a database called "spring"
```
CREATE DATABASE [IF NOT EXISTS] spring
```

and table called book

```
REATE TABLE [IF NOT EXISTS] book(
   id INT PRIMARY KEY,
   name VARCHAR(20),
   description VARCHAR(20),
   author VARCHAR(20),
   status INT
)
```



## Running the tests

Run DemoAppication.java


## Authors

* **Yang Guo** 

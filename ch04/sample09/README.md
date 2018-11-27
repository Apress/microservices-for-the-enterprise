## Chapter 4: Developing Services (Sample09/GraphQL)
  

1. You can run the BookStore GraphQL service with the following command from sample09 directory :

``` 
:\> mvn spring-boot:run
```

2. Once the service is up and running you can access the GraphiQL UI via:

```
http://localhost:8080/graphiql
```

3. 
Then you can run the following queries to try out the behavior of your GraphQL service. 

- Get all books in the store

``` 
{
    books {
      title
      
    }
}
```

- Find more details of all books. 
```
{
    books {
      title, 
      authors {
        id,
        name, 
        address
      }
    }
}

```

- Find author of a given book. 
``` 
{
    findAuthor(name: "Beginning WSO2 ESB") {
        name
    }
}

```
- Find more details of an author of a given book. 

``` 
{
    findAuthor(name: "Microservices for Enterprise") {
        id, 
        name,
        address
    }
}
```



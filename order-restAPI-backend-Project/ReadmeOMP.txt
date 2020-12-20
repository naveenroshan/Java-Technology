project URL:https://dzone.com/articles/creating-a-rest-api-with-java-and-spring?fromrel=true
Spring and create a simple order management RESTful web application using Spring 4.(3-Tier application.)
--------------------------------------------------------------------------------------------------------
TOOLS:
spring Model View Controller 
spring boot
Apache maven
junit
cucumber
java 8
travis continuous integration
--------------------------------------------------------------------------------------------------------
Part 1:
--------------------------------------------------------------------------------------------------------
domain layer:
----------------
Order simple definition of domain model:
{
id: long
description: string
costInCent: long
isCompleted: boolean
}
---------------------------------------------------------------------------------------
presentation layer:
-------------------
Using the standard HTTP verbs, REST endpoints Create, Read, Update, and Delete (CRUD) operations:

get - url= /orderGet: 

Obtains the list of all orders currently created in the system. If the list is successfully obtained, the list of existing orders is returned, along with an HTTP 200(OK) status.

post - url= /orderPost:

Creates a new order. This request should carry a request body that includes the data that should be associated with the newly created order. If the order is created, an HTTP 201 (Created) status is returned along with the newly created order in the response body.

get - url= /orderGetWithId/{id}:

Obtains the order associated with the given ID. If no order exists, an HTTP 404 (Not Found) status is returned. If the order can be found, an HTTP 200 status is returned and the response body contains the information associated with the order.

put - url= /orderPut/{id}:

Updates an existing order. If no order with the given ID can be found, an HTTP 404 status is returned. If an order exists with the given ID and the request body contains valid updates to the order, the order is updated and the updated order is returned in the response body, along with an HTTP 200 status.

delete -url= /orderDelete/{id}:

Deletes an order with the given ID. If no order exists, an HTTP 404 status is returned. If the order exists, it is deleted, and an HTTP 204 (No Content) status is returned.

----------------------------------------------------------------------------------------------------------
persistence layer or data source layer:
---------------------------------------
in-memory database

----------------------------------------------------------------------------------------------------------
hypermedia-driven is used to send  the link in the responce body:


{
    "id": 1,
    "description": "Some sample order",
    "costInCents": 250,
    "complete": false
    "_links": {
        "self": {
            "href": "http://localhost:8080/order/1"
        },
        "update": {
            "href": "http://localhost:8080/order/1"
        },
        "delete": {
            "href": "http://localhost:8080/order/1"
        }
    }
}

>the Spring Hypermedia as the Engine of Application State (HATEOAS), framework provides numerous classes and builders for hypermedia-driven.
----------------------------------------------------------------------------------------------------------
At the moment, we have a single domain object, Order, instances of whom will be persisted in an in-memory database and served up (within a resource) to clients using our REST endpoints. This design leaves us with four main steps:

>Implement the domain model
               Create the Order domain class
>Implement the data source layer
               Create an in-memory database
               Implement the CRUD operations for the Order domain class
>Implement the presentation layer
               Create the REST endpoints
               Create the Order resource
               Create assembler to construct an Order resource with proper HATEOAS links
>Pull the application together
               Create the main method that will run the application

In Part 2, we will work on implementing the data source and domain layers, which will lay the foundation for implementing the RESTful interface of our web service.
==========================================================================================================
part 2
-----------------------------------------------------------------------------------------------------------
>Implementing the Domain Layer:
   
the first of these details is identity:
--------------------------------------
>we will create an interface to accomplish this task = interface Identifiable 

the second of these details is setter and getter for client to do update:
--------------------------------------
> we can now create our Orderclass: order class

>We have also provided the remaining two setter methods for the completion state to allow for clients to set the completion status in the recommended manner (without passing a boolean flag to a setter method).

>we are not using this method in order class:

public void updateOrder(Order original, Order updated) {
    // Update the other fields of the order
    if (updated.isComplete()) {
        original.markComplete();
    }
    else {
        original.makeIncomplete();
    }
}

>we leave it up to the persistence layer to implement the update logic for our Order class.

--------------------------------------------------------------------------------------------------------------
Implementing the Data Source Layer:
------------------------------------
>The first step to developing our data source layer is to define the requirements that this layer must fulfill.

Retrieve a list of all orders.
Retrieve a specific order based on its ID.
Create a new order.
Delete an existing order.
Update an existing order.

>These five operations are common among a vast majority of data sources, and unsurprisingly, follows the basic set of CRUD operations. In this particular case, we create a specialization of the read operation (the R in CRUD) by allowing a caller to supply an ID and retrieve only the order that corresponds to that ID (if such an order exists).

> we will include this specialized retrieval method in order to maintain a consistent interface with clients

>Since we will be using an in-memory persistence scheme, we cannot rely on a database to provide a new ID for each domain class that we persist. Instead, we will need to create an ID generator that will provide us with unique IDs for each of the Orders we will persist. 

Our implementation of this generator is as follows class: IdGenerator

>we have marked our generator as a Spring component using the @Component annotation. This annotation allows our Spring boot application to recognize (through component scanning) our generator class as an injectable component.

>We have also denoted that the scope of the generator (using the @Scope annotation) is PROTOTYPE, which ensures that a new object is created each time is it autowired.

>A second point is the use of AtomicLong to store our next ID, where two identical IDs may be produced. In order to eliminate these difficult-to-debug issues, we use the built-in concurrency mechanisms provided by Java,This ensures that even if two callers request IDs at the same time, each will be unique and the consistency of the next ID will be maintained.

>we will create an Abstract Base Class (ABC) that contains the core logic for managing our persisted objects 
by class: InMemoryRepository

>there is one piece of information that requires knowledge of the stored object to perform: an update if the object exists by class : OrderRepository

>As previously expressed, our domain objects do not have enough knowledge on how to perform an update on themselves, therefore, it is the responsibility of our data source to perform this update.

>we use the method: updateIfExists

>This concrete class simply provides an implementation for updating all non-ID fields of an Order. We have also decorated our class with the @Repository annotation, which is the same

 With the completion of our data source layer, we are ready to implement the final layer of our RESTful web service: the presentation layer.
============================================================================================================
part 3
------------------------------------------------------------------------------------------------------------
Implementing the Presentation Layer:
>Starting with the class that is the most depended on and requires the least dependencies, 
we will create : OrderResource class

>First, we inherit from the ResourceSupport class provided by the Spring HATEOAS packages, which allows us to attach links to our resource.

>A happy medium between the duplication between the OrderResource and Order classes is the use of Jackson annotations in order to use the fields of the Order class to act as the fields of theOrderResource class when the OrderResource class is serialized to JSON. 

>The default serialization process takes each of the fields of our class and uses the field names as the keys and the field values as the values. For example, a serialized Order class 

>With our resource class in place, we need to implement an assembler that will create anOrderResource class from an Order domain object

>We then create an OrderResourceAssembler class that provides an implementation for the toResource method:

>suppose we create a REST endpoint that allows a client to create, retrieve, update, and delete Order objects. In order to allow for Spring HATEOAS to help in the creation of links to delete and update Order objects, we must decorate the REST endpoint class with@ExposesResourceFor(Order.class).

> Using the EntityLinks class, we can create a link to our own resource by specifying (using the linkToSingleResource method) that we wish to create a link to an Order , which uses the Spring HATEOAS Identifiable interface to obtain the ID of the object. We then reuse this link to create three separate links: (1) a self link, (2) an update link, and (3) a delete link. 

>a REST endpoint is created by implementing a controller class (a class annotated with @Controller or @RestController) and adding methods that correspond to the desired REST endpoints. 

>The main method used to start our web service is as follows Application class

>Using Spring Boot, starting our web application is nearly trivial, which leaves us with only one thing left to do: Deploy and consume our RESTful web service. We will cover this deployment and testing process
==============================================================================================================
part 4
--------------------------------------------------------------------------------------------------------------
Running and Consuming the Web Service
-------------------------------------
>mvn spring-boot:run

GET
http://localhost:8080/order

POST
http://localhost:8080/order/post

request body:

{
    "description": "Our first test order",
    "costInCents": 450,
    "complete": false
}

PUT
http://localhost:8080/order/put/1

request update body:

{
    "description": "Our update test order",
    "costInCents": 500,
    "complete": false
}


GET with id
http://localhost:8080/order/getWithId/1

DELETE
http://localhost:8080/order/delete/1
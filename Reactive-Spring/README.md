- Reactive Microservice using Spring WebFlux
```
Reactive programming
Reactive streams specification - Publisher, Subscriber, Processor
Flow API
Project Reactor - Flux & Mono
Flux & Mono is a reactive type that implements the reactive streams specification
Flux & Mono are part of reactor-core module
Flux represent 0-n Elements
Mono represent 0-1 Elements
```
- Flux & Mono with Function
```
- Reactive test in junit
- Data Transfor: 
      map()
      filter()
      flatMap()
      concatMap()
      flatMapMany()
      transform()
      defaultifEmpty()
      switchifEmpty()
    Combain Flux & Mono using concat()
    merge(), mergeWith()
    zip() zipwith()

```
- Movie app :
```
services one - MoviesInfo(Name,cast,year) built using annotated controller
service two - MoviesReview(Rating, review)built using functional Endpoint
service three - MoviesServices(client interaction) built using annotated controller
db - mongoDB
Writting unit and intergation test for the reactive end points
```

- Netty:
```
Event Queue
Loop
Client --> channel ---> App
Channel lifecycle: 
    channelUnregistered
    channelRegistered
    channelActive
    channelInActive
```

- Functional Web :
```
Lambdas
methods References
Functional interface
Router - Rest Endpoint are configured
Handler - Code to handle the request is located
```
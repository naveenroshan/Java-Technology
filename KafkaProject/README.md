# Kafka Simple Project :

- Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines.

- In this Kafka Tutorial you will learn how to get up and running Kafka, Configure topics, Producers and Consumer. 

- We will use Spring Boot and build a Restful API that will integrate with Kafka eco system.
 
 
   # START THE KAFKA ENVIRONMENT
    # Start the ZooKeeper service
    # Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
        $ bin/zookeeper-server-start.sh config/zookeeper.properties

   # Start the Kafka broker service
        $ bin/kafka-server-start.sh config/server.properties

       - Recorded new controller, from now on will use broker localhost:9092

   # READ THE EVENTS
        $ bin/kafka-console-consumer.sh --topic kafkaDemo --from-beginning --bootstrap-server localhost:9092


    # Post request to Kafka from Rest API

            {
                "message": "Message from Rest API to Kafka"
            }
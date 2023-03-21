# kafka-publisher
zookeeper-server-start.bat C:\Pankaj\kafka_2.12-3.4.0\config\zookeeper.properties
kafka-server-start.bat C:\Pankaj\kafka_2.12-3.4.0\config\server.properties
kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 -topic welcomeTopic
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic welcomeTopic

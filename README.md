# activemq

```
git clone https://github.com/seniocaires/activemq.git
cd activemq
sudo docker-compose up
```

ActiveMQ Web Console

http://localhost:8161

usuario:senha => admin:admin


## Exemplos

#### 1000 Mensagens - Quee TEST

Mensagens enviadas => "test message: 1" ; "test message: 2" ; "test message: 3" ; ... ;"test message: 1000" ;

```
// Consumer
sudo docker exec -it activemq_activemq_1 java -jar activemq-all-5.15.3.jar consumer

// Producer
sudo docker exec -it activemq_activemq_1 java -jar activemq-all-5.15.3.jar producer
```

http://localhost:8161/admin/queues.jsp

#### Mensagem e quantidade personalizada - Quee TEST

```
// Consumer
sudo docker exec -it activemq_activemq_1 java -jar activemq-all-5.15.3.jar consumer

// Producer
sudo docker exec -it activemq_activemq_1 java -jar activemq-all-5.15.3.jar producer --message "Estou enviando uma mensagem" --messageCount 10
```

http://localhost:8161/admin/queues.jsp

#### Referências

http://activemq.apache.org/examples.html



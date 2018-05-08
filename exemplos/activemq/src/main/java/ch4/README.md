### Configurar Transport Connectors

Arquivo conf/activemq.xml

```
        <transportConnectors>
            <!-- DOS protection, limit concurrent connections to 1000 and frame size to 100MB -->
            <transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600&amp;trace=true"/>
            <transportConnector name="nio" uri="nio://0.0.0.0:61614?trace=true"/>
        </transportConnectors>
```

### Run Consumer

```
mvn exec:java -Dexec.mainClass=ch4.Consumer -Dexec.args="tcp://0.0.0.0:61616 CSCO ORCL"
```

### Run Publisher

```
mvn exec:java -Dexec.mainClass=ch4.Publisher -Dexec.args="tcp://0.0.0.0:61614 CSCO ORCL"
```

### Run Consumer

```
mvn exec:java -Dexec.mainClass=ch3.Consumer -Dexec.args="tcp://0.0.0.0:61616 CSCO ORCL"
```

### Run Publisher

```
mvn exec:java -Dexec.mainClass=ch3.Publisher -Dexec.args="tcp://0.0.0.0:61616 CSCO ORCL"
```
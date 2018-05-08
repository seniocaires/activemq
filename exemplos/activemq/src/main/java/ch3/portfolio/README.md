### Run Consumer

```
mvn exec:java -Dexec.mainClass=ch3.portfolio.Consumer -Dexec.args="CSCO ORCL"
```

### Run Publisher

```
mvn exec:java -Dexec.mainClass=ch3.portfolio.Publisher -Dexec.args="CSCO ORCL"
```
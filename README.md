# Optimizely-java

Compile with:  

`mvn clean compile`

Run with:  

`mvn exec:java -Dexec.mainClass=com.example.App -Dorg.slf4j.simpleLogger.defaultLogLevel=debug`

App hangs and timesout on line 50:   

`Optimizely optimizelyClient = OptimizelyFactory.newDefaultInstance(sdkKey);`

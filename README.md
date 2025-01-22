# Optimizely-java

Compile with: 
mvn clean compile

Run with:
mvn exec:java -Dexec.mainClass=com.example.App -Dorg.slf4j.simpleLogger.defaultLogLevel=debug

App hangs on line: "Optimizely optimizelyClient = OptimizelyFactory.newDefaultInstance(sdkKey);"

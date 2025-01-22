# Optimizely-java

Compile with:  

`mvn clean compile`

Run with:  

`mvn exec:java -Dexec.mainClass=com.example.App -Dorg.slf4j.simpleLogger.defaultLogLevel=debug`

App hangs and timesout on line 50:   

`Optimizely optimizelyClient = OptimizelyFactory.newDefaultInstance(sdkKey);`   

Example run:
`[com.example.App.main()] INFO com.example.App - Hello World!
[com.example.App.main()] DEBUG com.optimizely.ab.internal.PropertyUtils - Optimizely properties file not found in filesystem or classpath: 'optimizely.properties'.
[com.example.App.main()] DEBUG com.optimizely.ab.OptimizelyHttpClient - Creating HttpClient with timeout: 10000
[pool-1-thread-1] DEBUG com.optimizely.ab.config.HttpProjectConfigManager - Fetching datafile from: https://cdn.optimizely.com/datafiles/BsXrTeB2Cv7ACQAFJWjsA.json
[pool-1-thread-1] INFO com.optimizely.ab.config.parser.DefaultConfigParser - using json parser: JacksonConfigParser
[com.example.App.main()] WARN com.optimizely.ab.config.PollingProjectConfigManager - Timeout exceeded waiting for ProjectConfig to be set, returning null.
[com.example.App.main()] DEBUG com.optimizely.ab.OptimizelyHttpClient - Creating HttpClient with timeout: 10000
[com.example.App.main()] DEBUG com.optimizely.ab.OptimizelyHttpClient - Creating HttpClient with timeout: 10000
[com.example.App.main()] INFO com.example.App - Optimizely client invalid. Verify in Settings>Environments that you used the primary environment's SDK key
[com.example.App.main()] INFO com.optimizely.ab.event.BatchEventProcessor - Start close
[pool-3-thread-1] INFO com.optimizely.ab.event.BatchEventProcessor - Received shutdown signal.
[pool-3-thread-1] INFO com.optimizely.ab.event.BatchEventProcessor - Exiting processing loop. Attempting to flush pending events.
[com.example.App.main()] INFO com.optimizely.ab.event.AsyncEventHandler - event handler shutting down. Attempting to dispatch previously submitted events
[com.example.App.main()] INFO com.optimizely.ab.event.AsyncEventHandler - event handler shutdown complete
[com.example.App.main()] INFO com.optimizely.ab.config.PollingProjectConfigManager - pausing project watcher
[com.example.App.main()] DEBUG com.optimizely.ab.odp.ODPEventManager - Sending stop signal to ODP Event Dispatcher Thread
[pool-4-thread-1] INFO com.optimizely.ab.odp.ODPEventManager - Received shutdown signal.
[pool-4-thread-1] DEBUG com.optimizely.ab.odp.ODPEventManager - Exiting ODP Event Dispatcher Thread.
[DEBUG] interrupting thread Thread[pool-3-thread-1,5,com.example.App]
[DEBUG] interrupting thread Thread[pool-4-thread-1,5,com.example.App]
[DEBUG] joining on thread Thread[pool-3-thread-1,5,com.example.App]
[WARNING] thread Thread[pool-3-thread-1,5,com.example.App] was interrupted but is still alive after waiting at least 14999msecs
[WARNING] thread Thread[pool-3-thread-1,5,com.example.App] will linger despite being asked to die via interruption
[WARNING] thread Thread[pool-4-thread-1,5,com.example.App] will linger despite being asked to die via interruption
[WARNING] NOTE: 2 thread(s) did not finish despite being asked to via interruption. This is not a problem with exec:java, it is a problem with the running code. Although not serious, it should be remedied.
[WARNING] Couldn't destroy threadgroup org.codehaus.mojo.exec.ExecJavaMojo$IsolatedThreadGroup[name=com.example.App,maxpri=10]
java.lang.IllegalThreadStateException
    at java.lang.ThreadGroup.destroy (ThreadGroup.java:803)
    at org.codehaus.mojo.exec.ExecJavaMojo.execute (ExecJavaMojo.java:330)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:126)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2 (MojoExecutor.java:328)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute (MojoExecutor.java:316)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:212)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:174)
    at org.apache.maven.lifecycle.internal.MojoExecutor.access$000 (MojoExecutor.java:75)
    at org.apache.maven.lifecycle.internal.MojoExecutor$1.run (MojoExecutor.java:162)
    at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute (DefaultMojosExecutionStrategy.java:39)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:159)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:105)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:73)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:53)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:118)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:261)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:173)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:101)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:906)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:283)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:206)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:77)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:569)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)`  

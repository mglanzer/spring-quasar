spring-quasar
======

Playing around with Spring Boot, Kotlin, Comsat/Quasar, and postgresql.
------

- Spring Boot - Java application/MVC framework
- Kotlin - JVM language by Jet Brains
- Quasar - Enables Fibers (co-routines, green-threads) which are a very light-weight thread abstractions. 
- Comsat - Adapter layer enabling Quasar Fibers on various platforms
- Postgres - An advanced, open-source relational database.

## Running

To enable Fiber-backed controller methods the Quasar java agent must be enabled via JVM argument:
```
-javaagent:build/resources/main/java-agents/quasar-core-0.7.6.jar
```

There is another way to make this work with embedded Tomcat, but the method above seemed pretty simple.  
The docs: http://docs.paralleluniverse.co/comsat/.
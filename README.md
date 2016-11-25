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

To enable Fiber-backed controller the quasar class loader is specified in src/main/webapp/META-INF/context.xml:
```
<Loader loaderClass="co.paralleluniverse.comsat.tomcat.QuasarWebAppClassLoader" />
```

Another, more general, method is to enable the Quasar java agent via JVM argument:
```
-javaagent:build/resources/main/java-agents/quasar-core-0.7.6.jar
```

Comsat docs: http://docs.paralleluniverse.co/comsat/.
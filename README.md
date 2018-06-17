# Todo List App using Android Architecture Components

This is just a sample app to demonstrate how Android Architecture Components is implemented. 

Android Architecture Components is a set of libraries that helps to create modular applications, so the code 
is easier to maintain and reused. It also prevents common errors, such as memory leaks, and reduce the
amount of boiler plate. 

The main components include: 

* Room - a SQLite ORM library
* LiveData - observes changes in the database 
* ViewModel - caches data that needs to survive to configuration changes
* LifeCycle - allows non-lifeCycle objects to be lifecycle aware

## Room

Content Providers are one of the 4 main components of Android applications. They have some nice 
advantages that you want include in the application, for the rest that you want to include, there
is Room. 

Room is an Object Relational Mapping library. It will map the database objects to Java objects. With Room
you'll write less boilerplate and SQL validation at compile time. 

It's also built to work with LiveData and RxJava for data observation. 

Room uses annotations and its main components are: 

* @Entity - defines database tables
* @DAO - Data Access Object - provides an API for reading and writing data 
* @Database - represents a database holder (it includes a list of entities and DAOS and allows to create
new databases or to acquire a connection to our db at runtime)

## DAO - Data Access Object 

It specifyies SQL queries and associate them with method calls. The compiler checks the SQL and generates 
queries from convenience annotations for common queries, such as @Insert. The DAO must be an interface or abstract class, and
by default, all queries must be executed on a separate thread.

Room uses the DAO to create a clean API for your code.

## Database 


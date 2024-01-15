This is a boilerplate project to start playing with Spark in Scala using Java for driver startup and maven for build.  
You can point csv file to be processed from local, using:  
-path &#60;path&#62;  
or dropbox using:  
-path &#60;path&#62;  -dropbox -token&#60;token&#62;  
like:  
***-path
/testfolder/organizations-1000.csv
-dropbox
-token
sl.BtsX-aBN26HBA0Jme_RD7hkOqrdiFasE-aRNB-mwHTT9RL4MQiUyB87mJ5KOsX1AaBf93DZF2YAr5PKfA6IdPeX6RqHfvsgRO5QpXCuOLSRdo8esmU0fuzGZgyRE9lKwjwnFt1x9sJfC***

Java 11, Scala 2.13.8, Spark 3.5.0 used.  
You can start it using .sh script (need to have spark installed locally) found in src\main\resources   
or as a standard Java application (in IntelliJ mark 'Add dependencies with 'provided' scope to classpath').
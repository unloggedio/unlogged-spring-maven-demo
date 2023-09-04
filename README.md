# Unlogged Demo

This is a springboot project meant to be a playground for unlogged.
The dependencies are already setup for this project, you can clone this repository and get started.

To install unlogged's dependencies if needed.
1. Add unlogged-sdk to ```pom.xml```.
   The dependency :
   ```agsl
   <dependency>
   <artifactId>unlogged-sdk</artifactId>
   <groupId>video.bug</groupId>
   <version>0.0.26</version>
   </dependency>
   ```
   For certain maven projects the following might be needed (JDK 9+)
   ```agsl
   <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <configuration>
         <annotationProcessorPaths>
               <annotationProcessorPath>
                  <artifactId>unlogged-sdk</artifactId>
                  <groupId>video.bug</groupId>
                  <version>0.0.26</version>
               </annotationProcessorPath>
         </annotationProcessorPaths>
      </configuration>
   </plugin>
   ```

2. Add ```@Unlogged``` annotation over the main method of the project/module you want to run.
   Like :
   ```java
   @SpringBootApplication
   public class UnloggedDemoApplication {

   @Unlogged
   public static void main(String[] args) {
   SpringApplication.run(UnloggedDemoApplication.class, args);
   }
   ```
}

3. Then clean and build your project.

   `mvn clean`

   
   Start your project in **Debug mode** from intelliJ idea and enjoy.



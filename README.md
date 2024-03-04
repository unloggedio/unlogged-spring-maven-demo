# Springboot Mega Application (Maven)

This application tries to use every spring 3rd party integration available with a maven spring project as it's base.

This project meant to be a playground for testing Unlogged SDK and Plugin.

The dependencies are already setup for this project, you can clone this repository and get started.

Add unlogged-sdk dependency
1. Add unlogged-sdk to ```pom.xml```.
   The dependency :
   ```agsl
   <dependency>
   <artifactId>unlogged-sdk</artifactId>
   <groupId>video.bug</groupId>
   <version><--LATEST VERSION --></version>
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
                  <version><--LATEST VERSION --></version>
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

**Additional requirements :**
- You will need an instance of mysql running locally. Create a database with the same name as the one in ```Application.properties``` to get started.
- Make sure you also have redis installed and running.

   Start your project in **Debug mode** from intelliJ idea and enjoy.

4. Hitting endpoints
- Generate a auth token:
```shell
   curl -X POST http://localhost:8080/auth/login \ 
  -H 'Content-Type: application/json' \
  -d '{
  "email": "amg@amg.com",
  "password": PASSWORD_FROM_DOCKER_ENV
  }'
```
- Use the token generated token above for hitting all other endpoints
```shell
curl -H "Authorization: Bearer AUTH_TOKEN_GENERATED_ABOVE"\
 "http://localhost:8080/customer/get?customerID=0"
```

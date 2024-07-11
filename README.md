# safous-waap-sdk-java-example

## Getting started

1. Download Java SDK from the Admin Portal and put the SDK to libs directory.
2. Modiry the example source code. Change the URL according to your environment.
   - [ExampleAccessBackendEcho.java#L30](src/main/java/com/example/app/ExampleAccessBackendEcho.java#L30)
   - [ExampleAccessBackendSimple.java#L30](src/main/java/com/example/app/ExampleAccessBackendSimple.java#L30)
   - [ExampleTerminate.java#L30](src/main/java/com/example/app/ExampleTerminate.java#L30)
3. Build the example source code.
   ```
   mvn clean install
   ```
4. Put your client certificate(PKCS#12 format) to the target.
5. Copy an example safouswaap.ini and modify it according to your environment.
   ```
   cp safouswaap.ini.example target/safouswaap.ini
   ```
6. Modify it according to your environment.
   ```
   vi target/safouswaap.ini
   ```
   E.g.
   ```
   [config]
   app_id = default
   auth_endpoint = https://waap-auth.example-waap.waap.safous.com
   register_endpoint = https://waap-register.example-waap.waap.safous.com
   verify_endpoint = https://waap-client-verification.example-waap.waap.safous.com
   cert_path = test.p12
   cert_passphrase = PASSPHRASE_FOR_CLIENT_CERTIFICATE
   ```
7. Move to target directory.
   ```
   cd target
   ```
8. Run registration example.
   ```
   java -cp ./libs/*:safous-waap-example.jar com.example.app.ExampleRegistration
   ```
9. Run transaction example with simple-web.
   ```
   java -cp ./libs/*:safous-waap-example.jar com.example.app.ExampleAccessBackendSimple
   ```
10. Run transaction example with echo.
    ```
    java -cp ./libs/*:safous-waap-example.jar com.example.app.ExampleAccessBackendEcho
    ```
11. Run terminate example.
    ```
    java -cp ./libs/*:safous-waap-example.jar com.example.app.ExampleTerminate
    ```


# code-examples
code-examples is a collection of java based applications. Each concept is placed under its own package.

## Installation
Install latest JDK and Maven and import these projects to your favorite IDE

## Usage

### Hexagonal-architecture
Run the application as SpringBoot and access the API with the endpoint - http://localhost:8080/api/account/<account number> (5678 or 1234)
  
## Axon
  
Run the application as SpringBoot and access the API with the curl
`curl -H "Content-Type: application/json" -X POST -d '{"orderId":"2121","orderAmount":10}' http://localhost:8080/order`
  
MongoDB should be up and running for the application to work, default configuartion localhost:27017 is used in code, update the code if your setting is different.

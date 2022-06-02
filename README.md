
An open source SDK for Beckn protocol 
==========================================

Did you know you can make you products Beckn enabled within 15 minutes? 
All you need to do is ready you applications, leave the Beckn part to us and be a part of the Innovative Initiative 'Beckn Protocol'.

This sdk includes following Beckn services:

- Network-facing Transport Service : This layer sends/receives requests to/from a beckn-enabled network
- Request handling service : This performs request handling services like signing, signature verification, encryption/decryption (If needed)
- Payload processing service : This performs protocol schema level validation and network policy validation
- Network Subscription Service : This manages all interactions with the network registry
- Policy integration service : This manages all interactions with the Policy Registry (Specification under development)
- Client-facing Transport Service : This layer sends/receives requests to/from a client running on the machine

## Architecture and Philosophy behind this sdk
Low-code is a software development approach that requires little to no coding in order to build applications and processes. We are using the same approach in our 
Beckn sdk development where developers can use this sdk and build their application without worrying about writing beckn protocol specific codes. 

### Library used for low-code integration
- <b>Apache Camel</b> - Camel is an Open Source integration framework that empowers you to quickly and easily integrate various systems consuming or producing data.
- <b>Open Policy Agent</b> -  to manages all interactions with the Policy Registry.

## Prerequisites

1. Java 11+
2. Maven 3.8+

## Build

You can build this example using

```
    mvn compile
```

## Run the example

Using maven:

 1. Start the sdk:

```
  $ mvn spring-boot:run
```

## Web console

You can open the web console

```
    -to do
```

## Help and contributions

-to do



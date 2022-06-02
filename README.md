
An open source sdk for Beckn protocol 
==========================================

Did you know you can make your products Beckn enabled within 15 minutes? 
All you need to do is ready your applications, leave the Beckn part to us and be a part of the Innovative Initiative *'Beckn Protocol'.*

This sdk includes following Beckn services:

- <b>Network-facing Transport Service</b>: This layer sends/receives requests to/from a beckn-enabled network
- <b>Request Handling Service</b>: This performs request handling services like signing, signature verification, encryption/decryption (If needed)
- <b>Payload Processing Service</b>: This performs protocol schema level validation and network policy validation
- <b>Network Subscription Service</b>: This manages all interactions with the network registry
- <b>Policy Integration service</b>: This manages all interactions with the Policy Registry (Specification under development)
- <b>Client-facing Transport Service</b>: This layer sends/receives requests to/from a client running on the machine

## Architecture and Philosophy behind this sdk
Low-code is a software development approach that requires little to no coding to build applications and processes. We are using the same approach in our 
Beckn SDK development where developers can use this sdk and build their application without worrying about writing beckn protocol-specific codes. 

### Frameworks/Libraries used for low-code integration
- [<b>Apache Camel</b>](https://camel.apache.org/)
: Camel is an Open Source integration framework that empowers us to quickly and easily integrate various systems consuming or producing data.
- [<b>Open Policy Agent</b>](https://www.openpolicyagent.org/) :  To manages all interactions with the Policy Registry, an open source, general-purpose policy engine that unifies policy enforcement across the stack.

## Components used in this sdk 
1. [<b>Jetty</b>](https://camel.apache.org/components/next/jetty-component.html) : The Jetty component provides HTTP-based endpoints for consuming and producing HTTP requests. That is, the Jetty component behaves as a simple Web server.
2. [<b>JMS</b>](https://camel.apache.org/components/next/jms-component.html) : This component allows messages to be sent to (or consumed from) a JMS Queue or Topic. It uses Spring’s JMS support for declarative transactions, including Spring’s JmsTemplate for sending and a MessageListenerContainer for consuming.
4. [<b>JSON Schema Validator</b>](https://camel.apache.org/components/next/json-validator-component.html) : The JSON Schema Validator component performs bean validation of the message body against JSON Schemas
5. [<b>Wire Tap</b>](https://camel.apache.org/components/next/json-validator-component.html) : Wire Tap allows to route messages to a separate location while they are being forwarded to the ultimate destination (Used for all callback ACK)
6. [<b>Velocity</b>](https://camel.apache.org/components/next/velocity-component.html) : The Velocity component allows us to process a message using an Apache Velocity template. This can be ideal when using Templating to generate responses for requests.So we used this for all beckn request response generation.
7. [<b>CRYPTO (JCE)</b>](https://camel.apache.org/components/next/crypto-component.html) : With Camel cryptographic endpoints and Java’s Cryptographic extension it is easy to create Digital Signatures for Exchanges. Camel provides a pair of flexible endpoints which get used in concert to create a signature for an exchange in one part of the exchange’s workflow and then verify the signature in a later part of the workflow.
## Prerequisites

1. Java 11+
2. Maven 3.8+

## Build

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



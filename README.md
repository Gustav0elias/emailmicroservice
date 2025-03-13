# Email Microservice

A microservice responsible for handling email communications based on order status changes.

## Overview

This microservice is designed to send and track emails based on events received through messaging systems. It implements a clean architecture pattern with clear separation between domain, application, and infrastructure layers.

## Architecture

- **Domain Layer**: Contains core business logic and interfaces
  - Models: `EmailSent`
  - Ports: `EmailSentService`, `EmailSentRepository`

- **Application Layer**: Contains service implementations
  - Services: `EmailSentServiceImpl`

- **Infrastructure Layer**: Contains external implementations
  - Messaging: `OrderStatusConsumer`
  - Repository implementations
  - Message queue integration

## Features

- Consumes order status events from message queue
- Sends email notifications based on order status changes
- Persists email sending history
- Logging system integration using SLF4J

## Technical Stack

- Java
- Spring Boot
- Message Queue System
- SLF4J for logging
- Repository pattern for data persistence

## Getting Started

1. Clone the repository
2. Configure your application.properties/yaml with required settings
3. Build the project:
```bash
mvn clean install
```

## Usage

The service automatically processes incoming order status messages and sends corresponding emails. The `EmailSentServiceImpl` handles the business logic for saving email records.

## Configuration

Configure the following properties in your application configuration file:

- Database connection
- Message queue settings
- Email server settings
- Logging levels

## Logging

The service uses SLF4J for logging, with different log levels for various operations:
- INFO: Standard operations like email sending
- ERROR: Failed operations and exceptions

## Dependencies

- Spring Boot
- Spring Cloud (for microservice support)
- Database driver
- Message Queue client
- SLF4J

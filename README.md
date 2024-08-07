# MAX30100 Spring Boot API

![MAX30100](https://example.com/path-to-image.jpg)

## Introduction

This project provides an API for interacting with the MAX30100 sensor using Spring Boot. The MAX30100 sensor is a pulse oximetry and heart-rate monitor module. The API allows users to read data from the sensor, such as heart rate and SpO2 levels, and perform various operations.

## Features

- Read heart rate data
- Read SpO2 (blood oxygen saturation) data
- Store sensor data in the database
- Retrieve stored data for analysis

## Technologies Used

- Java
- Spring Boot
- MySQL (or any other supported database)
- Maven

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher
- Maven
- MySQL database (or other supported databases)

## Getting Started

### Clone the Repository


git clone https://github.com/nguyenxvotanminh3/Api_Max30100_Springboot.git
cd Api_Max30100_Springboot
##Configure the Database
Update the application.properties file located in src/main/resources with your database configuration:
properties
Copy code
-spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
-spring.datasource.username=your_database_username
-spring.datasource.password=your_database_password
-spring.jpa.hibernate.ddl-auto=update
-spring.jpa.show-sql=true


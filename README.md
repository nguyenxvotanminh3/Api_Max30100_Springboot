I'd be glad to create a beautiful and informative README for your MAX30100 Spring Boot API project, incorporating the best aspects of the provided information and addressing any shortcomings:

MAX30100 Spring Boot API

Introduction

This project provides a user-friendly API for interacting with the MAX30100 pulse oximetry and heart-rate monitor module using Spring Boot. It empowers you to extract health data like heart rate and SpO2 levels (blood oxygen saturation) from the sensor, perform various operations, and potentially analyze health trends.

Key Features:

Real-time Data Retrieval: Effortlessly access real-time heart rate and SpO2 readings from the MAX30100 sensor.
Secure Data Storage: Store sensor data in a secure database (MySQL or other supported) for future analysis and tracking.
Historical Data Retrieval: Seamlessly retrieve previously stored data to gain insights into health trends over time (requires database connection).
Intuitive API Endpoints: Interact with the API using well-defined endpoints for clear and efficient data access and manipulation.
Technologies Used:

Java
Spring Boot (rapid application development framework)
MySQL (or other supported database for data persistence)
Maven (build automation tool)
Prerequisites:

Java Development Kit (JDK) 8 or higher: Download and install from the official Java website (https://www.oracle.com/java/technologies/javase-downloads.html).   
Maven: Download and install from the official Apache Maven website (https://maven.apache.org/).
MySQL Database (or other supported database): Install and configure a database server of your choice (e.g., MySQL, PostgreSQL). For MySQL, refer to the official documentation (https://dev.mysql.com/doc/).
Getting Started

Clone the Repository:

Bash
git clone https://github.com/nguyenxvotanminh3/Api_Max30100_Springboot.git
cd Api_Max30100_Springboot


Configure the Database:

Update the application.properties file (located in src/main/resources) with your specific database credentials:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username   

spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update   
  # Adjust if needed for database schema management
spring.jpa.show-sql=true             # Optional: Enables SQL logging for debugging


Build the Project:

Bash
mvn clean install

Run the Application:

Bash
mvn spring-boot:run


The application will start and be accessible at http://localhost:8080.   

API Endpoints

Get Heart Rate Data (GET /api/v1/heart-rate): Retrieves the current heart rate reading from the sensor.

Response (JSON):

JSON
{
    "heartRate": 72
}


Get SpO2 Data (GET /api/v1/spo2): Retrieves the current blood oxygen saturation (SpO2) level.

Response (JSON):

JSON
{
    "spo2": 98
}


Store Sensor Data (POST /api/v1/sensor-data): Stores heart rate, SpO2, and timestamp data in the database.

Request Body (JSON):

JSON
{
    "heartRate": 72,
    "spo2": 98,
    "timestamp": "2024-08-07T18:32:00Z"
}


Response (JSON):

JSON
{
    "message": "Data stored successfully"
}


Retrieve Stored Data (GET /api/v1/sensor-data): Retrieves all stored sensor data entries from the database (requires database connection).

Response (JSON Array):

JSON
[
    {
        "heartRate": 72,
        "spo2": 98,
        "timestamp": "2023-08-05T12:00:00Z"
    },
    ...
]

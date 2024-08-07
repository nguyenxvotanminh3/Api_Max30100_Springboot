MAX30100 Spring Boot API
Introduction
This project provides an API for interacting with the MAX30100 sensor using Spring Boot. The MAX30100 sensor is a pulse oximetry and heart-rate monitor module. The API allows users to read data from the sensor, such as heart rate and SpO2 levels, and perform various operations.

Features
Read heart rate data
Read SpO2 (blood oxygen saturation) data
Store sensor data in the database
Retrieve stored data for analysis
Technologies Used
Java
Spring Boot
MySQL (or any other supported database)
Maven
Prerequisites
Before you begin, ensure you have met the following requirements:

Java Development Kit (JDK) 8 or higher
Maven
MySQL database (or other supported databases)
Getting Started
Clone the Repository
bash
Copy code
git clone https://github.com/nguyenxvotanminh3/Api_Max30100_Springboot.git
cd Api_Max30100_Springboot
Configure the Database
Update the application.properties file located in src/main/resources with your database configuration:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build the Project
Use Maven to build the project:

bash
Copy code
mvn clean install
Run the Application
Run the Spring Boot application:

bash
Copy code
mvn spring-boot:run
The application will start and be accessible at http://localhost:8080.

API Endpoints
Get Heart Rate Data
http
Copy code
GET /api/v1/heart-rate
Response:

json
Copy code
{
  "heartRate": 72
}
Get SpO2 Data
http
Copy code
GET /api/v1/spo2
Response:

json
Copy code
{
  "spo2": 98
}
Store Sensor Data
http
Copy code
POST /api/v1/sensor-data
Request Body:

json
Copy code
{
  "heartRate": 72,
  "spo2": 98,
  "timestamp": "2023-08-05T12:00:00Z"
}
Response:

json
Copy code
{
  "message": "Data stored successfully"
}
Retrieve Stored Data
http
Copy code
GET /api/v1/sensor-data
Response:

json
Copy code
[
  {
    "heartRate": 72,
    "spo2": 98,
    "timestamp": "2023-08-05T12:00:00Z"
  },
  ...
]
Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

License
This project is licensed under the MIT License.

Contact
If you have any questions or need further assistance, feel free to contact me at nguyenminh@example.com.

Feel free to customize this README to better fit your project's specifics and requirements.

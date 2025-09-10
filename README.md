# Weather Application

This project is created to simulate a functioning weather service application using Spring Boot. The intention of this project is to practice Spring Boot best practices in developing APIs and also gain hands on experience with Redis (WIP)

Skills to be shown: 
- Building REST API endpoints 
- Consuming external APIs
- Using Lombok to reduce boiler plates 
- Using POJO for model classes 
- Secure programming 
  - hiding API keys using environment variables
  - Preventing API abuse (WIP)
- Building a MVC application 
  - View is currently not a priority
- Redis caching

# Table of contents
- [Weather Application](#weather-application)
- [Table of contents](#table-of-contents)
- [Quick Start guide](#quick-start-guide)
- [Where does the weather data come from?](#where-does-the-weather-data-come-from)

# Quick Start guide 
1. Ensure that you have the required software installed

    - Java JDK: 21
        ```
        java -version
        ```
    - Maven (Optional)
        ```
        mvn -version
        ```

2. Clone this Git repository 
    
    ```
    git clone https://github.com/lywich/weatherApplication.git
    ```

3. Set your API key as your environment variable in your Command line

    Do refer to the [section with regards to the API data](#where-does-the-weather-data-come-from) for more information regarding the API key.
   
    - macOS/Linux:
    ```
    export WEATHER_API_KEY=your_actual_api_key
    ```

    - Windows (Powershell):
    ```
    $Env:WEATHER_API_KEY="your_actual_api_key"

    ```

4. Run the application 

    4.1 Run Redis 

     - 4.1.1 On a Windows machine with Docker Desktop 
         - Run the below command in Powershell to pull the latest version of redis

            ```
            docker pull redis
            ```
         - Run the below command in Powershell with the name "redis-cache" at port 6379

            ```
            docker run -d --name redis-cache -p 6379:6379 redis
            ```

         - Run the below command in Powershell to start up the cli
            ```
            docker exec -it redis-cache redis-cli
            ```

         - Run the below command in the same cli to flush any existing data in the cache

            ```
            flushall
            ```
    
    4.2 Run the application

      - 4.2.1 If maven is installed
        ```
        mvn spring-boot:run
        ```
      - 4.2.2 If maven is not installed
        ```
        ./mvnw spring-boot:run
        ```

    4.3 Check if the application if working my going to the following url link. Please see [WeatherController.java](src/main/java/com/weatherAPI/weatherApplication/controller/WeatherController.java) for token limit and refill rate (Initial capacity of 5 with a refill rate of 1/min).
    ```
    http://localhost:8080/weather?location=Singapore
    ```

# Where does the weather data come from?

Please refer to this [link](https://www.visualcrossing.com/weather-api/) for access to the API data. Do note that you may have to create an account to gain an API key to use this application. 
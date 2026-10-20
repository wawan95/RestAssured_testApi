# REST Assured API Automation Testing

A sample REST API automation testing project built with **Java, REST Assured, JUnit 5, and Maven**. This project demonstrates how to automate API tests, validate HTTP status codes, and verify JSON response data using the Given–When–Then approach.

## Tech Stack

| Technology | Version / Purpose |
|---|---|
| Java | 17 |
| REST Assured | 5.5.0 |
| JUnit 5 | 5.11.4 |
| Apache Maven | Dependency management and test execution |
| JSONPlaceholder | Public demo REST API |

## Features

- REST API testing using REST Assured
- HTTP request methods: GET, POST, PUT, and DELETE
- HTTP status code validation
- JSON response body assertions
- Content type validation
- Query parameter testing
- Positive and negative test scenarios
- Automated test execution with JUnit 5
- Test reports using Maven Surefire

## Project Structure

```text
RestAssured_testApi/
├── src/
│   └── test/
│       └── java/
│           └── tests/
│               └── UserApiTest.java
├── pom.xml
├── README.md
└── target/
    └── surefire-reports/
```

## Prerequisites

Make sure the following tools are installed:

- [Java JDK 17](https://adoptium.net/)
- [Apache Maven](https://maven.apache.org/download.cgi)
- IntelliJ IDEA or Visual Studio Code
- Internet connection to access the demo API

Verify your installation:

```bash
java -version
mvn -version
```

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/wawan95/RestAssured_testApi.git
cd RestAssured_testApi
```

### 2. Run all test cases

```bash
mvn clean test
```

### 3. Run a specific test class

```bash
mvn -Dtest=UserApiTest test
```

### 4. View test results

After execution, check the generated reports in:

```text
target/surefire-reports/
```

Open the `.txt` file to review the test summary or the `.xml` file for structured test results.

## API Under Test

**Base URL:** `https://jsonplaceholder.typicode.com`

| Method | Endpoint | Test objective |
|---|---|---|
| GET | `/users` | Retrieve the user list |
| GET | `/users/1` | Retrieve a user by ID |
| POST | `/posts` | Test post creation |
| PUT | `/posts/1` | Test post update |
| DELETE | `/posts/1` | Test post deletion |
| GET | `/posts/1` | Validate post response fields |

*Note: JSONPlaceholder is a mock API. POST, PUT, and DELETE requests simulate API operations and do not permanently modify the underlying data.*

## Example Test

```java
@Test
void shouldGetUserSuccessfully() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("id", equalTo(1))
        .body("name", equalTo("Leanne Graham"));
}
```

This test sends a GET request and verifies the HTTP status code and returned JSON values.

## Testing Approach

The project follows the **Given–When–Then** pattern:

- **Given:** Configure the request, URL, headers, and payload.
- **When:** Send the HTTP request to the API.
- **Then:** Validate the response status, body, and other expected results.

## Learning Objectives

This project demonstrates practical knowledge of:

- REST API automation testing
- Java-based test scripting
- HTTP methods and status codes
- JSON response validation
- Assertions using Hamcrest matchers
- Maven test execution and reporting

## Future Improvements

- Add authentication and bearer token testing.
- Implement reusable request specifications.
- Add JSON Schema validation.
- Integrate Allure reporting.
- Configure CI/CD using GitHub Actions or Jenkins.

## Author

**Sugeng Kurniawan**
GitHub: [@wawan95](https://github.com/wawan95)

LinkedIn: [Sugeng Kurniawan](https://www.linkedin.com/in/sugeng-kurniawan/) 

*This project is developed for learning, practice, and portfolio purposes.*

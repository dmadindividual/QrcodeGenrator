
---

# QR Code Generator for Students

This project is a Spring Boot application that generates QR codes for student data. The application exposes an API endpoint to retrieve a list of students, and for each student, it automatically generates a QR code containing their details (ID, name, email, and phone number). The QR code is saved as an image file on the local machine.

## Features

- **QR Code Generation**: Automatically generates QR codes for each student containing their personal information.
- **RESTful API**: Provides an API endpoint (`/students`) to retrieve a list of all students and generate QR codes on the fly.
- **File Handling**: Saves QR codes as PNG images to a specified folder on the system.
- **Scalability**: Easily extendable to generate and manage QR codes for other entities.

## Technologies Used

- **Java** (with Spring Boot)
- **ZXing**: A library for encoding and generating QR codes.
- **Maven**: Build and dependency management tool.
- **REST API**: Exposes endpoints to interact with the student data and trigger QR code generation.

## Getting Started

### Prerequisites

Before running the application, ensure you have the following installed:

- Java 11 or higher
- Maven
- A text editor or IDE (IntelliJ, Eclipse, etc.)

### Dependencies

This application uses the following dependencies:

- **Spring Boot** for building the REST API.
- **ZXing** for QR code generation.

If you're using Maven, make sure the following dependencies are included in your `pom.xml` file:

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- ZXing Core for QR code generation -->
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>core</artifactId>
        <version>3.4.1</version>
    </dependency>

    <!-- ZXing JavaSE for saving the QR code as an image -->
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>javase</artifactId>
        <version>3.4.1</version>
    </dependency>
</dependencies>
```

### Installation and Running the Program

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/qrcode-generator.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd qrcode-generator
   ```

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:
   - Open your browser or Postman and go to `http://localhost:8080/students` to retrieve a list of students and generate QR codes.

### QR Code Output

Each student's QR code will be saved as a PNG file in the following directory on your local system:

```
C:\Users\AYOMIDE\Pictures\Qrcode\
```

The file name format is: `{studentName}{studentId}-QRCODE.png`.

For example, a student named "John" with ID "123" would have a QR code saved as:
```
C:\Users\AYOMIDE\Pictures\Qrcode\John123-QRCODE.png
```

### API Overview

- **GET /students**: Retrieves a list of all students from the database. For each student, it generates a QR code and saves it to the specified folder.

### Sample Response

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "mobile": "1234567890",
    "qrcodePath": "C:\\Users\\AYOMIDE\\Pictures\\Qrcode\\JohnDoe1-QRCODE.png"
  },
  {
    "id": 2,
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "mobile": "0987654321",
    "qrcodePath": "C:\\Users\\AYOMIDE\\Pictures\\Qrcode\\JaneDoe2-QRCODE.png"
  }
]
```

### Customization

- **Change QR Code Path**: To change the default directory where the QR codes are saved, modify the `path` variable in the `QRcodes` class.
- **Adjust QR Code Size**: The QR code size is set to `400x400` pixels. You can modify this by changing the width and height in the `BitMatrix` creation.

### Future Improvements

- **Database Integration**: Currently, student data is fetched from an in-memory service. You can extend this to connect to a database (e.g., MySQL, PostgreSQL) to fetch real student data.
- **Error Handling**: Additional error handling and validation can be implemented for edge cases like missing data.
- **QR Code Retrieval**: Consider adding an endpoint to directly download or view the generated QR codes from the server.

## Contributing

Feel free to fork this repository and submit pull requests for improvements or new features.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

Let me know if you'd like any further customization or updates!

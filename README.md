# British Time Converter

A Java program to convert digital time (HH:mm) into British spoken form (e.g., "2:30" becomes "half past two").

## Dependencies

The project includes required JUnit 5 dependencies in the `lib/` directory:
- junit-jupiter-api-5.10.0.jar
- junit-jupiter-engine-5.10.0.jar
- junit-jupiter-params-5.10.0.jar
- junit-platform-commons-1.10.0.jar
- junit-platform-console-standalone-1.10.0.jar
- opentest4j-1.3.0.jar

These JARs are included in the repository for ease of setup and running tests.

## Project Structure
```
british-time-converter/
├── lib/                    # JUnit dependencies
│   ├── junit-jupiter-api-5.10.0.jar
│   ├── junit-jupiter-engine-5.10.0.jar
│   ├── junit-jupiter-params-5.10.0.jar
│   ├── junit-platform-commons-1.10.0.jar
│   ├── junit-platform-console-standalone-1.10.0.jar
│   └── opentest4j-1.3.0.jar
├── src/
│   ├── main/java/         # Main source code
│   └── test/java/         # Test source code
└── target/                # Compiled classes
    ├── classes/           # Compiled main classes
    └── test-classes/      # Compiled test classes
```

## Building the Project

1. Compile the main class:
```bash
javac -cp "lib/*" -d target/classes src/main/java/com/akshay/timeconverter/BritishTimeSpokenForm.java
```

2. Compile the test class:
```bash
javac -cp "lib/*;target/classes" -d target/test-classes src/test/java/com/akshay/timeconverter/BritishTimeSpokenFormTest.java
```

## Running the Application

To run the main application:
```bash
java -cp target/classes com.akshay.timeconverter.BritishTimeSpokenForm
```

## Running the Tests

There are two ways to run the tests:

1. Run all tests:
```bash
java -jar lib/junit-platform-console-standalone-1.10.0.jar execute --class-path "target/classes;target/test-classes" --scan-classpath
```

2. Run specific test class:
```bash
java -jar lib/junit-platform-console-standalone-1.10.0.jar execute --class-path "target/classes;target/test-classes" --select-class com.akshay.timeconverter.BritishTimeSpokenFormTest
```

## Test Cases

The test suite includes:
1. Parameterized tests for various time inputs:
   - Basic hours (1:00 to 12:00)
   - 24-hour format (13:00 to 23:59)
   - Quarter past/to hours
   - Half past hours
   - Minutes past/to hours
   - Edge cases (midnight, noon)

2. Special test cases:
   - Midnight (00:00)
   - Noon (12:00)
   - Quarter past twelve (00:15)
   - Quarter to one (00:45)

Total: 20 test cases covering various time formats and edge cases.

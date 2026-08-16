
# Java 17 Features Repository

A hands‑on collection of small, focused examples that demonstrate key language and JVM features introduced in **Java 17 (LTS)**. The examples are organized for easy exploration, learning, and reuse.

---

## Overview

**Java 17** is a long‑term support release that brings several language enhancements, JVM improvements, and library updates. This repository provides concise, runnable examples for the most useful features so you can experiment quickly and see idiomatic usage.

**Highlights**
- Pattern matching for `instanceof`
- Sealed classes
- Records
- Text blocks
- Value‑based class behavior and warnings

---

## Features Covered

| **Feature** | **Description** | **Example Location** |
|---|---:|---|
| **Pattern Matching for instanceof (JEP 394)** | Simplifies type checks and casting with `instanceof`. | `src/main/java/com/dinesh/instanceof/InstanceOfExamples.java` |
| **Sealed Classes (JEP 409)** | Restricts which classes can extend or implement a type. | `src/main/java/com/dinesh/sealedclasses/SealedInterfaceExample.java` |
| **Records (JEP 395)** | Concise syntax for immutable data carriers. | `src/main/java/com/dinesh/record/RecordExample.java` |
| **Text Blocks (JEP 378)** | Multi‑line string literals with cleaner formatting. | `src/main/java/com/dinesh/textblock/TextBlockExample.java` |
| **Value Based Classes Warnings** | JVM warnings and guidance for misuse of value‑based classes. | `src/main/java/com/dinesh/valueBasedClasses/WarningOnPrimitives.java` |
| **JDK Encapsulation and Foreign Function API** | Notes about JEP 403 and JEP 412 (incubator) included in README; examples not included. | N/A |

---

## Project Structure

```
java-17-features/
├─ src/
│  ├─ main/
│  │  └─ java/
│  │     └─ com/dinesh/
│  │        ├─ instanceof/
│  │        ├─ sealedclasses/
│  │        ├─ record/
│  │        ├─ textblock/
│  │        ├─ valueBasedClasses/
│  │        └─ Main.java
│  ├─ resources/
│  └─ test/
├─ pom.xml
├─ README.md
└─ LICENSE
```

**Notes**
- Each example package contains a small `main` method so examples can be run individually.
- `Main.java` provides a simple launcher to run selected demos.

---

## Getting Started

**Prerequisites**
- **Java 17** or higher installed — official docs: https://docs.oracle.com/en/java/javase/17/
- **Maven 3.8+**

**Build**
```bash
mvn clean install
```

**Run**
```bash
# Run the Spring Boot app if included
mvn spring-boot:run

# Or run the main launcher
java -cp target/classes com.dinesh.Main

# Or run individual example classes with the fully qualified name
java -cp target/classes com.dinesh.instanceof.InstanceOfExamples
```

---

## Examples

### Pattern Matching for instanceof

```java
package com.dinesh.instanceof;

public class InstanceOfExamples {
    public static void demo(Object obj) {
        if (obj instanceof String s) {
            System.out.println("String value: " + s.toUpperCase());
        } else {
            System.out.println("Not a string");
        }
    }

    public static void main(String[] args) {
        demo("hello");
        demo(123);
    }
}
```

### Sealed Classes

```java
package com.dinesh.sealedclasses;

public sealed interface Shape permits Circle, Rectangle {}

public final class Circle implements Shape {
    private final double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
}

public final class Rectangle implements Shape {
    private final double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double area() { return length * width; }
}
```

### Records

```java
package com.dinesh.record;

public record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        System.out.println(p.name() + " is " + p.age() + " years old.");
    }
}
```

### Text Blocks

```java
package com.dinesh.textblock;

public class TextBlockExample {
    public static void main(String[] args) {
        String json = """
        {
            "name": "John",
            "age": 25,
            "city": "New York"
        }
        """;
        System.out.println(json);
    }
}
```

### Value Based Classes Warning

```java
package com.dinesh.valueBasedClasses;

public class WarningOnPrimitives {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b); // true due to caching

        Integer c = new Integer(10);
        Integer d = new Integer(10);
        System.out.println(c == d); // false, different objects
    }
}
```

---

## Contributing and License

**Contributing**
- Contributions are welcome. Fork the repository, add or improve examples, and submit a pull request.
- Keep examples small, focused, and well documented.
- Add tests where appropriate.

**License**
- This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgements and Related Repositories

**Acknowledgements**
- Inspired by the Java 21 Features repository.
- Authored by **Dinesh Veer**.

**Related Repositories**
- Java 21 Features — `https://github.com/dineshveer/java-21-features` [(github.com in Bing)](https://www.bing.com/search?q="https%3A%2F%2Fgithub.com%2Fdineshveer%2Fjava-21-features")
- Java 25 Features — `https://github.com/dineshveer/java-25-features` [(github.com in Bing)](https://www.bing.com/search?q="https%3A%2F%2Fgithub.com%2Fdineshveer%2Fjava-25-features")
- Author profile — [https://github.com/dinesh-veer](https://github.com/dinesh-veer)


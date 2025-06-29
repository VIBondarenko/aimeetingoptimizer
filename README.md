# ===UNDER RECONSTRUCTION===

# AI Meeting Optimizer

![Java](https://img.shields.io/badge/Java-8+-orange)
![License](https://img.shields.io/github/license/VIBondarenko/aimeetingoptimizer)
![Status](https://img.shields.io/badge/status-educational-blue)
![GitHub last commit](https://img.shields.io/github/last-commit/VIBondarenko/aimeetingoptimizer)

📘 **AI Meeting Optimizer** is ...

## 🎓 Implemented Features

- 📚 .
- 👨‍🎓 .
- 🧑‍🏫 .
- 📝 .
- 📄 .
- 💾 .

## 🛠️ Technologies

- Java SE 8+
- Maven

## 📚 Project Purpose


## 🚀 How to Run

If you don't use an IDE, you can still compile and run the project using **Maven** and **Java** from the command line.

---

### ✅ Prerequisites

Make sure the following are installed:

- [Java JDK 8 or later](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/)

You can check them with:

```bash
java -version
mvn -v
```

---

### 📦 Step-by-Step Instructions

#### 1. Clone the repository

```bash
git clone https://github.com/VIBondarenko/aimeetingoptimizer.git
cd aimeetingoptimizer
```

#### 2. Compile the project

```bash
mvn clean compile
```

This will compile all source files and place compiled `.class` files into the `target/classes` folder.

#### 3. Run the application

Make sure your `pom.xml` contains this section:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <version>3.1.0</version>
      <configuration>
        <mainClass>io.github.vibondarenko.aimeetingoptimizer</mainClass>
      </configuration>
    </plugin>
  </plugins>
</build>
```

Then run the app using:

```bash
mvn exec:java
```

---

## 🧩 Notes

- The entry point is the `AIMeetingOptimizerApplication` class.

## 📬 Feedback

Author: [Vitaliy Bondarenko](https://github.com/VIBondarenko)  
Feel free to open issues for discussions, suggestions, or questions!
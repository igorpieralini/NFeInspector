# 🧾 NFeInspector v1.0.0

**NFeInspector** is a modern, object-oriented Java application that reads and parses **Brazilian Electronic Invoices (NF-e)** in XML format. It extracts structured data such as the emitter, recipient, and product items, displaying the results in a clear and readable format on the console.

Ideal for developers looking to automate NF-e reading and integrate with CSV/JSON export or database persistence.

---

## 🚀 Features

* ✅ Reads and parses NF-e XML files
* ✅ Extracts **emitter**, **recipient**, and **product items** information
* ✅ Maps XML data into Java model objects
* ✅ Clean and modular OOP architecture
* ✅ Easily extendable for **CSV/JSON export** or database integration

---

## 🛠️ Technologies Used

| Technology        | Description                            |
| ----------------- | -------------------------------------- |
| ☕ Java 25         | Project target version                 |
| 🧩 Maven          | Dependency management and build tool   |
| 📂 JDOM2          | XML parsing library                    |
| 🧱 SLF4J (Simple) | Lightweight logging                    |
| 🧠 OOP            | Encapsulation, modularity, and clarity |

---

## 📦 Project Structure

```
NFeInsight/
 ├── pom.xml
 ├── src/
 │   ├── main/
 │   │   ├── java/com/nfeinsight/
 │   │   │   ├── app/Main.java
 │   │   │   ├── model/       # Model classes (Emitter, Recipient, ProductItem, etc.)
 │   │   │   ├── parser/      # XML parsing logic
 │   │   │   └── service/     # Helper services and business rules
 │   │   └── resources/
 │   │       └── example.xml  # Sample NF-e
 │   └── test/                # Unit tests
```

---

## 🧑‍💻 Developer Guide

### Clone the repository

```bash
git clone https://github.com/yourusername/NFeInsight.git
cd NFeInsight
```

### Build

```bash
mvn clean install
```

### Run

```bash
mvn exec:java -Dexec.mainClass="com.nfeinsight.app.Main"
```

### Use your own XML files

1. Place your `.xml` files in `src/main/resources/`.
2. Adjust the path in `Main.java` if necessary.

---

## 📌 Next Steps / Extensions

* Export data to **CSV or JSON**
* Database persistence
* GUI or REST API integration
* Support for multiple types of fiscal documents

---

### Developer

**Igor Pieralini** – Creator and maintainer of the project
📧 Contact: [[igorpieralini@gmail.com](mailto:your-email@example.com)]
🌐 GitHub: [https://github.com/igorpieralini](https://github.com/igorpieralini)

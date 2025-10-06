# 🧾 NFeInsight

NFeInsight is a modern, object-oriented Java application that reads and parses Brazilian Electronic Invoices (NF-e) in XML format. It extracts structured data such as the emitter, recipient, and product items, then displays the results on the console in a readable format.

---

## 🚀 Features

* ✅ Reads and parses NF-e XML files
* ✅ Extracts emitter, recipient, and product items
* ✅ Maps XML data into Java model objects
* ✅ Built with clean OOP design
* ✅ Easily extensible for CSV / JSON export or database persistence

---

## 🛠️ Technologies

| Technology        | Notes                                  |
|-------------------| -------------------------------------- |
| ☕ Java 25         | Project target version                 |
| 🧩 Maven          | Build and dependency management        |
| 📂 JDOM2          | XML parsing library                    |
| 🧱 SLF4J (simple) | Logging                                |
| 🧠 OOP            | Encapsulation, modularity, readability |

---

## 📦 Project Layout

```
NFeInsight/
 ├── pom.xml
 ├── src/
 │   ├── main/
 │   │   ├── java/com/nfeinsight/
 │   │   │   ├── app/Main.java
 │   │   │   ├── model/
 │   │   │   ├── parser/
 │   │   │   └── service/
 │   │   └── resources/example.xml
 │   └── test/
```

---

## ⚙️ How it works

1. The app loads an NF-e XML file.
2. It parses key elements (emit, dest, det/prod).
3. Parsed values are mapped into model objects (`Invoice`, `Emitter`, `Recipient`, `Product`).
4. The app prints a formatted representation to the console.

---

## 🧠 Example output

```
Emitter: Example Company LTD (30290856000186)
Recipient: Example Client (12345678909)
Products:
 - 001 - Example Product | $100.0
```

---

## 🧑‍💻 Developer Guide

**Clone**

```bash
git clone https://github.com/yourusername/NFeInsight.git
cd NFeInsight
```

**Build**

```bash
mvn clean install
```

**Run**

```bash
mvn exec:java -Dexec.mainClass="com.nfeinsight.app.Main"
```

**Use your own XML**

Place `.xml` files in `src/main/resources/` and adjust the path in `Main.java` if necessary.

---

## 🌟 Roadmap

* Export to CSV/JSON/database
* Batch processing for multiple invoices
* XSD validation against SEFAZ schemas
* REST API and simple web UI

---

## 🤝 Contributing

Pull requests and issues are welcome. Keep changes small and add tests when relevant.

---

## ❤️ Credits

Built with Java 25, Maven, JDOM2, and a passion for clean code.

---

## 🎉 Final Notes for Developers

* Keep models immutable where it makes sense.
* Favor small classes and single responsibilities.
* Add unit tests for the parser to cover variations of NF-e XML structures.
* Use Java records if you prefer more concise immutable data holders.

Happy coding! 🚀

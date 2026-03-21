<p style="text-align:left">
  <img src="https://www.kanopus.cl/assets/kanopus_black.png" width="220" alt="Kanopus logo"/>
</p>

![Maven](https://img.shields.io/maven-central/v/cl.kanopus.tool/ktool-deploy-sql) ![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue) ![Java](https://img.shields.io/badge/java-17+-orange)

# ktool-deploy-sql

This tool is designed to support change control on a database engine, allowing you to define a list of SQL files that
will be executed and recorded for auditing.
This simplifies the control of script execution in different environments.

Currently this tool has support for the following database engines:

- Postgresql
- Oracle
- SQL Server
- IBM DB2

Note about IBM DB2 support:

- This project includes IBM DB2 support but the DB2 JDBC driver (com.ibm.db2:jcc) is marked as
  `provided` in the Maven configuration. That means the driver is not packaged inside the
  generated artifact and must be supplied by the environment where the tool runs (for example,
  placed in the application's classpath or provided by the container). If you want the driver
  included in the final package, change the dependency scope from `provided` to `runtime` in
  `pom.xml`.

## ✨ Features

- Configuration of sql scripts through a catalog.xml file
- It is possible to define whether a SQL script should be executed once or multiple times (onetime).
- Automatic audit stored in (CATALOG_SCRIPT_SQL, CATALOG_SCRIPT_SQL_EXECUTION)

## 🚀 Installation

You can run this tool using Docker or from the command line.

**Option 1 — Docker**

```bash
docker run --rm ktool-deploy-sql:4.03.1
```

**Option 2 — Command line**

```bash
java -jar ktool-deploy-sql-4.03.1.jar
```

## 🚀 Usage Guide

Example command:

```bash
java -jar ktool-deploy-sql-4.03.1.jar
```

Replace this example with the real command-line parameters supported by the tool.

## 👤 Author

⭐**Pablo Andrés Díaz Saavedra** — Founder of **Kanopus – Software Guided by the Stars**⭐

Kanopus is building a constellation of developers creating tools, libraries and platforms that simplify software engineering.

[GitHub](https://github.com/godheaven) | [LinkedIn](https://www.linkedin.com/in/pablo-diaz-saavedra-4b7b0522/) | [Website](https://kanopus.cl)

## 📄 License

This software is licensed under the Apache License, Version 2.0. See the LICENSE file for details.
I hope you enjoy it.

[![Apache License, Version 2.0](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://opensource.org/license/apache-2-0)

## 🛟 Support

For support or questions contact: 📧 [soporte@kanopus.cl](mailto:soporte@kanopus.cl)


![Logo](https://www.kanopus.cl/admin/javax.faces.resource/images/logo-gray.png.xhtml?ln=paradise-layout)


# ktool-deploy-sql


This tool is designed to support change control on a database engine, allowing you to define a list of SQL files that will be executed and recorded for auditing.
This simplifies the control of script execution in different environments.

Currently this tool has support for the following database engines:
- Postgresql
- Oracle
- SQL Server


## Features
- Configuration of sql scripts through a catalog.xml file
- It is possible to define whether a SQL script should be executed once or multiple times (onetime).
- Automatic audit stored in (CATALOG_SCRIPT_SQL, CATALOG_SCRIPT_SQL_EXECUTION)


## Pre-requisites
 It is necessary to copy the "klib-deploy-sql" library to your maven repository.


## Usage/Examples

1. Example catalog.xml

```xml

<?xml version="1.0" encoding="UTF-8"?>
<catalog>
        
    <database>
        <label>KANOPUS-LOCAL</label>
        <scripts>
            <script onetime="true" type="DATA" label="test1">src/main/resources/scripts/test1.sql</script>
            <script onetime="false" type="DATA" label="test2">src/main/resources/scripts/test2.sql</script>
        </scripts>
    </database>
     
</catalog>

```

2. Example DeploySQL

```java

package cl.kanopus.tools.deploysql;

import cl.kanopus.deploysql.DeploySQL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 * @author Pablo Diaz Saavedra
 * @email pabloandres.diazsaavedra@gmail.com
 * @company Kanopus.cl
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = "cl.kanopus")
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DeploySQL deploy = new DeploySQL("my-user", "my-pass", "jdbc:postgresql://localhost/my-database");
        deploy.execute("catalog.xml");
    }

}

```

3. Example Output (second attempt)

```console

... Started Application in 1.285 seconds (process running for 1.604)
... catalog.xsd loaded successfull
... catalog.xml loaded successfull
... Catalog has been loaded for KANOPUS-LOCAL database
 -----------------------------------------------------------------------
... [KANOPUS-LOCAL] Getting connection to database --> user:[my-user],  timeout: [30], url: [jdbc:postgresql://localhost/my-database]
... [KANOPUS-LOCAL] Connection successfully established
... [KANOPUS-LOCAL] Catalog asocciated with 2 scripts for execution
... [KANOPUS-LOCAL] [1/2] (SKIPPED): The script test1.sql has been skipped.
... [KANOPUS-LOCAL] [2/2] (SUCCESS): The script test2.sql has been successfully executed.
... [KANOPUS-LOCAL] The database connection is closed 

```

## Authors

- [@pabloandres.diazsaavedra](https://www.linkedin.com/in/pablo-diaz-saavedra-4b7b0522/)


## License

This is free software and I hope you enjoy it.

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)



## Support

For support, email pabloandres.diazsaavedra@gmail.com


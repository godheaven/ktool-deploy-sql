package cl.kanopus.tools.deploysql;

import cl.kanopus.deploysql.DeploySQL;
import cl.kanopus.tools.deploysql.application.MyEnvironment;
import cl.kanopus.tools.deploysql.application.enums.Property;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MyEnvironment env;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DeploySQL deploy = new DeploySQL(env.getProp(Property.TEST_USER), env.getProp(Property.TEST_PASS), env.getProp(Property.TEST_JDBC_URL));
        deploy.execute();

    }

}

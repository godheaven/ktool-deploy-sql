package cl.kanopus.tools.deploysql.application;

import cl.kanopus.common.util.Utils;
import cl.kanopus.tools.deploysql.application.enums.Property;
import jakarta.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pablo Diaz Saavedra
 * @email pabloandres.diazsaavedra@gmail.com
 * @company Kanopus.cl
 */
@Component
public class MyEnvironment {

    private static final Logger log = LoggerFactory.getLogger(MyEnvironment.class);

    private final Environment environment;

    public MyEnvironment(@Autowired Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void onStart() {
        log.debug("ktool-deploy-sql application running in " + TimeZone.getDefault().getDisplayName() + " timezone :" + new Date());
        log.debug(Utils.printInfoKtools("Ktool Deploy SQL", "v1.0.0").toString());
    }

    public String getProp(Property property) {
        return environment.getProperty(property.getValue());
    }

    public boolean getPropBoolean(Property property) {
        return environment.getProperty(property.getValue(), Boolean.class);
    }

    public long getPropLong(Property property) {
        return environment.getProperty(property.getValue(), Long.class);
    }

    public int getPropInteger(Property property) {
        return environment.getProperty(property.getValue(), Integer.class);
    }

    public String getNativeProp(String property) {
        return environment.getProperty(property);
    }

    public Long getNativePropLong(String property) {
        return environment.getProperty(property, Long.class);
    }

    public Integer getNativePropInteger(String property) {
        return environment.getProperty(property, Integer.class);
    }

}

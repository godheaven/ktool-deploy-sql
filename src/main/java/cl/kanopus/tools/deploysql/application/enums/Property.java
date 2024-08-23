package cl.kanopus.tools.deploysql.application.enums;

/**
 *
 * @author Pablo Diaz Saavedra (pd47753)
 * @email pabloandres.diazsaavedra@gmail.com
 *
 * This class identifies all properties specified in the file batch.properties
 * It is used to access the properties referenced by the class ContextHolder
 *
 */
public enum Property {

    TEST_USER("test.user"),
    TEST_PASS("test.pass"),
    TEST_JDBC_URL("test.jdbc.url");

    private final String value;

    Property(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

package org.allurefw.allure1;

/**
 * @author Dmitry Baev
 */
public final class AllureConstants {

    /**
     * The name of Allure schema. You can find the schema in resources of allure-model module.
     */
    public static final String SCHEMA_FILE_NAME = "xsd/allure1_model.xsd";

    /**
     * The suffix of test suites files. Each test suite file should has such suffix
     * (and .xml extension).
     */
    public static final String TEST_SUITE_FILE_SUFFIX = "-testsuite";

    /**
     * The glob to find xml test suites in allure results.
     */
    public static final String TEST_SUITE_XML_FILE_GLOB = String.format("*%s.xml", TEST_SUITE_FILE_SUFFIX);

    /**
     * The glob to find json test suites in allure results.
     */
    public static final String TEST_SUITE_JSON_FILE_GLOB = String.format("*%s.json", TEST_SUITE_FILE_SUFFIX);

    /**
     * The suffix of attachment files. All attachments should has such suffix.
     */
    public static final String ATTACHMENTS_FILE_SUFFIX = "-attachment";

    /**
     * The glob to find attachments in allure results.
     */
    public static final String ATTACHMENTS_FILE_GLOB = String.format("*%s*", ATTACHMENTS_FILE_SUFFIX);

    /**
     * The version of Allure.
     */
    public static final String VERSION = AllureConstants.class.getPackage().getImplementationVersion();

    /**
     * The file name of environment file.
     */
    public static final String ENVIRONMENT_FILE_NAME = "environment.properties";

    /**
     * The name of report configuration file.
     */
    public static final String REPORT_CONFIG_FILE_NAME = "report.properties";

    /**
     * This property can be used to specify test run name.
     */
    public static final String PROPERTY_TEST_RUN_NAME = "allure.test.run.name";

    /**
     * This property can be used to specify test run id.
     */
    public static final String PROPERTY_TEST_RUN_ID = "allure.test.run.id";

    /**
     * This property can be used to specify test run url.
     */
    public static final String PROPERTY_TEST_RUN_URL = "allure.test.run.url";

    /**
     * Do not instantiate.
     */
    AllureConstants() {
        throw new IllegalStateException("You should never instantiate it.");
    }
}
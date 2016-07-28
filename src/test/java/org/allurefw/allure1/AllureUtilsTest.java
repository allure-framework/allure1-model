package org.allurefw.allure1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.yandex.qatools.allure.model.Label;
import ru.yandex.qatools.allure.model.LabelName;
import ru.yandex.qatools.allure.model.TestSuiteResult;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.allurefw.allure1.AllureUtils.generateAttachmentName;
import static org.allurefw.allure1.AllureUtils.generateTestSuiteJsonName;
import static org.allurefw.allure1.AllureUtils.generateTestSuiteXmlName;
import static org.allurefw.allure1.AllureUtils.listAttachmentFiles;
import static org.allurefw.allure1.AllureUtils.listTestSuiteJsonFiles;
import static org.allurefw.allure1.AllureUtils.listTestSuiteXmlFiles;
import static org.allurefw.allure1.AllureUtils.marshalTestSuite;
import static org.allurefw.allure1.AllureUtils.validateResults;
import static org.allurefw.allure1.testdata.TestData.randomLabelName;
import static org.allurefw.allure1.testdata.TestData.randomTestSuiteResult;
import static org.allurefw.allure1.testdata.TestData.randomValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static ru.yandex.qatools.matchers.nio.PathMatchers.contains;

/**
 * @author charlie (Dmitry Baev).
 */
public class AllureUtilsTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void shouldCreateLabel() throws Exception {
        LabelName name = randomLabelName();
        String value = randomValue();
        Label label = AllureUtils.createLabel(name, value);
        assertThat(label, notNullValue());
        assertThat(label.getName(), is(name.value()));
        assertThat(label.getValue(), is(value));
    }

    @Test
    public void shouldGenerateRightAttachmentName() throws Exception {
        Path outputDir = folder.newFolder().toPath();
        String attachmentName = generateAttachmentName();
        Path attachment = outputDir.resolve(attachmentName);
        Files.createFile(attachment);
        List<Path> paths = listAttachmentFiles(outputDir);
        assertThat(paths, hasSize(1));
        assertThat(paths, hasItems(attachment));
    }

    @Test
    public void shouldGenerateRightTestSuiteXmlName() throws Exception {
        Path outputDir = folder.newFolder().toPath();
        String testSuiteXmlName = generateTestSuiteXmlName();
        Path testSuite = outputDir.resolve(testSuiteXmlName);
        Files.createFile(testSuite);
        List<Path> paths = listTestSuiteXmlFiles(outputDir);
        assertThat(paths, hasSize(1));
        assertThat(paths, hasItems(testSuite));
    }

    @Test
    public void shouldGenerateRightTestSuiteJsonName() throws Exception {
        Path outputDir = folder.newFolder().toPath();
        String testSuiteJsonName = generateTestSuiteJsonName();
        Path testSuite = outputDir.resolve(testSuiteJsonName);
        Files.createFile(testSuite);
        List<Path> paths = listTestSuiteJsonFiles(outputDir);
        assertThat(paths, hasSize(1));
        assertThat(paths, hasItems(testSuite));
    }

    @Test
    public void shouldMarshalTestSuite() throws Exception {
        Path outputDir = folder.newFolder().toPath();
        TestSuiteResult result = randomTestSuiteResult();
        String testSuiteXmlName = generateTestSuiteXmlName();
        marshalTestSuite(result, outputDir.resolve(testSuiteXmlName));
        assertThat(outputDir, contains(testSuiteXmlName));
    }

    @Test
    public void shouldValidateTestSuite() throws Exception {
        Path outputDir = folder.newFolder().toPath();
        TestSuiteResult result = randomTestSuiteResult();
        String testSuiteXmlName = generateTestSuiteXmlName();
        marshalTestSuite(result, outputDir.resolve(testSuiteXmlName));
        validateResults(outputDir);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToInstanceUtils() throws Exception {
        new AllureUtils();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToInstanceConstants() throws Exception {
        new AllureConstants();
    }
}
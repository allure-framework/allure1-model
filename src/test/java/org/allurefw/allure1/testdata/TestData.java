package org.allurefw.allure1.testdata;

import ru.yandex.qatools.allure.model.LabelName;
import ru.yandex.qatools.allure.model.Status;
import ru.yandex.qatools.allure.model.TestCaseResult;
import ru.yandex.qatools.allure.model.TestSuiteResult;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * @author charlie (Dmitry Baev).
 */
public final class TestData {

    private static final Random RANDOM = new Random();

    private static final LabelName[] LABEL_NAMES_VALUES = LabelName.values();

    private static final Status[] STATUSES_VALUES = Status.values();

    TestData() {
    }

    public static String randomValue() {
        return randomAlphabetic(5);
    }

    public static LabelName randomLabelName() {
        return randomEnum(LABEL_NAMES_VALUES);
    }

    public static Status randomStatus() {
        return randomEnum(STATUSES_VALUES);
    }

    public static <T> T randomEnum(T[] values) {
        return values[RANDOM.nextInt(values.length)];
    }

    public static TestSuiteResult randomTestSuiteResult() {
        return new TestSuiteResult()
                .withName(randomValue())
                .withTestCases(randomTestCaseResult(), randomTestCaseResult(), randomTestCaseResult());
    }

    public static TestCaseResult randomTestCaseResult() {
        return new TestCaseResult()
                .withName(randomValue())
                .withStatus(randomStatus());
    }
}

package org.allurefw.allure1;

/**
 * Signals a Allure error. Thrown to indicate problems with Allure
 * lifecycle.
 *
 * @author Dmitry Baev
 */
@SuppressWarnings("unused")
public class AllureException extends RuntimeException {

    /**
     * Construct an new exception with message
     *
     * @param message initial message value
     */
    public AllureException(String message) {
        super(message);
    }

    /**
     * Construct an new exception with message and some cause
     *
     * @param message initial message value
     * @param cause   initial cause value
     */
    public AllureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct an new exception with cause
     *
     * @param cause initial cause value
     */
    public AllureException(Throwable cause) {
        super(cause);
    }
}
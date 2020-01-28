package com.nuclei.question2;

/**
 * The type Application exception.
 */
public class ApplicationException extends Throwable {

    private ExceptionType identifier;
    private String errorMessage;

    /**
     * Instantiates a new Application exception.
     *
     * @param type the type
     */
    public ApplicationException(ExceptionType type) {
        super();
        identifier = type;
    }

    /**
     * Instantiates a new Application exception.
     *
     * @param errorMessage the error message
     */
    public ApplicationException(String errorMessage) {
        super();
        identifier = ExceptionType.GENERIC;
        this.errorMessage = errorMessage;
    }

    /**
     * Instantiates a new Application exception.
     *
     * @param type         the type
     * @param errorMessage the error message
     */
    public ApplicationException(ExceptionType type, String errorMessage) {
        super(errorMessage);
        identifier = type;
        this.errorMessage = errorMessage;
    }

    /**
     * Print event.
     */
    public void printEvent() {
        Logger.log("Exception: " + identifier);
        Logger.log(errorMessage);
    }
}


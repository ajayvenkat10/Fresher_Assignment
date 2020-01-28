package com.nuclei.question1;


/**
 * The type Application exception.
 */
public class ApplicationException extends Throwable {

    private ExceptionType identifier;

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
    }

    /**
     * Print event.
     */
    public void printEvent(String info) {
        Logger.log("Exception: " + identifier);
        Logger.log(info);
    }
}
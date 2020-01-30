package com.nuclei.question3;


/**
 * The type Application exception.
 */
public class ApplicationException extends Throwable {

    private ExceptionType identifier;
    private String info;

    /**
     * Instantiates a new Application exception.
     *
     * @param type the type
     */
    public ApplicationException(ExceptionType type) {
        super();
        identifier = type;
        info = "";
    }

    /**
     * Instantiates a new Application exception.
     *
     * @param errorMessage the error message
     */
    public ApplicationException(String errorMessage) {
        super(errorMessage);
        identifier = ExceptionType.GENERIC;
        info = errorMessage;
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
        info = errorMessage;
    }

    /**
     * Print event.
     */
    public void printEvent() {
//        Logger.log("Exception: " + identifier);
        Logger.log(info);
    }
}

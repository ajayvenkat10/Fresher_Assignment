package com.nuclei.question3;

/**
 * The type Exception handler.
 */
public class ExceptionHandler {

    /**
     * Handle node does not exist exception.
     *
     * @param message the message
     */
    public static void handleNodeDoesNotExistException(String message) {
        try {
            throw new ApplicationException(ExceptionType.NODE_DOES_NOT_EXIST_EXCEPTION, message);
        } catch (ApplicationException e) {
            e.printEvent();
        }
    }

    /**
     * Handle node exists exception.
     */
    public static void handleNodeExistsException(){
        try {
            throw new ApplicationException(ExceptionType.NODE_EXISTS_EXCEPTION, Constants.NODE_EXISTS);
        } catch (ApplicationException e) {
            e.printEvent();
        }
    }

    /**
     * Handle cyclic dependency exception.
     */
    public static void handleCyclicDependencyException() {
        try {
            throw new ApplicationException(ExceptionType.CYCLIC_DEPENDENCY_EXCEPTION, Constants.CYCLIC_DEPENDENCY);
        } catch (ApplicationException e) {
            e.printEvent();
        }
    }

    /**
     * Handle generic exception.
     *
     * @param message the message
     */
    public static void handleGenericException(String message){
        try {
            throw new ApplicationException(message);
        } catch (ApplicationException e) {
            e.printEvent();
        }
    }
}

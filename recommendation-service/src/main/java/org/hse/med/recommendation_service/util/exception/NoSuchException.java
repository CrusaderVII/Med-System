package org.hse.med.recommendation_service.util.exception;

public class NoSuchException extends Exception{
    public static final String PREFIX_FORMAT = "There is no %s with %s %s";

    public NoSuchException(String entityName, String fieldName, String value) {
        super(String.format(PREFIX_FORMAT, entityName, fieldName, value));
    }
}

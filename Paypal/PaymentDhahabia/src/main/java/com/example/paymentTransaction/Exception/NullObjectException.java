package com.example.paymentTransaction.Exception;
/**
 * This is Thrown when an application attempts to use null in a case where an object is required.
 *  Null is not a valid argument for a method, so it is okay to throw the exception.
 * @author Lachraf NourElhouda
 */
public class NullObjectException extends RuntimeException{
    private static final long serialVersionUID = 1L;
public NullObjectException(String message){
    super(message);
}
}

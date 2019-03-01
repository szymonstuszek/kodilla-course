package com.kodilla.kodillapatterns2.facade.api;

public class OrderProcessingException extends Exception {
    public static final String ERR_NOT_AUTHORISED = "User is not authorized";
    public static final String ERR_PAYMENT_REJECTED = "Payment has been rejected";
    public static final String ERR_VERIFICATION_ERROR = "Verification error";
    public static final String ERR_SUBMITTING_ERROR = "Cannot submit order";

    public OrderProcessingException(String message) {
        super(message);
    }

}

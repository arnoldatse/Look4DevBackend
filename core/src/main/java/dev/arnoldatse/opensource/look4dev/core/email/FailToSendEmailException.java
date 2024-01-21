package dev.arnoldatse.opensource.look4dev.core.email;

public class FailToSendEmailException extends Exception {
    public FailToSendEmailException(String msg) {
        super(msg);
    }
}

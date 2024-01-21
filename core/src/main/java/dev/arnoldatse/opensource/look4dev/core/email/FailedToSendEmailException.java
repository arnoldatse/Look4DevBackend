package dev.arnoldatse.opensource.look4dev.core.email;

public class FailedToSendEmailException extends Exception {
    public FailedToSendEmailException(String msg) {
        super(msg);
    }
}

package dev.arnoldatse.opensource.look4dev.core.email;

public interface EmailSenderAdapter {
    void send(String recipient, String subject, Object body) throws FailedToSendEmailException;
}

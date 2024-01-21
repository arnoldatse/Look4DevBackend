package dev.arnoldatse.opensource.look4dev.core.email;

public interface EmailSender {
    void send(String recipient, String subject, Object body) throws FailToSendEmailException;
}

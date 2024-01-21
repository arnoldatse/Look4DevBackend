package dev.arnoldatse.opensource.look4dev.details.email;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSender;
import dev.arnoldatse.opensource.look4dev.core.email.FailToSendEmailException;

public class StandardEmailSender implements EmailSender {
    @Override
    public void send(String recipient, String subject, Object body) throws FailToSendEmailException {

    }
}

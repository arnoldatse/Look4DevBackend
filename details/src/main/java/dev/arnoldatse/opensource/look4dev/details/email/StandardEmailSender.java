package dev.arnoldatse.opensource.look4dev.details.email;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSenderAdapter;
import dev.arnoldatse.opensource.look4dev.core.email.FailedToSendEmailException;

public class StandardEmailSender implements EmailSenderAdapter {
    @Override
    public void send(String recipient, String subject, Object body) throws FailedToSendEmailException {

    }
}

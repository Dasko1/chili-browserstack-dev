package com.demandbridge.single;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageListResult;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class MailosaurEmailClient {

    private static final String API_KEY = "OicbHO31FASngd1";
    private static final String SERVER_ID = "qgowwpz9";
    private final MailosaurClient mailosaurClient;

    public MailosaurEmailClient() {
        this.mailosaurClient = new MailosaurClient(API_KEY);
    }

    public byte[] getAttachmentContent(String id) throws MailosaurException, IOException {
        return mailosaurClient.files().getAttachment(id);
    }

    public Message getEmailBySubject(String subject) throws MailosaurException, IOException {
        var searchCriteria = new SearchCriteria();
        var messageSearchParams = new MessageSearchParams();
        var instant = LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC);
        var today = Date.from(instant);
        messageSearchParams.withServer(SERVER_ID);
        searchCriteria.withSubject(subject);
        messageSearchParams.withReceivedAfter(today); // mailosaur will only look for an email within the last email by default

        return mailosaurClient.messages().get(messageSearchParams, searchCriteria);
    }

    @Deprecated
    public MessageListResult getEmailsBySubject(String subject) throws MailosaurException, IOException {
        var searchCriteria = new SearchCriteria();
        searchCriteria.withSubject(subject);

        return mailosaurClient.messages().search(SERVER_ID, searchCriteria);
    }
}

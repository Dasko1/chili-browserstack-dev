package com.demandbridge.single;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MailosaurTest {

    private final MailosaurEmailClient mailosaurEmailClient = new MailosaurEmailClient();

    @Test
    void shouldGetChiliEmail() throws MailosaurException, IOException {
        var subject = "DB Demo Company B: Your DB Commerce order (00-X0059Q) has been MODIFIED";

        // get email
        Message email = mailosaurEmailClient.getEmailBySubject(subject);
        // get attachment metadata
        Attachment attachment = email.attachments().get(0);
        // get attachment bytes
        var content = mailosaurEmailClient.getAttachmentContent(attachment.id());
        try {
            // save attachment content to file
            var path = Path.of(String.format("attachments/%s.pdf", attachment.id()));
            var pdfFile = Files.write(path, content, StandardOpenOption.CREATE);

            // pdfUtil example
            //var pdfUtil = new PDFUtil();
            //String attachmentText = pdfUtil.getText(pdfFile.toFile().getAbsolutePath());
            /// assertThat(attachmentText).isNotBlank();

            // apache pdfbox example
            try (PDDocument document = PDDocument.load(pdfFile.toFile())) {
                PDFTextStripper textStripper = new PDFTextStripper();
                String text = textStripper.getText(document);

                // Process the extracted text
                assertThat(text).isNotBlank();
                assertThat(text).contains("410.123.3452 / e.sanchez@generic.com");
                assertThat(document.getPages()).hasSize(2);
                // Files.delete(pdfFile);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Files.deleteIfExists(pdfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(email).isNotNull();
        assertThat(attachment.fileName()).isEqualTo("00-X0059Q-1_doc_lowres.pdf");
        assertThat(attachment.length()).isGreaterThan(0);
    }
    /*@Test
    void getEmailBySubject_New() throws MailosaurException, IOException {
        final var subject = "DBD 307177";

        Message email = mailosaurEmailClient.getEmailBySubject(subject);

        assertThat(email).isNotNull();
    }

    @Test
    void shouldGetEmailBySubject() throws MailosaurException, IOException {
        final var jobNumber = "EQ2 255064";
        final var subject = String.format("New Proposal - %s", jobNumber);

        Message email = mailosaurEmailClient.getEmailBySubject(subject);

        assertThat(email).isNotNull();
        assertThat(email.from().stream().anyMatch((MessageAddress from) -> from.email().equals("eqdemo@demandbridge.com"))).isTrue();
        assertThat(email.html().body()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat");
    }

    @Test
    void shouldGetProposalLink() throws MailosaurException, IOException {
        final var subject = "New Proposal - EQ2 255064";

        Message email = mailosaurEmailClient.getEmailBySubject(subject);
        var proposalLink = email.html().links().stream()
                .filter(link -> link.text().contains("click here to respond to this proposal"))
                .findAny()
                .map(link1 -> link1.href());

        assertThat(proposalLink.isPresent()).isTrue();
    }

    @Test
    void shouldGetEmailsBySubject() throws MailosaurException, IOException {
        final var subject = "New Proposal";

        MessageListResult emails = mailosaurEmailClient.getEmailsBySubject(subject);
        Optional<MessageSummary> mostRecentProposalEmail = emails.items().stream().findFirst();

        assertThat(emails.items()).hasSizeGreaterThan(0);
        assertThat(mostRecentProposalEmail.isPresent()).isTrue();
        assertThat(mostRecentProposalEmail.get().subject()).isEqualTo("New Proposal - EQ2 255064");
    }*/
}

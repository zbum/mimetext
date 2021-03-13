package kr.co.manty.command.mimetext;

import com.sun.mail.imap.protocol.BASE64MailboxDecoder;
import com.sun.mail.imap.protocol.BASE64MailboxEncoder;
import org.apache.commons.cli.*;

import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

public class MimeTestApplication {
    public static void main(String[] args) {
        Option decode = new Option("d", "decode", true, "decode utf7");
        Option encode = new Option("e", "encode", true, "encode utf7");
        Options options = new Options();
        options.addOption(decode);
        options.addOption(encode);

        CommandLineParser parser = new BasicParser();

        CommandLine commandLine;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage());
            return;
        }

        String output = null;
        try {
            if ( commandLine.hasOption("decode")) {
                output = MimeUtility.decodeText(commandLine.getOptionValue("decode"));
            }

            if ( commandLine.hasOption("encode")) {
                output = MimeUtility.encodeText(commandLine.getOptionValue("encode"), "utf-8", "B");
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return;
        }

        if ( output != null )
            System.out.println(output);
    }
}

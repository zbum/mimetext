package kr.co.manty.command.mimetext;

import org.apache.commons.cli.*;

import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

public class MimeTextApplication {
    public static void main(String[] args) {
        Option help = new Option("h", "help", false , "print help.");
        Option decode = new Option("d", "decode", true, "decode mimetext");
        Option encode = new Option("e", "encode", true, "encode mimetext");
        Options options = new Options();
        options.addOption(help);
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
            if ( commandLine.hasOption("help")) {
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp("mimetext -e '가나다라'", options);
            }
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

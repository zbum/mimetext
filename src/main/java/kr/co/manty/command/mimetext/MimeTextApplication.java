package kr.co.manty.command.mimetext;

import org.apache.commons.cli.*;

import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

public class MimeTextApplication {
    private static final String VERSION = "mimetext 1.0 (author Manty)";
    public static void main(String[] args) {
        Option help = new Option("h", "help", false , "print help.");
        Option version = new Option("v", "version", false, "print version.");
        Option decode = new Option("d", "decode", true, "decode mimetext.");
        Option encode = new Option("e", "encode", true, "encode mimetext.");
        Options options = new Options();
        options.addOption(help);
        options.addOption(version);
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

            if ( commandLine.hasOption("version")) {
                output = VERSION;
            }

            if ( commandLine.hasOption("decode")) {
                output = MimeUtility.decodeText(commandLine.getOptionValue("decode"));
            }

            if ( commandLine.hasOption("encode")) {
                output = MimeUtility.encodeText(commandLine.getOptionValue("encode"), "utf-8", "B");
            }

            if (output == null) {
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp("mimetext -e '가나다라'", options);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return;
        }

        if ( output != null )
            System.out.println(output);
    }
}

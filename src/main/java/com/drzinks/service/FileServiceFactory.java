package com.drzinks.service;

import com.drzinks.SparkFileProcessorDriver;
import org.apache.commons.cli.*;
public class FileServiceFactory {
    public static FileService getFileService(String... args) throws ParseException {
        Options programOptions = getOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(programOptions, args);
        if (!cmd.hasOption("path")) {
            printUsage(programOptions);
            throw new ParseException("Path was not provided. Path is mandatory.");
        }
        if (cmd.hasOption("dropbox")) {
            if (!cmd.hasOption("token")) {
                printUsage(programOptions);
                throw new ParseException("When using dropbox option, you need to provide a token.");
            }
            return new DropboxFileService(cmd.getOptionValue("token"), cmd.getOptionValue("path"), SparkFileProcessorDriver.DROPBOX_DOWNLOADED_FILE_NAME);
        }
        return new LocalFileService(cmd.getOptionValue("path"));
    }
    private static Options getOptions() {
        Options programOptions = new Options();
        Option dropboxOption = new Option("dropbox", false, "When you want to download a file from DropBox.");
        Option dropboxToken = new Option("token", true, "Dropbox token.");
        Option filePath = new Option("path", true, "Path to a file.");
        programOptions
                .addOption(dropboxOption)
                .addOption(dropboxToken)
                .addOption(filePath);
        return programOptions;
    }
    private static void printUsage(Options programOptions) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("spark-file-processor", programOptions);
    }
}

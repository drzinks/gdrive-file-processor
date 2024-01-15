package com.drzinks;

import com.drzinks.scala.SparkFileProcessorApp;
import com.drzinks.service.FileService;
import com.drzinks.service.FileServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparkFileProcessorDriver {
    public static final String DROPBOX_DOWNLOADED_FILE_NAME = "temp";
    private static Logger logger = LoggerFactory.getLogger(SparkFileProcessorDriver.class);
    private static FileService fileService;
    public static String APP_NAME = "spark-file-processor";

     public static void main(String... args) {
        logger.info("spark-file-processor started.");
        try {
            fileService = FileServiceFactory.getFileService(args);
            SparkFileProcessorApp scalaApp = new SparkFileProcessorApp();
            scalaApp.processFile(fileService.getFile());
        } catch (Throwable e){
            logger.error(e.getMessage());
            System.exit(1);
        }
    }
}
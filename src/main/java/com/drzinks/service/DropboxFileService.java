package com.drzinks.service;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.drzinks.SparkFileProcessorDriver;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

@AllArgsConstructor
public class DropboxFileService implements FileService {

    private static Logger logger = LoggerFactory.getLogger(DropboxFileService.class);
    private String accessToken;
    private String filePathInDropbox;
    private String downloadedFileName;

    @Override
    public File getFile() throws IOException, DbxException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder(SparkFileProcessorDriver.APP_NAME)
                .build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);

        try {
            OutputStream convertedFileOutputStream = new FileOutputStream(downloadedFileName);
            FileMetadata dropboxService = client
                    .files()
                    .downloadBuilder(filePathInDropbox)
                    .download(convertedFileOutputStream);

            return new File(downloadedFileName);

        } catch (FileNotFoundException e) {
            logger.error("Not a proper file name, exiting.");
            throw e;
        } catch (IOException | DbxException e) {
            logger.error("Cannot download file:");
            throw e;
        }
    }
}

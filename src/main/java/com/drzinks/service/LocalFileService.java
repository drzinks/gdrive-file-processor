package com.drzinks.service;

import com.dropbox.core.DbxException;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class LocalFileService implements FileService{

    String path;
    @Override
    public File getFile() throws IOException, DbxException {
        return new File(path);
    }
}

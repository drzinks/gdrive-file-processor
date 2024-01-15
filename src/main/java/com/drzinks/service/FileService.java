package com.drzinks.service;

import com.dropbox.core.DbxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
    File getFile() throws IOException, DbxException;

}

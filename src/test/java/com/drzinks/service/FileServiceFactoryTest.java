package com.drzinks.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileServiceFactoryTest {

    private String[] argsCorrectLocal, argsIncorrect, argsIncorrectDropbox, ArgsCorrectLocal, argsCorrectDropbox;
    private FileService fileService;
    @BeforeAll
    void setUp() {
        argsCorrectLocal = new String[]{
                "-path",
                "C:\\Users\\golebim4\\Downloads\\people-1000.csv"
        };
        argsIncorrect = new String[]{};
        argsIncorrectDropbox = new String[]{"-dropbox"}; //no token provided
        argsCorrectDropbox = new String[]{"-dropbox", "-token", "abc"}; //no token
    }

    @Test
    void getFileServiceLocal() throws Exception {
        fileService = FileServiceFactory.getFileService(argsCorrectLocal);
        Assertions.assertT
    }
}
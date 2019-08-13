package com.ed.filehandler;

import java.io.IOException;
import java.nio.file.*;

public class FileTransfer {

    public void copyFile(String from, String to) {
        Path FROM = Paths.get(from);
        Path TO = Paths.get(to);
        CopyOption[] optionsCopy = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        try {
            Files.copy(FROM, TO, optionsCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFile(String from, String to) {
        Path FROM = Paths.get(from);
        Path TO = Paths.get(to);
        CopyOption[] optionsCopy = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING
        };
        try {
            Files.move(FROM, TO, optionsCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

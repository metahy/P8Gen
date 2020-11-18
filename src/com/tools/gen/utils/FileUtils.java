package com.tools.gen.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {
    public static void write(byte[] bytes, File file) {
        if (file == null) {
            System.out.println(new String(bytes));
            return;
        }
        boolean fileExists = file.exists();
        if (!fileExists) {
            File parentFile = file.getParentFile();
            boolean parentExists = parentFile.exists();
            if (!parentExists) {
                parentExists = parentFile.mkdirs();
            }
            if (parentExists) {
                try {
                    fileExists = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (fileExists) {
            try {
                OutputStream outputStream = new FileOutputStream(file);
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(File file) {
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.goodsoft.internship.copier;

import java.io.*;
import java.nio.channels.FileChannel;

public class NIOCopier implements Copier {

    @Override
    public void copyFile(String sourcePath, String destinationPath) {

        try(FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destinationPath);
            FileChannel source = fis.getChannel();
            FileChannel destination = fos.getChannel()) {

            destination.transferFrom(source, 0, source.size());

        } catch (FileNotFoundException e) {
            System.out.println("Файл \"" + sourcePath + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при копировании файла \"" + sourcePath +"\"");
        }
    }
}

package com.goodsoft.internship.copier;

import java.io.*;
import java.nio.channels.FileChannel;

public class NIOCopier implements Copier {

    @Override
    public void copyFile(String sourcePath, String destinationPath) {

        try(FileChannel source = new FileInputStream(sourcePath).getChannel();
            FileChannel destination = new FileOutputStream(destinationPath).getChannel()) {

            destination.transferFrom(source, 0, source.size());

        } catch (FileNotFoundException e) {
            System.out.println("Файл \"" + sourcePath + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при копировании файла \"" + sourcePath +"\"");
        }
    }
}

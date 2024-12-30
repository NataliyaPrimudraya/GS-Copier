package com.goodsoft.internship.copier;

import java.io.*;
import java.nio.file.Files;

public class FileCopier implements Copier {
    @Override
    public void copyFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        try {

            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (FileNotFoundException e) {
            System.out.println("Файл \"" + sourcePath + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при копировании файла \"" + sourcePath +"\"");
        }
    }
}

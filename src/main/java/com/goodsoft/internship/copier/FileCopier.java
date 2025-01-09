package com.goodsoft.internship.copier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileCopier implements Copier {
    @Override
    public void copyFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        try (InputStream in = Files.newInputStream(sourceFile.toPath())) {

            Files.copy(in, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (FileNotFoundException e) {
            System.out.println("Файл \"" + sourcePath + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при копировании файла \"" + sourcePath +"\"");
        }
    }
}

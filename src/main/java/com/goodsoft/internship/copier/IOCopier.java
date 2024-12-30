package com.goodsoft.internship.copier;

import java.io.*;

public class IOCopier implements Copier {
    @Override
    public void copyFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream(sourceFile));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл \"" + sourcePath + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при копировании файла \"" + sourcePath +"\"");
        }
    }

}

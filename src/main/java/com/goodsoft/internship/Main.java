package com.goodsoft.internship;

import com.goodsoft.internship.copier.*;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Путь к файлу, который нужно скопировать: ");
        String sourcePath = console.nextLine();
        System.out.println("Путь, куда нужно скопировать данный файл: ");
        String destinationPath = console.nextLine();

        if (new File(destinationPath).exists()){
            System.out.println("Файл " + destinationPath + " уже существует. Перезаписать?");
            if (!Objects.equals(console.nextLine(), "да")) {
                System.out.println("Завершение работы");
                System.exit(0);
            }
        }

        Copier copier = null;
        System.out.println("Какой пакет использовать для копирования файла: \n" +
                "IO(1), NIO(2), NIO2(3)?");
        int sw = console.nextInt();
        switch (sw) {
            case 1 -> copier = new IOCopier();
            case 2 -> copier = new NIOCopier();
            case 3 -> copier = new FileCopier();
            default -> {
                System.out.println("Неверный ввод");
                System.exit(0);
            }
        }

        copier.copyFile(sourcePath, destinationPath);

    }
}
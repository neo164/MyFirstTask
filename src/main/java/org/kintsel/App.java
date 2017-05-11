package org.kintsel;

import org.kintsel.service.TaskService;
import org.kintsel.service.impl.*;
import org.kintsel.util.FileUtils;

import java.util.Date;
import java.util.Scanner;

/**
 * Класс для демонстрации эффективности выполнения задачи
 *
 * @author kintsel
 */
public class App {
    public static void main(String[] args) {

        //на выбор можно протестировать одну из реализаций
        TaskService service = new TaskServiceImplSecond(); //TODO create object of your class implementation
        //TaskService service = new TaskServiceImpl();

        System.out.println("Тестовое задание, используется реализация: "+service.getClass().getName());
        Scanner scanner = new Scanner(System.in);

        //считываем данные из файла
        String[] data = FileUtils.readStrings(FileUtils.DEFAULT_FILE_NAME);

        System.out.println("Обработка началась...");
        //засекаем время
        Date date1 = new Date();
        //вызываем метод для сортировки строк
        String[] strings = service.sortStrings(data);
        //засекаем время
        Date date2 = new Date();
        //вызываем метод для объединения строк
        String result = service.addStrings(strings);
        //засекаем время
        Date date3 = new Date();

        System.out.println("первый метод: " + (date2.getTime() - date1.getTime()) + " мс.");
        System.out.println("второй метод: " + (date3.getTime() - date2.getTime()) + " мс.");
        System.out.println("итого: " + (date3.getTime() - date1.getTime()) + " мс.");
        System.out.println("Нажмите Enter для выхода...");
        scanner.nextLine();
    }
}

package org.kintsel.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Утилитный класс для работы с файлом слов
 *
 * @author kintsel
 */
public class FileUtils {

    /**
     * имя файла
     */
    public static String DEFAULT_FILE_NAME = "data.txt";

    public static void main(String[] args) {
        generateFile(DEFAULT_FILE_NAME, 9, 5000, 30000);
    }

    /**
     * Создать файл содержащий случайно сгенерированные слова длиной от 3 до 5 символов
     *
     * @param fileName      имя файл
     * @param alphabetCount количество символов в алфавите (не более 11)
     * @param wordCount     количество "уникальных" генерируемых слов
     * @param lineCount     общее количество слов (строк) в генерируемом фале
     */
    public static void generateFile(String fileName, int alphabetCount, int wordCount, int lineCount) {
        String alphabet = " abcdefghij";
        if (alphabetCount > alphabet.length())
            alphabetCount = alphabet.length();
        if (alphabetCount < 2)
            alphabetCount = 2;

        String[] words = new String[wordCount];

        Random rnd = new Random();

        BufferedWriter bw = null;
        try {

            //генерируем слова
            for (int i = 0; i < wordCount; i++) {

                //генерируем длину случайной строки от 3 до 5 символов
                int len = rnd.nextInt(2) + 3;

                StringBuilder sb = new StringBuilder(len);
                for (int j = 0; j < len; j++) {
                    sb.append(alphabet.charAt(rnd.nextInt(alphabetCount)));
                }
                //после того как сформировали слово добавляем его в массив
                words[i] = sb.toString();
            }

            //создаем объект для записи в файл
            bw = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < lineCount; i++) {
                // пишем его в файл слова
                bw.write(words[rnd.nextInt(wordCount)]);
                bw.newLine();
            }

            System.out.println("Успешно создан файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * вернуть массив строк прочтенных из файла
     *
     * @param fileName - имя файла
     * @return массив считанных строк
     */
    public static String[] readStrings(String fileName) {

        //объект для чтения из файла
        BufferedReader br = null;

        //количество считываемых строк
        int lineCount = 0;
        ArrayList<String> wordList = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(fileName));
            String word;

            //пока не дошли до конца файла
            while ((word = br.readLine()) != null) {
                //добавляем найденное слово в список
                wordList.add(word);
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return wordList.toArray(new String[0]);
    }
}

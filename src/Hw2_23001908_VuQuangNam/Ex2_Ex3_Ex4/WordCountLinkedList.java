package Hw2_23001908_VuQuangNam.Ex2_Ex3_Ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCountLinkedList {

    public static void main(String[] args) {
        //readFile();
        readFromKeyBoard();
    }

    public static void readFromKeyBoard() {
        SimpleLinkedList<WordCount> wordList = new SimpleLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text (Ctrl + D to finish): ");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                WordCount wordCount = new WordCount(word, 1);

                if (wordList.isContain(wordCount)) {
                    for (int i = 0; i < wordList.size(); i++) {
                        WordCount wc = wordList.get(i);
                        if (wc.equals(wordCount)) {
                            wc.incrementCount();
                            break;
                        }
                    }
                } else {
                    wordList.add(wordCount);
                }
            }
        }

        scanner.close();

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }

    public static void readFile() {
        SimpleLinkedList<WordCount> wordList = new SimpleLinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("/D:/NAM HAI/CTDLTT//src//Hw2_23001908_VuQuangNam//Demo2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    WordCount wordCount = new WordCount(word, 1);

                    if (wordList.isContain(wordCount)) {
                        for (int i = 0; i < wordList.size(); i++) {
                            WordCount wc = wordList.get(i);
                            if (wc.equals(wordCount)) {
                                wc.incrementCount();
                                break;
                            }
                        }
                    } else {
                        wordList.add(wordCount);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}


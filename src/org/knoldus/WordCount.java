package org.knoldus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    private static String FILE_LOCATION = "/home/knoldus/memorydump.txt";

    public void findWordsCountInFile() {
        try {
            BufferedReader bufferedFile = new BufferedReader(new FileReader(FILE_LOCATION));
            String fileContent = "";
            String lines;
            while ((lines = bufferedFile.readLine()) != null) {
                fileContent = fileContent.concat(lines + " ");
            }
            Map<String, List<Word>> fileData = Arrays.stream(fileContent.split(" "))
                    .map(word -> new Word(word, 1))
                    .collect(Collectors.groupingBy(key -> key.word));
            Map<String, String> result = new HashMap<>();
            for (String key : fileData.keySet()) {
                result.put(key, fileData.get(key).size() + "");
            }
            result.forEach(
                    (key, value) -> System.out.format("\nWord: %s  Count: %s ", key, value)
            );
        } catch (Exception except) {
            System.out.println(except.getMessage());
        }
    }

    public void wordCountInSentence(String sentence) {
        Arrays.stream(sentence.split(" "))
                .map(word -> new Word(word, 1))
                .collect(Collectors.groupingBy(wordObject -> wordObject.word)).forEach(
                (key, value) -> System.out.format("\nWord: %s  Count: %s ", key, value.size()));
    }

    class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}

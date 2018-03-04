package org.knoldus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public Map<String, String> findWordsCount(String url) {
        try {
            BufferedReader bufferedFile = new BufferedReader(new FileReader(url));
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
            return result;

        } catch (Exception except) {
            System.out.println(except.getMessage());
        }
        return new HashMap<>();
    }

    public Map<String, List<Word>> findWordCountInSentence(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> new Word(word, 1))
                .collect(Collectors.groupingBy(wordObject -> wordObject.word));
    }
}

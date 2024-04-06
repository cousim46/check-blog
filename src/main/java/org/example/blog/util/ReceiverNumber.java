package org.example.blog.util;

import java.util.Arrays;
import java.util.List;

public class ReceiverNumber {

    public static String choice(String numbers) {
        List<String> numberList = Arrays.stream(numbers.split(",")).map(String::trim).toList();
        int randomIndex = (int) (Math.random() * numberList.size());
        return numberList.get(randomIndex);
    }
}

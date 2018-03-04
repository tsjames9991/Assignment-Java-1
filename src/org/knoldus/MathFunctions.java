package org.knoldus;

import java.util.stream.IntStream;

public class MathFunctions {

    MathOperation isPrime = (int number) -> {
        if (number == 1) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    };

    public IntStream findPrimes() {
        return (IntStream
                .range(1, 100)
                .filter(number -> isPrime.checker(number))
        );
    }

    public int[] multiplyTwoLists(int[] listFirst, int[] listSecond) {
        return IntStream.range(0, Math.min(listFirst.length, listSecond.length))
                .map(index -> listFirst[index] * listSecond[index]).toArray();
    }

    @FunctionalInterface
    interface MathOperation {

        boolean checker(int a);
    }
}

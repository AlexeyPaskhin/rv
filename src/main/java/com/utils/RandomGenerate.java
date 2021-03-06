package com.utils;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerate {
    private static Random rand = new Random();
    private static RandomStringGenerator randomStringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', 'z')
                    .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                    .build();

    private static RandomStringGenerator randomStringOfDigitsGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', '9')
                    .filteredBy(CharacterPredicates.DIGITS)
                    .build();

    public static String randomString(int length) {
        return randomStringGenerator.generate(length);
    }

    public static String randomString(int fromLength, int toLength) {
        return randomStringGenerator.generate(rand.nextInt(toLength) + fromLength);
    }

    public static String randomStringOfDigits(int length) {
        return randomStringOfDigitsGenerator.generate(length);
    }

    public static int generateRandomIntWithinRange(int min, int boundExclusive) {
        return ThreadLocalRandom.current().nextInt(min, boundExclusive);

    }
}

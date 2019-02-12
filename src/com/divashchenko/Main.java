package com.divashchenko;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@test.com", "test.e.mail+bob.cathy@test.com", "testemail+david@lee.test.com"};
        System.out.println(Arrays.toString(emails));
        System.out.println(numUniqueEmails(emails));

        System.out.println();

        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(Arrays.toString(words));
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int numUniqueEmails(String[] emails) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> setEmails = new HashSet<>();

        for (String email : emails) {
            boolean deleteNext = false;
            sb.append(email);
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '@') {
                    break;
                } else if (sb.charAt(j) == '.') {
                    sb.deleteCharAt(j);
                } else if (sb.charAt(j) == '+') {
                    deleteNext = true;
                }

                if (deleteNext) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
            setEmails.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return setEmails.size();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        StringBuilder sb = new StringBuilder();
        HashSet<String> setMorse = new HashSet<>();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= 'A' && word.charAt(j) <= 'Z') {
                    sb.append(MORSE[word.charAt(j) - 65]);
                } else if (word.charAt(j) >= 'a' && word.charAt(j) <= 'z') {
                    sb.append(MORSE[word.charAt(j) - 97]);
                } else {
                    throw new IllegalArgumentException("Wrong command!");
                }
            }
            setMorse.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return setMorse.size();
    }
}

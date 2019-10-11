package com.mvabiguzzi.hackerrank.interview.preparation.kit.warmup;

public class RepeatedString {

    static int countLetters(final String stringToSearch, final String letter) {
        return stringToSearch.replaceAll(String.format("[^%s]", letter), "").length();
    }

    static long repeatedString(final String s, final long n) {
        String stringToSearch;

        try {
            stringToSearch = s.substring(0, (int) n);
        } catch (IndexOutOfBoundsException e) {
            stringToSearch = s;
        }

        long words = n / stringToSearch.length();
        long letters = n % stringToSearch.length();

        int qtdAs = countLetters(stringToSearch, "a");
        return (qtdAs *words)+countLetters(stringToSearch.substring(0, (int) letters), "a");
    }

    public static void main(String[] args) {
        long result = repeatedString("aba", 10);
        System.out.println("Result: "+result);

        result = repeatedString("a", 1000000000000L);
        System.out.println("Result: "+result);

        result = repeatedString("abcac", 10);
        System.out.println("Result: "+result);

        result = repeatedString("bcc", 10);
        System.out.println("Result: "+result);

        result = repeatedString("gfcaaaecbg", 547602);
        System.out.println("Result: "+result);

        result = repeatedString("aab", 882787);
        System.out.println("Result: "+result);
    }

}

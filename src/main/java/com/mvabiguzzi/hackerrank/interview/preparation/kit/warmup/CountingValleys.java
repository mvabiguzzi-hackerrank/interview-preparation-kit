package com.mvabiguzzi.hackerrank.interview.preparation.kit.warmup;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int newLevel = c == 'D' ? level-1 : level+1;

            if (level < 0 && newLevel == 0) valleys++;

            level = newLevel;
        }

        return valleys;
    }

    public static void main(String[] args) {
        final String path = "UDDDUDUU";

        int valleys = countingValleys(path.length(), path);

        System.out.println(valleys);
    }

}
 ;
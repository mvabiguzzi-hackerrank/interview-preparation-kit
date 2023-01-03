package com.mvabiguzzi.hackerrank.interview.preparation.kit.arrays;

import java.util.*;

public class NewYearChaos {

    public static void minimumBribes(final List<Integer> queue) {
        int qtdBribes = 0;

        for (int i = queue.size(); i > 0; i--) {
            int actualIndex = queue.indexOf(i);
            int actualPos = actualIndex +1;

            int bribes = Math.abs(i - actualPos);

            if (bribes > 0) {
                if (bribes > 2) {
                    System.out.println("Too chaotic");
                    return;
                }

                queue.remove(actualIndex);
                queue.add(i-1, i);

                qtdBribes+=bribes;
            }

        }

        System.out.println(qtdBribes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();

            List<Integer> queue = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                queue.add(i, scanner.nextInt());
            }

            minimumBribes(queue);
        }
    }
}

package com.mvabiguzzi.hackerrank.interview.preparation.kit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            Integer e = a.remove(0);
            a.add(e);
        }

        return a;
    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        final int rotations = 2;

        System.out.println(rotLeft(integerList, rotations));
    }
}

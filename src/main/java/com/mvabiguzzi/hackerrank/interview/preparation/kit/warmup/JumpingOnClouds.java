package com.mvabiguzzi.hackerrank.interview.preparation.kit.warmup;

import java.util.ArrayList;
import java.util.List;

public class JumpingOnClouds {
    static int jumpingOnClouds(int[] clouds) {
        List<Integer> path = func(clouds, 2);

        System.out.println(path);
        return path.size();
    }

    static List<Integer> func(int[] c, int index) {
        final List<Integer> result = new ArrayList<>();
        try {
            if (c[index] == 0) {
                result.add(index);
                result.addAll(func(c, index+2));
            } else {
                result.addAll(func(c, index-1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (index - c.length == 0) result.addAll(func(c, index-1));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] clouds = new int[]{ 0,0,1,0,0,1,0 };

        int qtdJumps = jumpingOnClouds(clouds);
        System.out.println(qtdJumps);

        clouds = new int[]{ 0,0,0,0,1,0 };

        qtdJumps = jumpingOnClouds(clouds);
        System.out.println(qtdJumps);

        clouds = new int[]{ 0,0,0,1,0,0 };

        qtdJumps = jumpingOnClouds(clouds);
        System.out.println(qtdJumps);
    }
}

package com.mvabiguzzi.hackerrank.interview.preparation.kit.warmup;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Objects;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> sockColorQtd = new HashMap<>();
        for (int color: ar) {
            sockColorQtd.compute(color, (key, value) -> Objects.isNull(value) ? 1 : value+1);
        }

        return sockColorQtd.entrySet().stream()
                .map(entry -> new HashMap.SimpleEntry<>(entry.getKey(), Math.floorDiv(entry.getValue(), 2)))
                .filter(entry -> entry.getValue() > 0)
                .map(AbstractMap.SimpleEntry::getValue).reduce(0, Math::addExact);
    }

    public static void main(String args[]) {
        int[] colors = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(colors.length, colors));
    }
}

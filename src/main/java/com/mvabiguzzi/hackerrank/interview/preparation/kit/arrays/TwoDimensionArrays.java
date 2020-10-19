package com.mvabiguzzi.hackerrank.interview.preparation.kit.arrays;

import java.util.Arrays;
import java.util.Collections;

public class TwoDimensionArrays {
  static int hourglassSum(int[][] arr) {
    final Integer[] hourglass = new Integer[(arr.length-2)*(arr[0].length-2)];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < (arr[i].length-1); j++) {

        if ((i < (arr[i].length-2)) && (j < (arr[j].length-2))) {
          final int hourglassId = (i*(arr[j].length-2))+j;
          hourglass[hourglassId] = arr[i][j]+arr[i][j+1]+arr[i][j+2];
        }

        if ((i > 0 && j > 0) && ((i < arr.length-1) && (j < arr[i].length-1))) {
          final int hourglassId = ((i-1)*(arr[j].length-2))+(j-1);
          hourglass[hourglassId] = hourglass[hourglassId]+arr[i][j];
        }

        if (i > 1 && j < (arr[j].length-2)) {
          final int hourglassId = ((i-2)*(arr[j].length-2))+j;
          hourglass[hourglassId] = hourglass[hourglassId]+(arr[i][j]+arr[i][j+1]+arr[i][j+2]);
        }
      }
    }

    Arrays.sort(hourglass, Collections.reverseOrder());

    return hourglass[0];
  }

  public static void main(String[] args) {

    final int[][] ints = {
        {1,1,1,0,0,0},
        {0,1,0,0,0,0},
        {1,1,1,0,0,0},
        {0,0,2,4,4,0},
        {0,0,0,2,0,0},
        {0,0,1,2,4,0}
    };

    System.out.println(hourglassSum(ints));
  }
}

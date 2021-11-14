package ru.vsu.baryshev;

public class logic {
    public static double[][] solution(double[][] array) {

        double [][] arr2 = new double[array[0].length][array.length];

        for (int i = 0; i < array[0].length; i++) {

            for (int j = 0; j < array.length; j++) {
                arr2[i][j] = array[j][array[0].length - i - 1];
            }
        }
        return arr2;
    }
}

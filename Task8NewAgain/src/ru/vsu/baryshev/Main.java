package ru.vsu.baryshev;

import java.util.Scanner;
import ru.vsu.baryshev.InputArgs;
import ru.vsu.baryshev.util.ArrayUtils;

import javax.swing.*;

public class Main {
    public static boolean check() {
        Scanner in = new Scanner(System.in);
        int check2 = in.nextInt();
        boolean check;
        if (check2 == 1) {
            check = true;
        } else check = false;

        return check;
    }




    public static void main(String[] args) {
//        System.out.println("Would you like to enter the array manually?");
//        boolean check1 = check();
//        InputArgs p = InputArgs.parseCmdArgs(args, check1);
//        if (check1 == true) {
//            double[][] array = InputArgs.strToArr(p.strArr);
//            array = logic.solution(array);
//            InputArgs.printOfArray(array);
//        } else {
//            java.awt.EventQueue.invokeLater(new Runnable() {
//
//                @Override
//                public void run() {
//                    new FrameMain().setVisible(true);
//                }
//            });
//
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        }) ;


    }
}
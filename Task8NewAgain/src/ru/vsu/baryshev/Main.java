package ru.vsu.baryshev;

import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);       //testOfReading1.txt  testOfWriting1.txt

    if(args.length>0){

        InputArgs p = InputArgs.parseCmdArgs(args);
        double[][] array = InputArgs.strToArr(p.strArr);
        if(array==null){
            System.out.println("Wrong input format, do in like 1,2,3-4,5,7");
            return;
        }
        array = logic.solution(array);
        InputArgs.printOfArray(array);

    } else {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });

   }

    }
}
package ru.vsu.baryshev;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.out;

public class InputArgs {

    public String inputFile;
    public String outputFile;
    public String strArr;

    public InputArgs(String inputFile,String outputFile) {
        this.inputFile = inputFile;
        this.outputFile=outputFile;
    }
    public InputArgs(String strArr){
        this.strArr=strArr;
    }

    public static InputArgs parseCmdArgs(String[] args){

        InputArgs file = new InputArgs(args[0]);

        return file;
    }

    public static double[][] strToArr(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a'&&ch<='z'||ch>='а'&&ch<='я'){
                return null;
            }
        }

        String[] help1Array = str.split("-");
        String[][] help2Array = new String[help1Array.length][help1Array[0].length()];

        for (int i = 0; i < help1Array.length; i++) {
            help2Array[i] = help1Array[i].split(",");

        }

        double[][] arr=new double[help2Array.length][help2Array[0].length];

        for(int i=0;i<help2Array.length;i++){

            for(int j=0;j<help2Array[0].length;j++){

                arr[i][j]=Double.parseDouble(help2Array[i][j]);
            }
        }
        return arr;

    }
    public static double[][] fileToArray(String str,boolean checkForCLI) throws FileNotFoundException {

        File file = new File(str);
        double[][] arr = new double[0][];

        if (file.length() == 0) {
            out.println("Файл пуст");

        } else {

            Scanner scn = new Scanner(file);
            ArrayList<String[]> nums = new ArrayList<>();

            while (scn.hasNext()) {
                nums.add(scn.nextLine().split(" "));
            }

            int columns = nums.get(0).length;
            arr = new double[nums.size()][columns];
            Iterator<String[]> iter = nums.iterator();

            for (int i = 0; i < arr.length; i++) {

                String[] s = iter.next();

                for (int j = 0; j < columns; j++) {

                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            scn.close();
        }
        return arr;
    }

    public static String testOfReadingWithAsking(){

        Scanner in = new Scanner(System.in);
        out.print("Path= ");
        String path = in.nextLine();

        return path;
    }

    public  static void saving(PrintStream pw,double[][] array){

        for(int i=0;i<array.length;i++) {

            for (int j=0; j<array[i].length; j++) {

                pw.print(array[i][j] + " ");
            }
            pw.println();
        }

        out.flush();
        out.close();
    }
    public static void printOfArray(double[][] array) {

        out.println(Arrays.deepToString(array));
    }
    public static void printArr2(int[][] arr2){

        for(int r=0;r<arr2.length; r++){

            if(arr2[r]==null){

                out.println("null");
            }else {

                for(int c =0; c<arr2[r].length;c++){

                    out.println((c>0?",":"")+arr2[r][c]);
                }
                out.println();
            }
        }
    }

}

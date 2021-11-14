package ru.vsu.baryshev;

import javax.swing.*;
import ru.vsu.baryshev.util.JTableUtils;
import ru.vsu.baryshev.util.ArrayUtils;
import ru.vsu.baryshev.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class FrameMain extends JFrame {
    private JTextField pathOfReading;
    private JTextField textField2;
    private JTextField textField3;
    private JButton сложитьButton;
    private JPanel panelMain;
    private JTable table1;
    private JButton прочестьИзФайлаButton;
    private JButton записьВФайлButton;
    private JTextField pathOfWriting;
    private JButton обработкаButton;

    public FrameMain(){
        this.setTitle("ТАбличка");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        прочестьИзФайлаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = pathOfReading.getText();
                double [][]array = ArrayUtils.readDoubleArray2FromFile(path);
                JTableUtils.writeArrayToJTable(table1,array);
            }
        });
        записьВФайлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = pathOfWriting.getText();
                double[][] arr = WorkWithJT.writeJTtoArray(table1);

                try {
                    PrintStream ps = new PrintStream(path);
                    InputArgs.saving(ps,arr);
                } catch (FileNotFoundException ex) {
                    System.out.println();
                }

            }
        });
        обработкаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double [][]array = WorkWithJT.writeJTtoArray(table1);
                // array = logic.solution(array);
               // JTableUtils.writeArrayToJTable(table1,array);
            }
        });

    }

    }


package ru.vsu.baryshev;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Vector;

public class WorkWithJT {

    public static double[][] writeJTtoArray( JTable jt)  {

        Locale.setDefault(Locale.ENGLISH);
        double[][] array= new double[jt.getRowCount()][jt.getColumnCount()];

        for (int i = 0; i < array.length; i++) {

            for(int j =0;j< array[0].length;j++){

                array[i][j] = Double.parseDouble((String)  jt.getValueAt(i,j));
            }
        }
        return array;
    }
    public static  JTable createOfJT(double [][] array) {
        Locale.setDefault(Locale.ENGLISH);

        int columns = array[0].length;

        DefaultTableModel model = new DefaultTableModel(0, columns) {

            public Class getColumnClass(int column) {

                return Integer.class;
            }
        };

        for (int i = 0; i < array.length; i++) {

            double[] rowData = array[i];
            Vector<Object> row = new Vector<Object>(columns);

            for (int j = 0; j < rowData.length; j++)
                row.addElement(new Double (rowData[j]));

            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Task 8 var11");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return table;
    }
}

package org.guru.view;


import org.guru.model.Stock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StockListUI   {

    public static JPanel initPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("LİST"));
        JPanel up = new JPanel(new GridLayout(4,2));


        JLabel idLabel = new JLabel("Stok Code:", JLabel.LEFT);
        up.add(idLabel);


        JTextField idField = new JTextField();
        up.add(idField);

        JList<Object> stockList = new JList<Object> ();
        stockList.setListData(new Stock().getAllSqlSentence().toArray());


        JScrollPane pane = new JScrollPane(stockList);
        pane.setBorder(BorderFactory.createTitledBorder("List Card"));
        stockList.setSelectedIndex(0);
        panel.add(up,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);
        idField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean tryParse;

                try{
                    Integer.parseInt(idField.getText());
                    tryParse = true;
                }
                catch (NumberFormatException numberFormatException){
                    tryParse = false;
                }

                if (tryParse != false){

                    stockList.setListData(new Stock().listSqlSentence(Integer.parseInt(idField.getText())).toArray());
                    stockList.setSelectedIndex(0);
                }
                else {
                    stockList.setListData(new Stock().getAllSqlSentence().toArray());
                }
            }
        });

            return panel;
    }

}

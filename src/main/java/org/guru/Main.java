package org.guru;

import org.guru.controller.StockFrameController;
import org.guru.model.Stock;
import org.guru.hibernate.HibernateUtil;
import org.guru.view.MainWindow;
import org.guru.view.StockUI;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.merge(stock);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StockFrameController().execute();
            }
        });


}
}
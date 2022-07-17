package org.guru.command;

import org.guru.model.Stock;
import org.guru.view.StockUI;

import javax.swing.*;

public class DeleteButtonCommand implements Command {

    private final StockUI stockUI;

    public DeleteButtonCommand(StockUI stockUI) {
        this.stockUI = stockUI;
    }
    @Override
    public void execute() {
        Stock stock = new Stock();
        JOptionPane.showMessageDialog(null,"Ürünü silmek istediğinizden emin misiniz?");
        stock.setStockId(stockUI.getStockId());
        stock.deleteSqlSentence();
        stockUI.clear();
        JOptionPane.showMessageDialog(null,stock.getStockId()+" deleted.");


    }
}

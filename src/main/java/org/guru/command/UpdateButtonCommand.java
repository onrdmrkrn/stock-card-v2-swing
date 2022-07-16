package org.guru.command;

import org.guru.model.Stock;
import org.guru.view.StockUI;

import javax.swing.*;

public class UpdateButtonCommand implements Command{

    private final StockUI stockUI;

    public UpdateButtonCommand(StockUI stockUI) {
        this.stockUI = stockUI;
    }


    @Override
    public void execute() {

        Stock stock = new Stock();
        stock.setStockCode(stockUI.getStockCode());
        stock.setStockName(stockUI.getStockName());
        stock.setStockDescription(stockUI.getStockDescription());
        stock.setStockId(stockUI.getStockId());
        stock.setBarcode(stockUI.getBarcode());
        stock.setKdv(stockUI.getKdv());
        stock.setCreatedDate(stockUI.getCreatedDate());
        stock.setPrice(stockUI.getPrice());
        stock.setStockType(stockUI.getStockType());
        stock.setUnit(stockUI.getUnit());
        stock.updateSqlSentence(stock);

        JOptionPane.showMessageDialog(null,stock.getStockName()+" updated.");


    }
}

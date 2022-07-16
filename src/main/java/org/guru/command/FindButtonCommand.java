package org.guru.command;

import org.guru.model.Stock;
import org.guru.view.StockUI;

import java.awt.*;
import java.sql.Date;

public class FindButtonCommand implements Command{

    private final StockUI stockUI;


    public FindButtonCommand(StockUI stockUI){
        this.stockUI= stockUI;
    }


    @Override
    public void execute() {

        Stock stock = new Stock().findSqlSentence(stockUI.getStockId());
        stockUI.setStockName(stock.getStockName());
        stockUI.setStockDescription(stock.getStockDescription());
        stockUI.setStockCode(stock.getStockCode());
        stockUI.setBarcode(stock.getBarcode());
        stockUI.setKdv(stock.getKdv());
        stockUI.setCreatedDate(Date.valueOf(String.valueOf(stock.getCreatedDate())));
        stockUI.setPrice(stock.getPrice());
        stockUI.setStockType(stock.getStockType());
        stockUI.setUnit(stock.getUnit());


    }
}

package org.guru.controller;

import org.guru.command.*;
import org.guru.core.GeneralAction;
import org.guru.view.MainWindow;
import org.guru.view.StockUI;
import java.awt.*;

public class StockFrameController {
    private StockUI stockUI;


    public StockFrameController(StockUI stockUI) {
        this.stockUI = stockUI;

    }

    public StockFrameController() {
    }

    public void execute() {

        MainWindow mainWindow = new MainWindow();
        stockUI = mainWindow.getStockUI();
        stockUI.saveButton.addActionListener(new GeneralAction(new SaveButtonCommand(stockUI)));
        stockUI.updateButton.addActionListener(new GeneralAction(new UpdateButtonCommand(stockUI)));
        stockUI.findButton.addActionListener(new GeneralAction(new FindButtonCommand(stockUI)));
        stockUI.deleteButton.addActionListener(new GeneralAction(new DeleteButtonCommand(stockUI)));

        stockUI.setLayout(new GridLayout(14,6));

    }
}

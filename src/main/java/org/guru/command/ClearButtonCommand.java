package org.guru.command;

import org.guru.view.StockUI;

public class ClearButtonCommand implements Command{

    private final StockUI stockUI;

    public ClearButtonCommand(StockUI stockUI) {
        this.stockUI = stockUI;
    }

    @Override
    public void execute() {
        stockUI.idField.setText("");
        stockUI.barcodeField.setText("");
        stockUI.nameField.setText("");
        stockUI.descriptionArea.setText("");
        stockUI.typeBox.setSelectedIndex(0);
        stockUI.unitBox.setSelectedIndex(0);
        stockUI.kdvBox.setSelectedIndex(0);
        stockUI.priceField.setText("");
        stockUI.chooseDate.setDate(null);
        stockUI.codeField.setText("");


    }
}

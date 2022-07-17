package org.guru.view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;



public class StockUI extends JPanel {


	public void clear() {
		idField.setText("");
		barcodeField.setText("");
		nameField.setText("");
		descriptionArea.setText("");
		typeBox.setSelectedIndex(0);
		unitBox.setSelectedIndex(0);
		kdvBox.setSelectedIndex(0);
		priceField.setText("");
		chooseDate.setDate(null);
		codeField.setText("");
	}
	private static StockUI stockUI;
	public static StockUI getInstance (){
		if (stockUI == null){
			stockUI = new StockUI();
		}
		return stockUI;
	}
	JLabel idLabel = new JLabel("Stock ID:", JLabel.LEFT);
	public JTextField idField = new JTextField();
	public JLabel codeLabel = new JLabel("Stock Code:", JLabel.LEFT);
	public JTextField codeField = new JTextField();

	public JLabel nameLabel = new JLabel("Stock Name:", JLabel.LEFT);
	public JTextField nameField = new JTextField();

	public JLabel descriptionLabel = new JLabel("Stock Description:", JLabel.LEFT);
	public JTextArea descriptionArea = new JTextArea();

	public JScrollPane descScrollPane = new JScrollPane();

	public JLabel unitLabel = new JLabel("Unit: ", JLabel.LEFT);
	public JComboBox<String> unitBox = new JComboBox<String>();
	public JLabel barcodeLabel = new JLabel("Barcode: ", JLabel.LEFT);
	public JTextField barcodeField = new JTextField();
	public JLabel kdvLabel = new JLabel("KDV:", JLabel.LEFT);
	public JComboBox <String> kdvBox = new JComboBox<String>();
	public JTextField priceField = new JTextField();
	public JLabel priceLabel = new JLabel("Price: ", JLabel.LEFT);
	public JLabel typeLabel = new JLabel("Stock Type: ", JLabel.LEFT);
	public JComboBox<String> typeBox = new JComboBox<String>();

	public JLabel dateLabel = new JLabel("Choose Date: ",JLabel.LEFT);

	public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public JDateChooser chooseDate = new JDateChooser();

	public JButton saveButton = new JButton("Save");

	public JButton updateButton = new JButton("Update");

	public JButton findButton = new JButton("Find");

	public JButton deleteButton = new JButton("Delete");


	public StockUI(){
		initPanel();
	}


	public void initPanel() {


		if (unitBox != null){
			System.out.println("girdi");
		}


		add(idLabel);
		add(idField);
		add(codeLabel);
		add(codeField);
		add(nameLabel);
		add(nameField);
		add(descriptionLabel);
		add(descriptionArea);
		descriptionArea.add(descScrollPane);

		unitBox.insertItemAt("---Please Choose Unit",0);
		unitBox.setSelectedIndex(0);
		unitBox.insertItemAt("Dolar",1);
		unitBox.insertItemAt("Lira",2);
		unitBox.insertItemAt("Euro",3);
		unitBox.insertItemAt("Sterlin",4);
		add(unitLabel);
		add(unitBox);

		kdvBox.insertItemAt("---Please Choose KDV--",0);
		kdvBox.insertItemAt("%9",1);
		kdvBox.insertItemAt("%18",2);
		kdvBox.insertItemAt("%27",3);
		kdvBox.setSelectedIndex(0);
		add(kdvLabel);
		add(kdvBox);


		typeBox.insertItemAt("--Please Choose Stock Type--",0);
		typeBox.insertItemAt("1",1);
		typeBox.insertItemAt("2",2);
		typeBox.insertItemAt("3",3);
		typeBox.insertItemAt("4",4);
		typeBox.setSelectedIndex(0);

		add(typeLabel);
		add(typeBox);

		add(priceLabel);
		add(priceField);

		add(barcodeLabel);
		add(barcodeField);

		add(dateLabel);
		add(chooseDate);

		add(saveButton);
		add(updateButton);
		add(findButton);
		add(deleteButton);


	}
	public String getStockCode() {
		return codeField.getText();
	}

	public String getStockName() {
		return nameField.getText();
	}

	public String getStockDescription() {
		return descriptionArea.getText();
	}
	public int getStockId() {

		idField.setBackground(Color.GRAY);
		idField.setToolTipText("Stock Code not uptaded.");
		return Integer.parseInt(idField.getText());
	}

	public String getBarcode() {
		return barcodeField.getText();
	}

	public double getKdv() {

		String existskdv = String.valueOf(kdvBox.getSelectedItem());
		existskdv = existskdv.replace("%","");

		switch (existskdv){
			case "9.0":
				kdvBox.setSelectedIndex(1);
				break;

			case "18.0":
				kdvBox.setSelectedIndex(2);
				break;
			case "27.0":
				kdvBox.setSelectedIndex(3);

				break;
		}
		return Double.parseDouble(existskdv);
	}

	public Date getCreatedDate() {
		String date = format.format(chooseDate.getDate());
		return Date.valueOf(date);
	}

	public float getPrice() {
		return Float.parseFloat(priceField.getText());
	}

	public int getStockType() {
		String existsType = String.valueOf(typeBox.getSelectedItem());
		return Integer.parseInt(existsType);
	}

	public String getUnit() {
		return String.valueOf(unitBox.getSelectedItem());
	}

	public void setStockName(String stockName) {
		nameField.setText(stockName);

	}

	public void setStockDescription(String stockDescription) {
		descriptionArea.setText(stockDescription);
	}

	public void setStockCode(String stockCode) {
		codeField.setText(stockCode);
	}

	public void setBarcode(String barcode) {
		barcodeField.setText(barcode);
	}

	public void setKdv(double kdv) {
		String existskdv;
		existskdv = String.valueOf(kdv);
		existskdv = existskdv.replace("%","");

		switch (existskdv){
			case "9.0":
				kdvBox.setSelectedIndex(1);
				break;

			case "18.0":
				kdvBox.setSelectedIndex(2);
				break;
			case "27.0":
				kdvBox.setSelectedIndex(3);

				break;
		}
	}

	public void setCreatedDate(Date createdDate) {
		chooseDate.setDate(createdDate);
	}

	public void setPrice(float price) {
		priceField.setText(String.valueOf(price));
	}

	public void setStockType(int stockType) {
		typeBox.setSelectedIndex(stockType);
	}

	public void setUnit(String unit) {
		unitBox.setSelectedItem(unit);
	}


}

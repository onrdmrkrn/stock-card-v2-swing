package org.guru.view;

import org.guru.model.Stock;
import org.guru.model.StockComplexType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame  {

	StockUI stockUI = StockUI.getInstance();
	public MainWindow() {
		initWindow();
	}

	public void initWindow() {
		JPanel panel = initPanel();
		add(panel);
		setTitle("STOCK CARD APP");
		setVisible(true); 
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JTabbedPane pane = initTabs();
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	public JTabbedPane initTabs() {

		JTabbedPane pane = new JTabbedPane();

		ImageIcon icon = new ImageIcon("icons/79739_cut_scissors_stock_icon (2).png");
		ImageIcon icon2 = new ImageIcon("icons/24px.png");
		ImageIcon icon3 = new ImageIcon("icons/hmg.png");

		JPanel stockPanel = new JPanel(new BorderLayout());

		JPanel stockLeftPanel = new JPanel(new BorderLayout());
		JPanel stockLeftUpPanel = new JPanel(new GridLayout(6,2));
		JPanel stockLeftUnderPanel = new JPanel();


		stockLeftPanel.setBorder(BorderFactory.createTitledBorder("Stock Information"));
		Object [] stockColumn = {"Stock Id","Stock Name","Unit","Barcode","Stock Description","Created Date","Stock Type","KDV","Price","Stock Code"};
		DefaultTableModel model = new DefaultTableModel(stockColumn,0);
		JTable table = new JTable(model);
		JScrollPane stockTablePane = new JScrollPane(table);
		for (StockComplexType complexType: new Stock().getAllSqlSentenceType()){
			model.addRow(complexType.getInfo());
		}

		JButton stockRefreshButton = new JButton("Refresh");
		stockLeftUpPanel.add(stockRefreshButton);

		stockRefreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int refresh = model.getRowCount();
				for (int i = 0; i <refresh ; i++) {
					model.removeRow(0);
				}


				for (StockComplexType type: new Stock().getAllSqlSentenceType()){
					model.addRow(type.getInfo());
				}
			}
		});

		JButton quitButton = new JButton("Quit");
		stockLeftUnderPanel.add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		stockPanel.add(stockLeftPanel,BorderLayout.WEST);
		stockPanel.add(stockTablePane,BorderLayout.CENTER);
		stockLeftPanel.add(stockLeftUpPanel, BorderLayout.NORTH);
		stockLeftPanel.add(stockLeftUnderPanel,BorderLayout.SOUTH);

		pane.addTab("My First Swing Project Tex", icon, stockPanel,"Main Page");
		pane.addTab("Card Processes", icon3, stockUI, "Processes Page");
		pane.addTab("",icon2,StockListUI.initPanel(),"Search Page");

		return pane;
	}
	public StockUI getStockUI() {
		return StockUI.getInstance();
	}

}

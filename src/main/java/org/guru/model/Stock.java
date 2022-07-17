package org.guru.model;




import org.guru.core.SingletonConnection;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "stock_entity")
public class Stock {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int stockId;

	@Column(unique = true, length = 50)
	private String stockCode;

	@Column(length = 100)
	private String stockName;
	@Column(length = 10)
	private String unit;
	@Column(length = 30)
	private String barcode;

	private String stockDescription;


	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Column(length = 2)
	private int stockType;
	private double kdv;
	private float price;

	@Override
	public String toString() {
		return "Stock{" +
				"stockId=" + stockId +
				", stockCode='" + stockCode + '\'' +
				", stockName='" + stockName + '\'' +
				", unit='" + unit + '\'' +
				", barcode='" + barcode + '\'' +
				", stockDescription='" + stockDescription + '\'' +
				", createdDate=" + createdDate +
				", stockType=" + stockType +
				", kdv=" + kdv +
				", price=" + price +
				'}';
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public double getKdv() {
		return kdv;
	}

	public void setKdv(double kdv) {
		this.kdv = kdv;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public  Stock findSqlSentence(int stockId){
		Stock stock = new Stock();

		Connection connection = SingletonConnection.getConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_entity WHERE stockId = "+stockId+"");
			while (resultSet.next()){

				stock.setStockId(resultSet.getInt("stockId"));
				stock.setStockName(resultSet.getString("stockName"));
				stock.setStockType(resultSet.getInt("stockType"));
				stock.setStockDescription(resultSet.getString("stockDescription"));
				stock.setBarcode(resultSet.getString("barcode"));
				stock.setUnit(resultSet.getString("unit"));
				stock.setCreatedDate(resultSet.getDate("createdDate"));
				stock.setKdv(resultSet.getDouble("kdv"));
				stock.setPrice(resultSet.getFloat("price"));
				stock.setStockCode(resultSet.getString("stockCode"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stock;
	}

	public List<Stock> listSqlSentence (int stockId){
		List<Stock> stockList = new ArrayList<Stock>();
		Connection connection = SingletonConnection.getConnection();

		try {
			Statement statement =connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_entity WHERE stockId LIKE '"
					+'%'
					+stockId
					+'%'
					+"'");

			while(resultSet.next()){
				Stock stock = new Stock();
				stock.setStockName(resultSet.getString("stockName"));
				stock.setStockType(resultSet.getInt("stockType"));
				stock.setBarcode(resultSet.getString("barcode"));
				stock.setKdv(resultSet.getDouble("kdv"));
				stock.setPrice(resultSet.getFloat("price"));
				stock.setCreatedDate(resultSet.getDate("createdDate"));
				stock.setStockDescription(resultSet.getString("stockDescription"));
				stock.setStockId(resultSet.getInt("stockId"));
				stock.setUnit(resultSet.getString("unit"));
				stock.setStockCode(resultSet.getString("stockCode"));

				stockList.add(stock);
			}




		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return stockList;
	}

	public void updateSqlSentence (){
		Connection connection = SingletonConnection.getConnection();


		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE stock_entity SET stockName='"
					+getStockName()
					+"', stockDescription='"
					+getStockDescription()
					+"',stockCode='"
					+getStockCode()
					+"', unit='"
					+getUnit()
					+"',barcode='"
					+getBarcode()
					+"', kdv="
					+getKdv()
					+", price="
					+getPrice()
					+",stockType = "
					+getStockType()
					+" WHERE stockId= "
					+getStockId()
					+"");


		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSqlSentence (){
		Stock stock = new Stock();
		Connection connection = SingletonConnection.getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE  FROM stock_entity WHERE stockId = "+getStockId()+"");


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Stock> getAllSqlSentence(){
		List<Stock> productList = new ArrayList<Stock>();
		Connection connection = SingletonConnection.getConnection();
		Stock product;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_entity");

			while (resultSet.next()) {

				product = new Stock();
				product.setStockId(resultSet.getInt("stockId"));
				product.setStockName(resultSet.getString("stockName"));
				product.setStockDescription(resultSet.getString("stockDescription"));
				product.setStockType(resultSet.getInt("stockType"));
				product.setBarcode(resultSet.getString("barcode"));
				product.setKdv(resultSet.getDouble("kdv"));
				product.setPrice(resultSet.getFloat("price"));
				product.setUnit(resultSet.getString("unit"));
				product.setCreatedDate(resultSet.getDate("createdDate"));
				product.setStockCode(resultSet.getString("stockCode"));

				productList.add(product);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public void insertSqlSentence(){
		Connection connection = SingletonConnection.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO stock_entity  (stockName, unit,stockCode, barcode, stockDescription,createdDate,stockType,kdv,stockId,price) "
					+"VALUES('"
					+ getStockName()
					+"','"
					+ getUnit()
					+ "','"
					+getStockCode()
					+"','"
					+getBarcode()
					+"','"
					+getStockDescription()
					+"','"
					+getCreatedDate()
					+"',"
					+getStockType()
					+","
					+getKdv()
					+","
					+getStockId()
					+","
					+getPrice()
					+")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public List<StockComplexType> getAllSqlSentenceType(){
		List<StockComplexType> productList = new ArrayList<StockComplexType>();
		Connection connection = SingletonConnection.getConnection();
		StockComplexType product;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_entity");

			while (resultSet.next()) {

				product = new StockComplexType();
				product.setStockId(resultSet.getInt("stockId"));
				product.setStockName(resultSet.getString("stockName"));
				product.setStockDescription(resultSet.getString("stockDescription"));
				product.setStockType(resultSet.getInt("stockType"));
				product.setBarcode(resultSet.getString("barcode"));
				product.setKdv(resultSet.getDouble("kdv"));
				product.setPrice(resultSet.getFloat("price"));
				product.setUnit(resultSet.getString("unit"));
				product.setCreatedDate(resultSet.getDate("createdDate"));
				product.setStockCode(resultSet.getString("stockCode"));

				productList.add(product);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
}

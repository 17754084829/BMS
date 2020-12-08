package model;

import java.sql.Date;

/**
 * 
 * @author Moyou
 *
 */
/*
 * 图书 书编号（主键）,书ID，书名字,库存数,类别,位置,录入时间,作者,预览图
 */
public class book {

	private String booknumber;// 书编号
	private int bookid;// 书ID
	private String bookname;// 书名字
	private int stock;// 库存数
	private String kind;// 类别
	private String location;// 位置
	private Date bookdate;// 录入时间
	private String author;// 作者
	private String logo;// 预览图

	public book() {

	}
	public book(String booknumber, int bookid, String bookname, int stock, String kind, String location, Date bookdate,
			String author, String logo) {
		super();
		this.booknumber = booknumber;
		this.bookid = bookid;
		this.bookname = bookname;
		this.stock = stock;
		this.kind = kind;
		this.location = location;
		this.bookdate = bookdate;
		this.author = author;
		this.logo = logo;
	}
	
	public String getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}

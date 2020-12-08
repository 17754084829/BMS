package model;

import java.sql.Date;

/**
 * 
 * @author Moyou
 *
 */
/*
 * 用户
 * 用户ID,名字,电话,性别,录入时间,借书时间,还书时间,书编号（外键）,有效否
 */
public class reader {

	private int readerid;//用户ID
	private String readername;//名字
	private String readertelephone;//电话
	private int readersex;//性别
	private Date registerdate;//录入时间
	private Date borrowtime;//借书时间
	private Date returntime;//还书时间
	private int readerusable;//有效否
	private String booknumber;//书编号
	
	public reader() {
		
	}	
	public reader(int readerid, String readername, String readertelephone, int readersex, Date registerdate,
			Date borrowtime, Date returntime, int readerusable, String booknumber) {
		super();
		this.readerid = readerid;
		this.readername = readername;
		this.readertelephone = readertelephone;
		this.readersex = readersex;
		this.registerdate = registerdate;
		this.borrowtime = borrowtime;
		this.returntime = returntime;
		this.readerusable = readerusable;
		this.booknumber = booknumber;
	}
	
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public String getReadertelephone() {
		return readertelephone;
	}
	public void setReadertelephone(String readertelephone) {
		this.readertelephone = readertelephone;
	}
	public int getReadersex() {
		return readersex;
	}
	public void setReadersex(int readersex) {
		this.readersex = readersex;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public Date getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}
	public Date getReturntime() {
		return returntime;
	}
	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}
	public int getReaderusable() {
		return readerusable;
	}
	public void setReaderusable(int readerusable) {
		this.readerusable = readerusable;
	}
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}

	
	
}

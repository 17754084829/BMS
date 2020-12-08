package model;

import java.sql.Date;

/**
 * 
 * @author Moyou
 *
 */
/*
 * 管理员
 * ID,名字,密码,电话,性别,录入时间,角色,有效否
 */
public class Admin {

	private int id;//ID
	private String name;//名字
	private String password;//密码
	private String telephone;//电话
	private int sex;//性别
	private Date addtime;//录入时间
	private int roles;//角色
	private int usable;//有效否
	
	public Admin() {
		
	}	

	public Admin(int id, String name, String password, String telephone, int sex, Date addtime, int roles, int usable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.telephone = telephone;
		this.sex = sex;
		this.addtime = addtime;
		this.roles = roles;
		this.usable = usable;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
	public int getUsable() {
		return usable;
	}
	public void setUsable(int usable) {
		this.usable = usable;
	}
}

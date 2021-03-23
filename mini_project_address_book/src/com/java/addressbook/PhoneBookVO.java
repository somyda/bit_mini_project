package com.java.addressbook;

public class PhoneBookVO {
	
	private Integer id;
	private String name;
	private String hp;
	private String tel;
	
	public PhoneBookVO() {
		super();
	}

	public PhoneBookVO(String name, String hp, String tel) {
		super();
		this.id = null;
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}

	public PhoneBookVO(Integer id, String name, String hp, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}
}

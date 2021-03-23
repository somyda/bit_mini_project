package com.java.addressbook;

import java.util.List;

public interface PhoneBookDAO {
	List<PhoneBookVO> getList();
	int addPhone(PhoneBookVO phoneBookVO);
	int deletePhone(int deleteId);
	List<PhoneBookVO> getSearch(String keyword);
}

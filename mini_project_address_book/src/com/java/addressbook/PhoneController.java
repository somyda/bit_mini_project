package com.java.addressbook;

import java.util.List;

public class PhoneController {

	private PhoneBookView phoneView;
	private PhoneBookDAO phoneDao;
	
	public PhoneController() {
		super();
	}
	
	public void execute(){
		phoneView = new PhoneBookView();
		phoneDao = new PhoneBookDAOImpl();
		
		boolean run = true;
		int menuNum ;
		int deleteId;
		List<PhoneBookVO> phoneList;
		PhoneBookVO phoneVO;
		String keyword;
		
		phoneView.showInit();
		
		while(run){
			menuNum = phoneView.showMenu();
			
			switch(menuNum){
				case 1:
					phoneList = phoneDao.getList();
					phoneView.showList(phoneList);
					break;
			
				case 2:
					phoneVO = phoneView.showAdd();
					phoneDao.addPhone(phoneVO);
					phoneView.showAddResult();
					break;
					
				case 3:
					deleteId = phoneView.showDelete();
					phoneDao.deletePhone(deleteId);
					phoneView.showDelResult();
					break;
					
				case 4:	
					keyword = phoneView.showSearch();
					phoneList = phoneDao.getSearch(keyword);
					phoneView.showSearchResult(phoneList);
					//phoneView.showSearchResult(phoneList, keyword);
					break;
					
				case 5:
					phoneView.showEnd();
					run = false;
					break;
					
				default :
					phoneView.showEtc();
					break;
			}	
		}	
	}
}



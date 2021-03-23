package com.java.phone;

import java.util.List;

public class PhoneController {

	private PhoeneView phoneView;
	private PhoneRepository phoneRepo;
	
	public PhoneController() {
		super();
	}
	
	public void excute(){
		phoneView = new PhoeneView();
		phoneRepo = new PhoneRepository();
		
		boolean run = true;
		int menuNum ;
		List<PhoneVO> phoneList;
		PhoneVO phoneVO;
		int delNo;
		String keyword;
		
		phoneView.showInit();
		
		while(run){
			menuNum = phoneView.showMenu();
			
			switch(menuNum){
				case 1:
					phoneList = phoneRepo.getList();
					phoneView.showList(phoneList);
					break;
			
				case 2:
					phoneVO = phoneView.showAdd();
					phoneRepo.addInfo(phoneVO);
					phoneView.showAddResult();
					break;
					
				case 3:
					delNo = phoneView.showDel();
					phoneRepo.delInfo(delNo);
					phoneView.showDelResult();
					break;
					
				case 4:	
					keyword = phoneView.showSearch();
					phoneList = phoneRepo.getList();
					phoneView.showSearchResult(phoneList, keyword);
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

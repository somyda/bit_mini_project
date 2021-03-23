package com.java.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {
	String phoneDB = "C:\\workspace\\somy_bit_edu\\bin\\AddressBook\\phoneDB.txt";

    //	phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<PhoneVO> getList(){
		
	    //	전화번호들 관리를 위한 리스트
		List<PhoneVO> list = new ArrayList<PhoneVO>();
		
		try {
			//Reader fr = new FileReader("phoneDB.txt");
			Reader fr = new FileReader(phoneDB);
			BufferedReader br = new BufferedReader(fr);
			
			while(true){
				PhoneVO phoneVO = new PhoneVO();
				String line;
				
				line = br.readLine();
				if(line!=null){
					String[] dataArray = new String[3];
					dataArray = line.split(",");
					
					if (dataArray.length != 3) continue;
					
					phoneVO.setName(dataArray[0]);
					phoneVO.setHp(dataArray[1]);
					phoneVO.setTel(dataArray[2]);
					
					list.add(phoneVO);
					
				}else{
					break;
				}
				
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		} 
		return list;
		
	}

	//	phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<PhoneVO> list){
		
		try {
			//	Writer fr = new FileWriter("phoneDB.txt");
			Writer fr = new FileWriter(phoneDB);
			BufferedWriter bw = new BufferedWriter(fr);
			
			String listStr = "";
			
			for(int i=0; i<list.size(); i++ ){
				listStr = listStr + list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getTel()+"\n";
			}
		
            bw.write(listStr);
            bw.flush();
            bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//	기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(PhoneVO phoneVO) {
		List<PhoneVO> list=getList();
		list.add(phoneVO);
		saveInfo(list);
	}

	//	선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) {
		List<PhoneVO> list=getList();
		list.remove(num-1);
		saveInfo(list);
	}
	

}

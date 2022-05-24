package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		
		PhoneDao phoneDao = new PhoneDao();
		Scanner sc = new Scanner(System.in);
		int mNum;
		String name;
		String hp;
		String company;
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("-----------------------------------------------");
			System.out.print(">메뉴번호:");
			mNum = sc.nextInt();
		
			if(mNum == 1) {
				//리스트보기
				System.out.println("<1.리스트>");
				List<PersonVo> personList = phoneDao.phoneSelect();
				for(int i = 0; i<personList.size(); i++  ) {
					PersonVo personvo = personList.get(i);
					System.out.println(personvo.getPersonId()+".   "+personvo.getName()+"\t"+personvo.getHp()+"\t"+personvo.getCompany());
				}
			}else if (mNum == 2) {
				//등록
				System.out.println("<2.등록>");
				System.out.print("이름 >");
				name = sc.next();
				System.out.print("휴대전화 >");
				hp = sc.next();
				System.out.print("회사번호 >");
				company = sc.next();
				
				//등록한 데이터 DB에 넣어주기
				phoneDao.phoneInsert(name, hp, company);
				System.out.println("[1건 등록되었습니다]");	
			}else if (mNum == 3) {
				//수정
				System.out.println("<3.수정>");
				System.out.println("번호 >");
				int num = sc.nextInt();
				System.out.print("이름 >");
				name = sc.next();
				System.out.print("휴대전화 >");
				hp = sc.next();
				System.out.print("회사번호 >");
				company = sc.next();
				
				//수정한 데이터 DB에 넣어주기
				phoneDao.phoneUpdate(name, hp, company, num);
				System.out.println("[1건 수정되었습니다.]");
			}else if (mNum == 4) {
				//삭제
				System.out.println("<4.삭제>");
				System.out.print(">번호 :");
				int num = sc.nextInt();
				
				//삭제한 데이터 DB에 넣어주기
				phoneDao.phoneDelete(num);
				System.out.println("[1건 삭제되었습니다.]");
			}else if (mNum == 5) {
				//검색
				System.out.println("<5. 검색>");
				System.out.print("검색어 : ");
				String search = sc.next();
				//리스트와 똑같음
				List<PersonVo> personList = phoneDao.phoneSelect();
				for(int i = 0; i<personList.size(); i++  ) {
					PersonVo personvo = personList.get(i); //contais로 검색해주기
					if(personvo.getName().contains(search) || personvo.getHp().contains(search) || personvo.getCompany().contains(search)) {
						System.out.println(personvo.getPersonId()+".   "+personvo.getName()+"\t"+personvo.getHp()+"\t"+personvo.getCompany());
					}
				}
			}else if (mNum == 6) {
				System.out.println("******************************************");
				System.out.println("*               감사합니다               *");
				System.out.println("******************************************");
				break;
			}else {
				System.out.println("[다시 입력해주세요.]");
			}
			
			
		}
		sc.close();
	}

}

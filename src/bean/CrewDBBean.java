package bean;

import java.util.ArrayList;

/*
 * 원래 DB Connection을 열어 sql문을 실행해야 하는 클래스이지만
 * DB Connect 부분 없이 dummy data로 구현함. 
 */
public class CrewDBBean {
	//Singleton
	private static CrewDBBean instance = new CrewDBBean();
	private CrewDBBean() {}
	public static CrewDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<CrewBean> getCrews(){
		ArrayList<CrewBean> list = new ArrayList<>();
		
		CrewBean a = new CrewBean("Alice");
		CrewBean b = new CrewBean("Ben");
		
		list.add(a);
		list.add(b);
		
		return list;
	}
}

package bean;

import java.util.ArrayList;

/*
 * 원래 DB Connection을 열어 sql문을 실행해야 하는 클래스이지만
 * DB Connect 부분 없이 dummy data로 구현함. 
 */
public class MenuDBBean {
	//Singleton
	private static MenuDBBean instance = new MenuDBBean();
	private MenuDBBean() {}
	public static MenuDBBean getInstance() {
		return instance;
	}
	
	
	public ArrayList<MenuBean> getMenus(){
		ArrayList<MenuBean> menus = new ArrayList<>();
		
		MenuBean m1 = new MenuBean("1", "Espresso", "Espresso", 3000);
		MenuBean m2 = new MenuBean("2", "Caffe Latte", "Espresso, Steamed Milk", 4000);
		MenuBean m3 = new MenuBean("3", "Caffe Mocha", "Espresso, Steamed Milk, Chocolate", 5000);
		
		menus.add(m1);
		menus.add(m2);
		menus.add(m3);
		
		return menus;
	}
}

package bean;

import java.util.ArrayList;

public class EventDBBean {
	private static EventDBBean instance = new EventDBBean();
	private EventDBBean() { }
	public static EventDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<EventBean> getEvents(){
		ArrayList<EventBean>list = new ArrayList<>();
		
		EventBean e1 = new EventBean("Handmade Cup Order", "You can order cups", "event.png");
		EventBean e2 = new EventBean("20%off Hand-drip conffee", "2019.11.1~2019.11.30", "drip.jpg");
		EventBean e3 = new EventBean("Order 5, get 1 free", "2019.11.10~2019.11.20", "espresso.jpg");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		return list;
	}
}

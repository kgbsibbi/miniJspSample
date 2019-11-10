package sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MenuDBBean;

public class MenuAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MenuDBBean db = MenuDBBean.getInstance();
		request.setAttribute("menus", db.getMenus());
		return "menu.jsp";
	}

}

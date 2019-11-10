package sample.action.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EventDBBean;
import sample.action.Action;

public class EventTemplateAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		EventDBBean db = EventDBBean.getInstance();
		
		request.setAttribute("list", db.getEvents());
		return "eventDetail.jsp";
	}

}

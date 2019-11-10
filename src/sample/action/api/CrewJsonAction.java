package sample.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import bean.CrewBean;
import bean.CrewDBBean;
import sample.action.Action;

public class CrewJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CrewDBBean db = CrewDBBean.getInstance();
		ArrayList<CrewBean> list = db.getCrews();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}

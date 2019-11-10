package sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String requestProcess(HttpServletRequest request,
			HttpServletResponse response) throws Throwable;

}

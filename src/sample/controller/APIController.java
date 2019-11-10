package sample.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;

/**
 * Servlet implementation class APIController
 */
@WebServlet(
		urlPatterns = { 
				"/APIController", 
				"*.api"
		}, 
		initParams = { 
				@WebInitParam(name = "propertyConfig", value = "apiMapping.properties")
		})
public class APIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//initParams에서 propertyConfig의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property"; //properties파일이 저장된 폴더
		//웹어플리케이션 루트 경로
		ServletContext context = config.getServletContext();
		//realFolder를 웹어플리케이션 시스템상의 절대경로로 변경
		String realPath = context.getRealPath(realFolder) +File.separator+props;
							    
		//명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		try{
			//command.properties파일의 내용을 읽어옴
			f = new FileInputStream(realPath); 
			//command.properties의 내용을 Properties객체 pr에 저장
			pr.load(f);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (f != null) try { f.close(); } catch(IOException ex) {}
		}
		//Set객체의 iterator()메소드를 사용해 Iterator객체를 얻어냄
		Iterator<?> keyIter = pr.keySet().iterator();
		//Iterator객체에 저장된 명령어와 처리클래스를 commandMap에 저장
		while( keyIter.hasNext() ) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			try{
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
				commandMap.put(command, commandInstance);
			}catch (ClassNotFoundException|NoSuchMethodException|InvocationTargetException e) {
				e.printStackTrace();
			}catch (InstantiationException|IllegalAccessException e) {
				e.printStackTrace();
			}
		}	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	
	private void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String result = null;
		Action action=null;
		
		response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
		
		try {
			String command = request.getRequestURI();
	        if(command.indexOf(request.getContextPath()) == 0) 
	           command = command.substring(request.getContextPath().length());
	        action = (Action)commandMap.get(command);  
	        if(action == null)
	        	result = "";
	        else
	        	result = action.requestProcess(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}

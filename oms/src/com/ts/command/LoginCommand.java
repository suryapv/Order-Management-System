package com.ts.command;

import java.io.IOException;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ts.beans.UserBean;
import com.ts.dao.UserDAO;

public class LoginCommand implements Command{
	
	// Check log4j.properties in WEB-INF folder
		static Logger log = Logger.getLogger("com.a");
	
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			UserBean userBean = new UserBean();
			mapToUserBean (request, userBean);
			
			if ("success".equalsIgnoreCase(this.checkUser(userBean))){     
	        	
		         if(userBean.getRole() == 1)
		         {
		        	 HttpSession session = request.getSession();
			        	session.setAttribute("userBean", userBean);
			        	ServletContext context = request.getSession().getServletContext();
			            context.getRequestDispatcher("/admin.jsp").forward(request, response);
		         }
		         else if(userBean.getRole() == 2)
		         {
		        	 HttpSession session = request.getSession();
			        	session.setAttribute("userBean", userBean);
			        	ServletContext context = request.getSession().getServletContext();
			            context.getRequestDispatcher("/pack.jsp").forward(request, response);
		         }
		         
		         else if(userBean.getRole() == 3)
		         {
		        	 HttpSession session = request.getSession();
			        	session.setAttribute("userBean", userBean);
			        	ServletContext context = request.getSession().getServletContext();
			            context.getRequestDispatcher("/ship.jsp").forward(request, response);
		         }
		         else 
		         {
		        	 HttpSession session = request.getSession();
			        	session.setAttribute("userBean", userBean);
			        	ServletContext context = request.getSession().getServletContext();
			            context.getRequestDispatcher("/customer.jsp").forward(request, response);
		         }		        
		        	 
	        	            
	        }
			else 
	        {
	        	 ServletContext context = request.getSession().getServletContext();
	             context.getRequestDispatcher("/home.jsp").forward(request, response);	
	        }
	}
	private void mapToUserBean(HttpServletRequest request, UserBean userBean) {		
		userBean.setUsername(request.getParameter ("email"));
        userBean.setPassword( request.getParameter("password"));
	}
	private String checkUser(UserBean userBean){
    	
    	try{
    	UserDAO dao = new UserDAO(); 
       	return dao.checkUser(userBean);
    	}catch(Exception ex){
    		log.error("Login Error" );
    		return "FAILURE";
    		
    	}
    }

}

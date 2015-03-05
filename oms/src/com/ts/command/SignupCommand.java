package com.ts.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

import com.ts.dao.SignupDAO;
import com.ts.dao.UserDAO;
import com.ts.exception.ProjectApplicationException;
import com.ts.beans.UserBean;


public class SignupCommand implements Command{
static Logger log = Logger.getLogger("com.a");
	
	/**
	 * Completes the request to insert, update, delete or view all user
	 * as per the 'action' defined in the request parameter
	 */
	 public void execute(HttpServletRequest request,
                        HttpServletResponse response)
                    throws ServletException, IOException{
		 if("insert".equalsIgnoreCase(request.getParameter ("action"))){	      

			  this.addUser(request,response);
		  }
		 
	 }
		 
		 private void addUser(HttpServletRequest request,
	              HttpServletResponse response)
	          throws ServletException, IOException{
	      	
	    	  UserBean userBean = new UserBean();
	    	  mapToSignBean(request, userBean);
	    	  
	    	  String result = null;
	    	  try{
	    	  		result = new SignupDAO().createUser(userBean); 
		      	}catch(ProjectApplicationException ex){
		  			log.error(" Error in inserting Data about users" );    		
		  		}
	    	   if ("success".equalsIgnoreCase(result)){
	    		       
	    		    HttpSession session = request.getSession();
	           		session.setAttribute("SignupBean", userBean);
	    			ServletContext context = request.getSession().getServletContext();
	               context.getRequestDispatcher("/welcomeUser.jsp").forward(request, response);
	    	     }
	    	 
	    	   else{
	    	     	 ServletContext context = request.getSession().getServletContext();
	    	          context.getRequestDispatcher("/home.jsp").forward(request, response);	
	    	     }
	    	}
			private void mapToSignBean(HttpServletRequest request, UserBean userBean){
				userBean.setUsername(request.getParameter ("emailid"));
				userBean.setPassword( request.getParameter("password"));
				
		  	}
		 
	 }


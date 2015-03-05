package com.ts.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ts.beans.DepartmentBean;
import com.ts.beans.UserBean;
import com.ts.dao.DepartmentDAO;
import com.ts.dao.UserDAO;

public class UserCommand implements Command{
	
	// Check log4j.properties in WEB-INF folder
		static Logger log = Logger.getLogger("com.a");
		
		/**
		 * Completes the request to insert, update, delete or view all user
		 * as per the 'action' defined in the request parameter
		 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if("insert".equalsIgnoreCase(request.getParameter ("action"))){	      

			  this.addUser(request,response);
		  }
		if("update".equalsIgnoreCase(request.getParameter ("action"))){
		  	
			  this.updateUser(request,response);
		}
		if("viewAll".equalsIgnoreCase(request.getParameter ("action"))){
		  	
			  this.viewUsers(request,response);
		}
		
	}
	
	/**
     * Inserts a new User in the database.
     * User information is sent in request parameter from jsp file.  
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	 private void addUser(HttpServletRequest request,
             HttpServletResponse response)
         throws ServletException, IOException{
     	
		 UserBean userBean = new UserBean();
   	mapToSignupBean(request, userBean);
   	  
   	  String result = null;
   	  try{
   	  		result = new UserDAO().createUser(userBean); 
	      	}
   	  catch(Exception ex){
	  			log.error(" Error in inserting Data about users" );    		
	  		}
   	   if ("success".equalsIgnoreCase(result)){
   		       
   		    HttpSession session = request.getSession();
          		session.setAttribute("userBean", userBean);
   			ServletContext context = request.getSession().getServletContext();
              context.getRequestDispatcher("/customer.jsp").forward(request, response);
   	     }
   	 
   	   else{
   	     	 ServletContext context = request.getSession().getServletContext();
   	          context.getRequestDispatcher("/login1.jsp").forward(request, response);	
   	     }
   	}
	 
	 /**
		 * Updates the user information
		 * User information is sent in request parameter from jsp file. 
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
	 private void updateUser(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
	  	
		  UserBean userBean = new UserBean();
		  mapToUserBean(request, userBean);
		  String result = null;
		  
		   try{
			  result = new UserDAO().updateUser(userBean); 
		   }catch(Exception ex){
		  		log.error(" Error in Updating user data" );    		
		  	}

		   if ("success".equalsIgnoreCase(result)){
			        
	       		HttpSession session = request.getSession();
	       		session.setAttribute("userBean", userBean);
			   ServletContext context = request.getSession().getServletContext();
	           context.getRequestDispatcher("/profile.jsp").forward(request, response);
		     }
		 
		   else
		     {
			   	  ServletContext context = request.getSession().getServletContext();
		          context.getRequestDispatcher("/customer.jsp").forward(request, response);	
		     }
	}
	 private void viewUsers(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
		  
	  		
	    	Collection<UserBean>  userBeans = new ArrayList<UserBean>();
	    	try{
	    		userBeans = new UserDAO().selectUsers();       
	    		
	    	}catch(Exception ex){
	    		log.error(" Error in Fethcing Data about departments" );    		
	    	}
	 
	        if (!userBeans.isEmpty()){
	               	request.setAttribute("userBeans", userBeans);
	                ServletContext context = request.getSession().getServletContext();
	                context.getRequestDispatcher("/viewAllUsers.jsp").forward(request, response);
	        }
	        else{
	        	  ServletContext context = request.getSession().getServletContext();
	              context.getRequestDispatcher("/admin.jsp").forward(request, response);
	        }
	  	}
 	
	 
	 /**
      * Reads the request object and creates the user bean object
      * 
      */
	 private void mapToSignupBean(HttpServletRequest request, UserBean userBean){
			userBean.setUsername(request.getParameter ("email"));
			userBean.setPassword( request.getParameter("password"));
	 }
	 private void mapToUserBean(HttpServletRequest request, UserBean userBean){
		 	
		 	userBean.setCustomername(request.getParameter ("customername"));
	  		userBean.setUsername(request.getParameter ("username"));
	        userBean.setPassword( request.getParameter("password"));
			userBean.setAge(Integer.parseInt(request.getParameter("age")));
			userBean.setPhoneno(request.getParameter("phoneno"));
	        userBean.setAddress(request.getParameter ("address"));
	  	}
	}

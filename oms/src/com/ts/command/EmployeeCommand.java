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




import com.ts.beans.EmployeeBean;
import com.ts.dao.EmployeeDAO;

public class EmployeeCommand implements Command{
	
	// Check log4j.properties in WEB-INF folder
	static Logger log = Logger.getLogger("com.a");
			
	/**
	* Completes the request to insert, update, delete or view all user
	* as per the 'action' defined in the request parameter
	*/
			
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if("insert".equalsIgnoreCase(request.getParameter ("action"))){	      

			  this.addEmployee(request,response);
		  }
		else if("viewAll".equalsIgnoreCase(request.getParameter ("action"))){
			this.viewAllEmployees(request,response);
		}
		else if("update".equalsIgnoreCase(request.getParameter ("action"))){
			this.updateEmployee(request,response);
		}
		else if("delete".equalsIgnoreCase(request.getParameter ("action"))){
			this.deleteEmployee(request,response);
		}
		
	}
	
	private void addEmployee(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
    	
  	  EmployeeBean empBean = new EmployeeBean();
  	  mapToEmployeeBean(request, empBean);
  	  
  	  
  	  String result = null;
  	  try{
  	  		result = new EmployeeDAO().createEmployee(empBean); 
	      	}catch(Exception ex){
	      		log.error(" Error in inserting Data about employee" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		       
  		    HttpSession session = request.getSession();
         		session.setAttribute("empBeans", empBean);
  			ServletContext context = request.getSession().getServletContext();
  			viewAllEmployees(request,response);
             context.getRequestDispatcher("/viewAllEmployees.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
  	     }
	}
	
	private void viewAllEmployees(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
		  
	    	Collection<EmployeeBean>  empBeans = new ArrayList<EmployeeBean>();
	    	try{
	    		empBeans = new EmployeeDAO().selectEmployees();       
	    		
	    	}catch(Exception ex){
	    		log.error(" Error in Fethcing Data about employees" );    		
	    	}
	 
	        if (!empBeans.isEmpty()){
	               	request.setAttribute("empBeans", empBeans);
	                ServletContext context = request.getSession().getServletContext();
	                context.getRequestDispatcher("/viewAllEmployees.jsp").forward(request, response);
	        }
	        else{
	        	  ServletContext context = request.getSession().getServletContext();
	              context.getRequestDispatcher("/admin.jsp").forward(request, response);
	        }
	  	}
	
	private void updateEmployee(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
	  	
		EmployeeBean empBean = new EmployeeBean();
	  	  mapToEmployeeBean(request, empBean);
		  String result = null;
		  
		   try{
			  result = new EmployeeDAO().updateEmployee(empBean); 
		   }catch(Exception ex){
			   log.error(" Error in Updating user data" );    		
		  	}

		   if ("success".equalsIgnoreCase(result)){
			        
	       		HttpSession session = request.getSession();
	       		session.setAttribute("empBeans", empBean);
			   ServletContext context = request.getSession().getServletContext();
			   viewAllEmployees(request,response);
	           context.getRequestDispatcher("/viewAllEmployees.jsp").include(request, response);
		     }
		 
		   else
		     {
			   	  ServletContext context = request.getSession().getServletContext();
		          context.getRequestDispatcher("/admin.jsp").forward(request, response);	
		     }
	}
	
	private void deleteEmployee(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
    	
  	  String empname = request.getParameter("empname");
  	  String result = null;
  	  try{
  	  		result = new EmployeeDAO().deleteEmployee(empname); 
	      	}catch(Exception ex){
	      		log.error(" Error in deleting Data about employees" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		       
  		   ServletContext context = request.getSession().getServletContext();
  		   viewAllEmployees(request,response);
           context.getRequestDispatcher("/viewAllEmployees.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
  	     }
	}
	
	private void mapToEmployeeBean(HttpServletRequest request, EmployeeBean empBean){
		empBean.setEmpname(request.getParameter ("empname"));
 		empBean.setEmailid(request.getParameter ("emailid"));
 		empBean.setAddress(request.getParameter ("address"));
 		empBean.setDeptno(Integer.parseInt(request.getParameter ("deptno")));
     }

}

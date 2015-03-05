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
import com.ts.dao.DepartmentDAO;




public class DepartmentCommand implements Command{
	
	// Check log4j.properties in WEB-INF folder
	static Logger log = Logger.getLogger("com.a");
			
	/**
	* Completes the request to insert, update, delete or view all user
	* as per the 'action' defined in the request parameter
	*/
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if("insert".equalsIgnoreCase(request.getParameter ("action"))){	      

			  this.addDepartment(request,response);
		  }
		else if("viewAll".equalsIgnoreCase(request.getParameter ("action"))){
			this.viewAllDepartments(request,response);
		}
		else if("update".equalsIgnoreCase(request.getParameter ("action"))){
			this.updateDepartment(request,response);
		}
		else if("delete".equalsIgnoreCase(request.getParameter ("action"))){
			this.deleteDepartment(request,response);
		}
		
	}
	
	private void addDepartment(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
		
  	  DepartmentBean deptBean = new DepartmentBean();
  	  mapToDepartmentBean(request, deptBean);
  	  
  	  
  	  String result = null;
  	  try{
  		    System.out.println("inside dao"); 
  	  		result = new DepartmentDAO().createDepartment(deptBean); 
	      	}catch(Exception ex){
	  			log.error(" Error in inserting Data about users" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		       
  		    HttpSession session = request.getSession();
         		session.setAttribute("deptBean", deptBean);
  			ServletContext context = request.getSession().getServletContext();
  			viewAllDepartments(request,response);
  			context.getRequestDispatcher("/viewAllDepartments.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
  	     }
	}
	
	private void viewAllDepartments(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
		  
	  		
	    	Collection<DepartmentBean>  deptBeans = new ArrayList<DepartmentBean>();
	    	try{
	    		deptBeans = new DepartmentDAO().selectDepartments();       
	    		
	    	}catch(Exception ex){
	    		log.error(" Error in Fethcing Data about departments" );    		
	    	}
	 
	        if (!deptBeans.isEmpty()){
	               	request.setAttribute("deptBeans", deptBeans);
	                ServletContext context = request.getSession().getServletContext();
	                context.getRequestDispatcher("/viewAllDepartments.jsp").forward(request, response);
	        }
	        else{
	        	  ServletContext context = request.getSession().getServletContext();
	              context.getRequestDispatcher("/admin.jsp").forward(request, response);
	        }
	  	}
  	 
  	 
  	private void updateDepartment(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
	  	
  		DepartmentBean deptBean = new DepartmentBean();
    	mapToDepartmentBean(request, deptBean);
		  String result = null;
		  
		   try{
			  result = new DepartmentDAO().updateDepartment(deptBean); 
		   }catch(Exception ex){
			   log.error(" Error in Updating department data" );    		
		  	}

		   if ("success".equalsIgnoreCase(result)){
			        
	       		HttpSession session = request.getSession();
	       		session.setAttribute("deptBean", deptBean);
			    ServletContext context = request.getSession().getServletContext();
			    viewAllDepartments(request,response);
	            context.getRequestDispatcher("/viewAllDepartments.jsp").include(request, response);
		     }
		 
		   else
		     {
			   	  ServletContext context = request.getSession().getServletContext();
		          context.getRequestDispatcher("/admin.jsp").forward(request, response);	
		     }
	}
  	
  	private void deleteDepartment(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
    	
  	  String deptno = request.getParameter("deptno");
  	  String result = null;
  	  try{
  	  		result = new DepartmentDAO().deleteDepartment(deptno); 
	      	}catch(Exception ex){
	      		log.error(" Error in inserting Data about users" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		       
  		   ServletContext context = request.getSession().getServletContext();
  		   viewAllDepartments(request,response);
           context.getRequestDispatcher("/viewAllDepartments.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
  	     }
	}
  	
  	private void mapToDepartmentBean(HttpServletRequest request, DepartmentBean deptBean){
  		deptBean.setDeptno(Integer.parseInt(request.getParameter ("deptno")));
 		deptBean.setDeptname(request.getParameter ("deptname"));
 		deptBean.setTotalmembers(Integer.parseInt(request.getParameter ("totalmembers")));
 		System.out.println("hello");
 		System.out.println(deptBean.getDeptno());
     }
}

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
import com.ts.beans.OrderBean;
import com.ts.dao.DepartmentDAO;
import com.ts.dao.OrderDAO;

public class PackingCommand implements Command{

	static Logger log = Logger.getLogger("com.a");
	
	/**
	 * Completes the request to insert, update, delete or view all user
	 * as per the 'action' defined in the request parameter
	 */
     public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	if("viewall".equalsIgnoreCase(request.getParameter ("action"))){	      

		  this.viewAll(request,response);
	   }
     
}
     private void viewAll(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
		  
	  		
	    	Collection<OrderBean>  orderBeans = new ArrayList<OrderBean>();
	    	try{
	    		orderBeans = new OrderDAO().selectOrder1();       
	    		
	    	}catch(Exception ex){
	    		log.error(" Error in Fethcing Data about departments" );    		
	    	}
	 
	        if (!orderBeans.isEmpty()){
	               	request.setAttribute("orderBeans", orderBeans);
	                ServletContext context = request.getSession().getServletContext();
	                context.getRequestDispatcher("/packing.jsp").forward(request, response);
	        }
	        else{
	        	  ServletContext context = request.getSession().getServletContext();
	              context.getRequestDispatcher("/pack.jsp").forward(request, response);
	        }
	  	}
 	
}
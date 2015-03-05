package com.ts.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.beans.DeliverBean;
import com.ts.beans.ShipBean;
import com.ts.dao.DeliverDAO;
import com.ts.dao.ShipDAO;

public class DeliverCommand implements Command {
	

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if ("viewall".equalsIgnoreCase(request.getParameter("action"))) {

			this.viewallDeliver(request, response);
		}
		else
		{

		
		DeliverBean Bean = new DeliverBean();
	  	  mapToDeliverBean(request, Bean);
	  	  
	  	  
	  	  String result = null;
	  	  try{
	  		   
	  	  		result = new DeliverDAO().insert(Bean); 
		      	}catch(Exception ex){
		  		//	log.error(" Error in inserting Data about users" );    		
		  		}
	  	   if ("success".equalsIgnoreCase(result)){
	  		       
	  		    HttpSession session = request.getSession();
	         		session.setAttribute("shipBean", Bean);
	  			ServletContext context = request.getSession().getServletContext();
	  			context.getRequestDispatcher("/deliveredSuccess.jsp").include(request, response);
	  	     }
	  	 
	  	   else{
	  	     	 ServletContext context = request.getSession().getServletContext();
	  	         context.getRequestDispatcher("/delivery.jsp").forward(request, response);	
	  	     }
	  	   
	  	  String result1 =  new ShipDAO().deleteShip(request.getParameter("orderid"));
		
		}
	}
		private void viewallDeliver(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Collection<DeliverBean>  deliverBeans = new ArrayList<DeliverBean>();
    	try{
    		deliverBeans = new DeliverDAO().selectDeliver();       
    		
    	}catch(Exception ex){
    	//	log.error(" Error in Fethcing Data about departments" );    		
    	}
 
        if (!deliverBeans.isEmpty()){
               	request.setAttribute("deliverBeans", deliverBeans);
                ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/viewDeliver.jsp").forward(request, response);
        }
        else{
        	  ServletContext context = request.getSession().getServletContext();
              context.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
 	}


	private void mapToDeliverBean(HttpServletRequest request, DeliverBean Bean) {
		Bean.setOrderid(request.getParameter("orderid"));
		Bean.setDeliverby(request.getParameter("deliverby"));
		Bean.setPhoneno(request.getParameter("phoneno"));
		Bean.setReceivedby(request.getParameter("customername"));
		
		
		
	}

}

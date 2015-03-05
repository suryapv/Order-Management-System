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

import com.ts.beans.OrderBean;
import com.ts.dao.OrderDAO;



public class OrderCommand implements Command{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	// Check log4j.properties in WEB-INF folder
			static Logger log = Logger.getLogger("com.a");
			
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if("insert".equalsIgnoreCase(request.getParameter ("action"))){	      

			  this.addOrder(request,response);
		  }
		else if ("update".equalsIgnoreCase(request.getParameter("action"))) {
			
			this.updateOrder(request, response);
		
		} 
		else if ("sendnotification".equalsIgnoreCase(request.getParameter("action"))) {
			
			this.notification(request, response);
		}
	}
	
	private void addOrder(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
    	
  	  OrderBean orderBean = new OrderBean();
  	  mapToOrderBean(request, orderBean);
  	  
  	  String result = null;
  	  try{
  	  		result = new OrderDAO().createOrder(orderBean); 
	      	}
  	  catch(Exception ex){
	  			log.error(" Error in inserting Data about ordered products" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		 
  		       
  		    HttpSession session = request.getSession();
         		session.setAttribute("orderBean", orderBean);
         		
  			ServletContext context = request.getSession().getServletContext();
             context.getRequestDispatcher("/paymentSuccessfull.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	          context.getRequestDispatcher("/error.jsp").forward(request, response);	
  	     }
  	}
	
	private void notification(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Collection<OrderBean> orderBean = new ArrayList<OrderBean>();
		try {
			orderBean = new OrderDAO().selectOrder();

		} catch (Exception ex) {
			System.err.println(" Error in Fethcing Data about users");
		}

		if (!orderBean.isEmpty()) {
			request.setAttribute("orderBean", orderBean);
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/packaging.jsp").forward(request,
					response);
		} else {
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/mainpack1.jsp").forward(request, response);
		}
	}

	private void updateOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		OrderBean orderBean = new OrderBean();
		mapToOrderBean(request, orderBean);
		String result = null;

		try {
			result = new OrderDAO().updateOrder(orderBean);
		} catch (Exception ex) {
			System.err.println(" Error in Updating user data");
		}

		if ("success".equalsIgnoreCase(result)) {

			HttpSession session = request.getSession();
			session.setAttribute("orderBean", orderBean);
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/packaging.jsp").forward(request,
					response);
		}

		else {
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/maintainance.jsp")
					.forward(request, response);
		}
	}
	
	private void mapToOrderBean(HttpServletRequest request, OrderBean orderBean){

  		orderBean.setProductname(request.getParameter ("productname"));
  		orderBean.setOrderdate(request.getParameter("orderdate"));
  		orderBean.setCustomername(request.getParameter ("customername"));
  		orderBean.setShippingdate(request.getParameter("shippingdate"));
  		orderBean.setPhoneno(request.getParameter("phoneno"));
	}
}

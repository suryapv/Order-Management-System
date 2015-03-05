package com.ts.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ts.beans.DepartmentBean;
import com.ts.beans.ShipBean;
import com.ts.dao.DepartmentDAO;
import com.ts.dao.ShipDAO;

public class ShipCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("viewall".equalsIgnoreCase(request.getParameter("action"))) {

			this.viewallShip(request, response);
		}
		if("insert".equalsIgnoreCase(request.getParameter("action"))){
				this.add(request,response);
			}
	if ("update".equalsIgnoreCase(request.getParameter("action"))) {
			this.updateShip(request, response);
		}
	 if ("notification".equalsIgnoreCase(request.getParameter("action"))) {
			this.notification(request, response);
		}

	}
	private void add(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException{
		
  	  ShipBean Bean = new ShipBean();
  	  mapToShipBean(request, Bean);
  	  
  	  
  	  String result = null;
  	  try{
  		    System.out.println("inside dao"); 
  	  		result = new ShipDAO().addShip(Bean); 
	      	}catch(Exception ex){
	  		//	log.error(" Error in inserting Data about users" );    		
	  		}
  	   if ("success".equalsIgnoreCase(result)){
  		       
  		    HttpSession session = request.getSession();
         		session.setAttribute("shipBean", Bean);
  			ServletContext context = request.getSession().getServletContext();
  			context.getRequestDispatcher("/success.jsp").include(request, response);
  	     }
  	 
  	   else{
  	     	 ServletContext context = request.getSession().getServletContext();
  	         context.getRequestDispatcher("/pack.jsp").forward(request, response);	
  	     }
	}
	
	
	
	private void viewallShip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Collection<ShipBean>  shipBeans = new ArrayList<ShipBean>();
    	try{
    		shipBeans = new ShipDAO().selectShip();       
    		
    	}catch(Exception ex){
    	//	log.error(" Error in Fethcing Data about departments" );    		
    	}
 
        if (!shipBeans.isEmpty()){
               	request.setAttribute("shipBeans", shipBeans);
                ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/ship1.jsp").forward(request, response);
        }
        else{
        	  ServletContext context = request.getSession().getServletContext();
              context.getRequestDispatcher("/ship.jsp").forward(request, response);
        }
 	}
	private void notification(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Collection<ShipBean> shipBeans = new ArrayList<ShipBean>();
		try {
			shipBeans = new ShipDAO().selectShip();

		} catch (Exception ex) {
			System.err.println(" Error in Fethcing Data about users");
		}

		if (!shipBeans.isEmpty()) {
			request.setAttribute("shipBeans", shipBeans);
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/ship.jsp").forward(request,
					response);
		} else {
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/home.jsp")
					.forward(request, response);
		}
	}


	private void updateShip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ShipBean shipBean = new ShipBean();
		mapToShipBean(request, shipBean);
		String result = null;

		try {
			result = new ShipDAO().updateShip(shipBean);
		} catch (Exception ex) {
			System.err.println(" Error in Updating user data");
		}

		if ("success".equalsIgnoreCase(result)) {

			HttpSession session = request.getSession();
			session.setAttribute("shipBeans", shipBean);
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/shippingsucces.jsp").forward(request,
					response);
		}

		else {
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/admin.jsp").forward(request,
					response);
		}
	}

	private void mapToShipBean(HttpServletRequest request, ShipBean shipBean) {
		shipBean.setOrderid(Integer.parseInt(request.getParameter("orderid")));
		shipBean.setProductname(request.getParameter("productname"));
		shipBean.setShipmentno(Integer.parseInt(request.getParameter("shipmentno")));
		shipBean.setDateshipped(request.getParameter("dateshipped"));
		shipBean.setShippedby(request.getParameter("shippedby"));
		shipBean.setCustomername(request.getParameter("customername"));
		shipBean.setPhoneno(request.getParameter("phoneno"));
		
	}
	
}

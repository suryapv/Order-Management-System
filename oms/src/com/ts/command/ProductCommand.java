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


import com.ts.beans.ProductBean;
import com.ts.dao.ProductDAO;


public class ProductCommand implements Command{
	
	// Check log4j.properties in WEB-INF folder
			static Logger log = Logger.getLogger("com.a");
			
			/**
			 * Completes the request to insert, update, delete or view all user
			 * as per the 'action' defined in the request parameter
			 */
			
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if("insert".equalsIgnoreCase(request.getParameter ("action"))){
			this.addProduct(request,response);
		}
		else if("viewAll".equalsIgnoreCase(request.getParameter ("action"))){
			this.viewAllProduct(request,response);
		}
		else if("update".equalsIgnoreCase(request.getParameter ("action"))){
			this.updateProduct(request,response);
		}
		else if("delete".equalsIgnoreCase(request.getParameter ("action"))){
			this.deleteProduct(request,response);
		}
		else if("shopping".equalsIgnoreCase(request.getParameter ("action"))){
			this.shopProduct(request,response);
		}

	}
		
		private void addProduct(HttpServletRequest request,
	            HttpServletResponse response)
	        throws ServletException, IOException{
	    	
	  	  ProductBean productBean = new ProductBean();
	  	  mapToProductBean(request, productBean);
	  	  
	  	  
	  	  String result = null;
	  	  try{
	  	  		result = new ProductDAO().createProduct(productBean); 
		      	}catch(Exception ex){
		      		log.error(" Error in inserting Data about products" );    		
		  		}
	  	   if ("success".equalsIgnoreCase(result)){
	  		       
	  		    HttpSession session = request.getSession();
	         	session.setAttribute("productBean", productBean);
	         	viewAllProduct(request,response);
	  			ServletContext context = request.getSession().getServletContext();
	            context.getRequestDispatcher("/viewAllProducts.jsp").include(request, response);
	  	     }
	  	 
	  	   else{
	  	     	 ServletContext context = request.getSession().getServletContext();
	  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
	  	     }
	}
		
		
		private void viewAllProduct(HttpServletRequest request,
		          HttpServletResponse response)
		      throws ServletException, IOException{
			  
		  		
		    	Collection<ProductBean>  productBeans = new ArrayList<ProductBean>();
		    	try{
		    		productBeans = new ProductDAO().selectProducts();       
		    		
		    	}catch(Exception ex){
		    		log.error(" Error in Fethcing Data about products" );    		
		    	}
		 
		        if (!productBeans.isEmpty()){
		               	request.setAttribute("productBeans", productBeans);
		                ServletContext context = request.getSession().getServletContext();
		                context.getRequestDispatcher("/viewAllProducts.jsp").forward(request, response);
		        }
		        else{
		        	  ServletContext context = request.getSession().getServletContext();
		              context.getRequestDispatcher("/admin.jsp").forward(request, response);
		        }
		  	}
		
		private void updateProduct(HttpServletRequest request,
		          HttpServletResponse response)
		      throws ServletException, IOException{
		  	
			ProductBean productBean = new ProductBean();
		  	  mapToProductBean(request, productBean);
			  String result = null;
			  
			   try{
				  result = new ProductDAO().updateProduct(productBean); 
			   }catch(Exception ex){
				   log.error(" Error in Updating user data" );    		
			  	}

			   if ("success".equalsIgnoreCase(result)){
				        
		       		HttpSession session = request.getSession();
		       		session.setAttribute("productBean", productBean);
				   ServletContext context = request.getSession().getServletContext();
				   viewAllProduct(request,response);
		           context.getRequestDispatcher("/viewAllProducts.jsp").include(request, response);
			     }
			 
			   else
			     {
				   	  ServletContext context = request.getSession().getServletContext();
			          context.getRequestDispatcher("/admin.jsp").forward(request, response);	
			     }
		}
	

	private void deleteProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String productname = request.getParameter("productname");
	  	  String result = null;
	  	  try{
	  	  		result = new ProductDAO().deleteProduct(productname); 
		      	}catch(Exception ex){
		      		log.error(" Error in inserting Data about product" );    		
		  		}
	  	   if ("success".equalsIgnoreCase(result)){
	  		   ServletContext context = request.getSession().getServletContext();
	  		   viewAllProduct(request,response);
	  		   context.getRequestDispatcher("/viewAllProducts.jsp").include(request, response);
	  	     }
	  	 
	  	   else{
	  	     	 ServletContext context = request.getSession().getServletContext();
	  	         context.getRequestDispatcher("/admin.jsp").forward(request, response);	
	  	     }
		
	}
	
	private void shopProduct(HttpServletRequest request,
	          HttpServletResponse response)
	      throws ServletException, IOException{
		  
	  		
	    	Collection<ProductBean>  productBeans = new ArrayList<ProductBean>();
	    	try{
	    		productBeans = new ProductDAO().shopProducts();       
	    		
	    	}catch(Exception ex){
	    		log.error(" Error in Fethcing Data about products" );    		
	    	}
	 
	        if (!productBeans.isEmpty()){
	               	request.setAttribute("productBeans", productBeans);
	                ServletContext context = request.getSession().getServletContext();
	                context.getRequestDispatcher("/startShopping.jsp").forward(request, response);
	        }
	        else{
	        	  ServletContext context = request.getSession().getServletContext();
	              context.getRequestDispatcher("/welcomeUser.jsp").forward(request, response);
	        }
	  	}
	
	private void mapToProductBean(HttpServletRequest request, ProductBean productBean){
   		productBean.setProductname(request.getParameter ("productname"));
 		productBean.setUnitprice(Integer.parseInt(request.getParameter ("unitprice")));
 		productBean.setInstock(request.getParameter ("instock"));
 		productBean.setShippingprice(Integer.parseInt(request.getParameter ("shippingprice")));
 		productBean.setQuantity(Integer.parseInt(request.getParameter ("quantity")));
 		productBean.setProductimage(request.getParameter ("productimage"));
 		
     }

	}
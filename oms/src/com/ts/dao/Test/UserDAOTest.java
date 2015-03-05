package com.ts.dao.Test;



import com.ts.dao.ProductDAO;
import com.ts.dao.UserDAO;
import com.ts.beans.ProductBean;
import com.ts.beans.UserBean;
import com.ts.exception.*;

import junit.framework.TestCase;


/**
 * Test case class for UserDAO
 * 
 *
 */
public class UserDAOTest extends  TestCase{

	 
	 ProductBean productBean = new ProductBean();
	 ProductDAO productDao = new ProductDAO();
	 
	   public UserDAOTest() {
		   super();
	   }
	 
	   /*
	    * Example for successful test case for login
	    */
       public void testCreateUser() {
    	   UserDAO userDao = new UserDAO();
    		  		 
    		 UserBean userBean = new UserBean();
    	   String username = "admin@gmail.com";
    	   String pwd = "admin123";
    	      	    	   
    	   userBean.setUsername(username);
           userBean.setPassword(pwd);           
           try{
        	   assertEquals("success",userDao.checkUser(userBean));
           }catch(OrderManagementException ex){}
         
	  }
       
       
       /*
	    * Example for successful test case for deleting a product
	    */
       public void testDeleteProduct() {
    	   
    	   String productname = "penset1";
    	  
    	  productBean.setProductname(productname);
                      
           try{
        	   assertEquals("success",productDao.deleteProduct(productname));
           }catch(Exception ex){}
         
	  }
       

       
   }

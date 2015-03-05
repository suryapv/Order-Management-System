package com.ts.ServletController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.command.Command;
import com.ts.command.DeliverCommand;
import com.ts.command.DepartmentCommand;
import com.ts.command.EmployeeCommand;
import com.ts.command.InitCommand;
import com.ts.command.LoginCommand;
import com.ts.command.OrderCommand;
import com.ts.command.PDFCommand;
import com.ts.command.PackingCommand;
import com.ts.command.ProductCommand;
import com.ts.command.ShipCommand;
import com.ts.command.TrackCommand;
import com.ts.command.UserCommand;

/**
 * Servlet Controller class
 * @author vspavan
 *
 */
public class Controller extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")	
	private Map commands = new HashMap();

	    @SuppressWarnings("unchecked")
		@Override
	    public void init(ServletConfig config) throws ServletException{
	        super.init();	    
	        this.commands.put("login", new LoginCommand());
	        this.commands.put("init",  new InitCommand());
	        this.commands.put("user", new UserCommand());
	        this.commands.put("pack", new PackingCommand());
	        this.commands.put("pdfCreate", new PDFCommand());
	        this.commands.put("employee", new EmployeeCommand());
	        this.commands.put("department", new DepartmentCommand());
	        this.commands.put("product", new ProductCommand());
	        this.commands.put("order",new OrderCommand());
	        this.commands.put("ship",new ShipCommand());
	        this.commands.put("track",  new TrackCommand());
	        this.commands.put("delivery",  new DeliverCommand());
	       
	        
	   }

	   
	    /** 
	     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	     */
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	      processCommand(request, response);

	    } 

	      /** 
	     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	     */
	    public void processCommand(HttpServletRequest  request,
	                               HttpServletResponse response)
	                           throws ServletException, IOException{
	    	
	    	// formAction is set null from fileUpload.jsp for upload
	    	System.out.println(request.getParameter("form_action"));
	        String formAction = request.getParameter("form_action");
	        if(null == formAction){
	            formAction = "upload";
	        }
	        
	        // Retrieve the command object with the key as formAction
	        Command command = (Command)commands.get(formAction);

	        if(null == command){
	            throw new IllegalArgumentException(
	                "No command for form action: " + formAction);
	        }
	        
	        // Calling the command class execute method
	        command.execute(request, response);
	    }
	    
	    
	  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	    /** 
	     * Handles the HTTP <code>GET</code> method.
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        processRequest(request, response);
	    } 

	    /** 
	     * Handles the HTTP <code>POST</code> method.
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /** 
	     * Returns a short description of the servlet.
	     * @return a String containing servlet description
	     */
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>
}


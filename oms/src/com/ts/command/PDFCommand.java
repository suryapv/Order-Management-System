package com.ts.command;

import javax.servlet.*;
import javax.servlet.http.*;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.io.*;


/**
 * Generate a pdf document
 * @author Ashish
 *
 */
public class PDFCommand implements Command{

				
		public void execute (HttpServletRequest request, 
				HttpServletResponse response) 
				throws ServletException, IOException{
			
	
			try {
	            // Get the text that will be added to the PDF
	            String text = null;
	            String username = "User Name ="+request.getParameter("username");
	            String productname="Product Name"+request.getParameter("product_name");
	            String name = "Name ="+request.getParameter("username");
	            String phoneno = "Phone Number ="+request.getParameter("phoneno");
	            String address = "Address ="+request.getParameter("address");
	            
	            if (text == null || text.trim().length() == 0) {
	                 text = "You didn't enter any text.";
	            }
	            // step 1
	            Document document = new Document();
	            // step 2
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            PdfWriter.getInstance(document, baos);
	            // step 3
	            document.open();
	            // step 4
	            document.add(new Paragraph(String.format(username,request.getMethod())));
	            document.add(new Paragraph(String.format(name,request.getMethod())));
	            document.add(new Paragraph(String.format(productname,request.getMethod())));
	            document.add(new Paragraph(String.format(phoneno,request.getMethod())));
	            document.add(new Paragraph(String.format(address,request.getMethod())));
	            document.add(new Paragraph(text));
	            // step 5
	            document.close();
	 
	            // setting some response headers
	            response.setHeader("Expires", "0");
	            response.setHeader("Cache-Control",
	                "must-revalidate, post-check=0, pre-check=0");
	            response.setHeader("Pragma", "public");
	            // setting the content type
	            response.setContentType("application/pdf");
	            // the content length
	            response.setContentLength(baos.size());
	            // write ByteArrayOutputStream to the ServletOutputStream
	            OutputStream os = response.getOutputStream();
	            baos.writeTo(os);
	            os.flush();
	            os.close();
	        }
	        catch(Exception e) {
	            throw new IOException(e.getMessage());
	        }
		}
		
	}

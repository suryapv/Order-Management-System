package com.ts.exception;

public class OrderManagementException extends Exception {

	 private static final long serialVersionUID = 2L;
		
		public OrderManagementException(String msg)
		{
			super(msg);
		}
		
		public OrderManagementException(Throwable t)
		{
			super(t);
		}

		public OrderManagementException(String msg, Throwable t)
		{
			super(msg, t);
			
		}
}

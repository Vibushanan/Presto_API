package com.slk.presto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Executor
 */
public class Executor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Executor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder stringBuilder = new StringBuilder();
	    try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
	        char[] charBuffer = new char[1024];
	        int bytesRead;
	        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	            stringBuilder.append(charBuffer, 0, bytesRead);
	        }
	    }
	    
	    
	    
	}

}

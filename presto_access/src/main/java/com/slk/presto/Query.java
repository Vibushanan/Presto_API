package com.slk.presto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.slk.presto.resources.Data_Grabber;
import com.slk.presto.resources.Query_Generator;

/**
 * Servlet implementation class Query
 */
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("in post");
		StringBuilder stringBuilder = new StringBuilder();
	    try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
	        char[] charBuffer = new char[1024];
	        int bytesRead;
	        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	            stringBuilder.append(charBuffer, 0, bytesRead);
	        }
	    }
	    
		
	    JSONObject jsonObj = new JSONObject(stringBuilder.toString());
	    
	    Query_Generator qs = new Query_Generator(jsonObj);
		System.out.println("Query :"+	qs.generateQuery(qs.parser()));
		PrintWriter out = response.getWriter();
		
		out.write(qs.generateQuery(qs.parser()));
		
	
	}

}

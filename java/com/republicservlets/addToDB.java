package com.republicservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.politician.CandidatesForum;
import com.politician.DAO;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CandidatesForum addTodb = new CandidatesForum();
		
		addTodb.setFirst_name(request.getParameter("First_Name"));
		addTodb.setLast_name(request.getParameter("Last_Name"));
		addTodb.setState(request.getParameter("State"));
		addTodb.setParty_affiliation(request.getParameter("Political_Party"));
		addTodb.setOccupation(request.getParameter("Occupation"));
		addTodb.setReligion(request.getParameter("Religion"));
		addTodb.setAlignment(request.getParameter("Alignment"));

		
		DAO.writeToDB(addTodb);
		
		request.getRequestDispatcher("index.html").forward(request, response);
		
	} //doPost

	
	
	
	
} //class

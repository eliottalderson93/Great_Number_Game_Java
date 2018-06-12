package com.greatNumber.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Servlet implementation class Guess
 */
@WebServlet("/Guess")
public class Guess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Home.jsp");
		HttpSession session = request.getSession();
		if(session.getAttribute("guess") == null) {
			int guess1 = ThreadLocalRandom.current().nextInt(0,101);
			//int guess = 42;
			session.setAttribute("guess",guess1);
			System.out.print("new number: ");
			System.out.println(guess1);
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String win = "";
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Home.jsp");
		HttpSession session = request.getSession();
		int user_guess = Integer.valueOf(request.getParameter("guess"));
		int guess = (int)session.getAttribute("guess");
		if (user_guess < guess) {
			win = "low";
			System.out.println("low");
		}
		else if(user_guess > guess) {
			win = "high";
			System.out.println("high");
		}
		else {
			win = "win";
			System.out.println("winning");
		}
		request.setAttribute("win", win);
		view.forward(request, response);
	}

}

package com.tcs.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaseStudyServlet
 */
//@WebServlet("/CaseStudyServlet")
public class CaseStudyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		STBObject stbo = new STBObject();
		PrintWriter out = response.getWriter();
		String boxtype = request.getParameter("topboxtype");
		String length = request.getParameter("length");
		String width = request.getParameter("width");
		String breadth = request.getParameter("breadth");
		stbo.setTopBoxType(boxtype);
		stbo.setLength(length);
		stbo.setWidth(width);
		stbo.setBreadth(breadth);
		stbo.setBillingType(request.getParameter("billingType"));
		stbo.setDiscount(Double.parseDouble(request.getParameter("discount")));
		stbo.setInstallationCharge(Integer.parseInt(request.getParameter("installationCharge")));
		stbo.setRefundableDeposit(request.getParameter("refundableDeposit"));
		request.setAttribute("stbo", stbo);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/stbpage/createsuccess.jsp");
		rd.forward(request, response);
//		out.println(boxtype + " " + length + " " + width + " " + breadth);
//		 response.sendRedirect("/CaseStudy/jsp/stbpage/createsuccess.jsp");
	}

}

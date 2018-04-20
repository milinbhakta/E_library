


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		out.println("<link rel='stylesheet' type='text/css' href='datatables.css'>");
		out.println("<script type=\"text/javascript\" charset=\"utf8\" src=\"datatables.js\"></script>");
		out.println(" <script>$(document).ready( function () {\r\n" + 
				"    $('#table_id').DataTable();\r\n" + 
				"} );</script>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<IssueBookBean> list=BookDao.viewIssuedBooks();
		System.out.println(list);
		
		out.println("<table id='table_id' class=' hover display'>");
		out.println("<thead><tr><th>BookNo</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr></thead><tbody>");
		for(IssueBookBean bean:list){
			
			
			if(bean.getReturnstatus().equals("yes") ) 
			{
			out.println("<tr style=\"background-color: #B9F6CA;\" ><td style=\"background-color: #B9F6CA;\" >"+bean.getbookno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
			}
			else if(bean.getReturnstatus().equals("no")) {
				out.println("<tr style=\"background-color: #FFFF8D;\" ><td style=\"background-color: #FFFF8D;\">"+bean.getbookno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
			}
			else {
				out.println("<tr ><td>"+bean.getbookno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
			}
		}
		out.println("</tbody></table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}

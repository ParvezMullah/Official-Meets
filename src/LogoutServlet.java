

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			PrintWriter out=response.getWriter();
			out.println("session is null");
		}
		//PrintWriter out=response.getWriter();
		//out.println(session.getAttribute("emailId"));
		//String user=(String) request.getAttribute("param");
		String redirectPage=null;
		try
		{
		//if(session.getAttribute("emailId").toString()!=null || !(session.getAttribute("emailId").toString().equals("")))
		//if(!(session.getAttribute("emailId").equals("")))
		//{
		//	session.invalidate();
			//RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			//dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		//	redirectPage="index.jsp";
			//PrintWriter out=response.getWriter();
			//out.println("Organiser log out");
			
		//}
		//else //if(!(session.getAttribute("userName").equals("")))
			if(session!=null)
		{
			session.invalidate();
			//response.sendRedirect("https://mail.google.com/mail/u/0/?logout&hl=ens");
			//redirectPage="https://mail.google.com/mail/u/0/?logout&hl=ens";
			//redirectPage="https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#";
			//URLConnection con = new URL(redirectPage).openConnection();
			//con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:10.0.2) Gecko/20100101 Firefox/10.0.2");
			//con.connect();
			//BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			//response.sendRedirect(redirectPage);
			redirectPage="index.jsp";
			//PrintWriter out=response.getWriter();
			//out.println("User log out");
		}
		}catch(NullPointerException ex)
		{
			session.invalidate();
			redirectPage="index.jsp";
			//PrintWriter out=response.getWriter();
			//out.println("Null pointer");
		}
		//RequestDispatcher dispatcher=request.getRequestDispatcher("https://mail.google.com/mail/u/0/?logout&hl=en");
		//dispatcher.include(request, response);
		response.sendRedirect(redirectPage);
	}

}

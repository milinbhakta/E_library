
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import javax.activation.*;
import javax.mail.*;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		

		

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String[] recipients = new String[]{email};  
        String[] bccRecipients = new String[]{email};  
        String subject = "Reset Password!"; 
        String messageBody = "<p>Your username is "+ email+ " <br><br> Password is "  + LibrarianDao.getauthenticate(email)+"</p>"; 
        System.out.println(LibrarianDao.getauthenticate(email));
        
        if(LibrarianDao.getauthenticateuser(email)) {
        	sendMail(recipients, bccRecipients, subject, messageBody); 
        	String title = "Forgot Password";
    		String res = "Sent details successfully....";
    		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

    		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
    				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
    				+ "<p align = \"center\">" + res + "</p>\n" + 
    				
    				"<a href=\"index.html\" > Continue</a>"+" </body></html>");
        }
        
        else
        {
        	String title = "Error 404";
    		String res = "Didn't find your email in database. Become a member by contacting eLibrary Manager.";
    		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

    		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
    				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
    				+ "<p align = \"center\">" + res + "</p>\n" + 
    				
    				"<a href=\"index.html\" > Continue</a>"+" </body></html>");
        }
      
         

		

		
		
		// Send message

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	
	private String FROM_ADDRESS = "elibrary938@gmail.com";
	private String PASSWORD = "Library123";
	private String FROM_NAME = "ELibrary";

	public boolean sendMail(String[] recipients, String[] bccRecipients, String subject, String message) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);
				}
			});

			// multipurpose internet mailing exception.
			Message msg = new MimeMessage(session);
			InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
			msg.setFrom(from);

			InternetAddress[] toAddresses = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				toAddresses[i] = new InternetAddress(recipients[i]);
			}

			msg.setRecipients(Message.RecipientType.TO, toAddresses);

			InternetAddress[] bccAddresses = new InternetAddress[bccRecipients.length];
			for (int j = 0; j < bccRecipients.length; j++) {
				bccAddresses[j] = new InternetAddress(bccRecipients[j]);
				System.out.println(bccAddresses[j]);
			}
			msg.setRecipients(Message.RecipientType.BCC, bccAddresses);

			msg.setSubject(subject);
			msg.setContent(message, "text/html");
			Transport.send(msg);
			return true;
		} catch (UnsupportedEncodingException ex) {
			
			return false;

		} catch (MessagingException ex) {
			
			return false;
		}
	}

	class SocialAuth extends Authenticator {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);

		}
	}
}
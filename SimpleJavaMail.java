import java.util.Scanner;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class SimpleJavaMail {

    final static String SYSTEM_EMAIL = "csci4050@gmail.com";
    final static String SYSTEM_NAME = "CSCI 4050";
    final static String PASSWORD = "some password";
    
    public static void main(String[] args) {
	String email, subject, body, name;
	Scanner keyboard = new Scanner(System.in);
	
	System.out.print("Enter email: ");
	email = keyboard.nextLine();
	    
	System.out.print("Enter name: ");
	name = keyboard.nextLine();
	
	System.out.print("Enter subject: ");
	subject = keyboard.nextLine();
	
	System.out.println("Enter body: ");
	body = keyboard.nextLine();
	keyboard.close();
	
	sendMail(email, subject, body, name);
    }
    
    public static void sendMail(String email, String subject, String body, String name) {
	Email e = EmailBuilder.startingBlank()
	    .from(SYSTEM_NAME, SYSTEM_EMAIL)
	    .to(name, email)
	    .withSubject(subject)
	    .withPlainText(body)
	    .buildEmail();
	
	MailerBuilder.withSMTPServer("smtp.gmail.com", 25, SYSTEM_EMAIL, PASSWORD)
	    .buildMailer()
	    .sendMail(e);
	    
	   /*
	   * If we want to allow for asynchronous sending so that our applet
	   * does not freeze, we can pass an additional argument into .sendMail().
	   *
	   * We would pass true as the second argument so using the example above,
	   * we would use .sendMail(e, true)
	   */
    }
}


public class SendMailSSL {
	
	String toEmail,message;
	
	void setEmailData(String email ,String message) {
		this.toEmail = email;
		this.message = message;
	}
	
	public static void main(String[] args) {    
		SendMailSSL obj = new SendMailSSL();
	     //from,password,to,subject,message  
	     Mailer.send("bookmyshowcorp","ashok9234",obj.toEmail,"Ticket Details From BookMyShow",obj.message);  
	     //change from, password and to  
	 }    
}

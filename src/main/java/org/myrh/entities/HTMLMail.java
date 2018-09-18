package org.myrh.entities;

public class HTMLMail {
	
	private final String to;

	

	public HTMLMail(String to) {
        this.to = to;
    }
	
	

    



	public String getTo() {
        return this.to;
    }

    public String getSubject() {
        return "Notification Commande Myhr";
    }
   

    public String getContent() {
        return "<html>" +
                    "<body>" +
                        "<p>Hello client,</p>" +
                        "<p>This an <strong>HTML</strong> email content !</p>" +
                    "</body>" +
                "</html>";
    }



}

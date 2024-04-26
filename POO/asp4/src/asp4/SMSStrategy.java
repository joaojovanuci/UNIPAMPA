package asp4;

public class SMSStrategy implements NotificationStrategy{
	
    public void processNotification(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

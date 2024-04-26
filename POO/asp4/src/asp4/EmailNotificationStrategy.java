package asp4;

public class EmailNotificationStrategy implements NotificationStrategy {
	
    public void processNotification(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}

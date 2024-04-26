package asp4;

public class NotificationContext {
	 private NotificationStrategy strategy;

	    public void setStrategy(NotificationStrategy strategy) {
	        this.strategy = strategy;
	    }

	    public void executeStrategy(String message) {
	        strategy.processNotification(message);
	    }
}

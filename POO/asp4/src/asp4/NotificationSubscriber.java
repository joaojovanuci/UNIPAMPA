package asp4;

public class NotificationSubscriber implements Observer {
	private String name;

    public NotificationSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a mensagem: " + message);
    }
}

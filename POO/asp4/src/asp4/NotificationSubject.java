package asp4;

public interface NotificationSubject {
	void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

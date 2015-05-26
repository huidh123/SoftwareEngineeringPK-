package Interface;

public interface Pulisher {
	void addObserver(Observer observer);
	void deleteObserver(Observer observer);
	void notifyAllObserver();
}

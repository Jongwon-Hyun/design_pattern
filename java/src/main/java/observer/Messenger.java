package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Messenger implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        if (Objects.nonNull(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
       observerList.remove(observer);
    }

    @Override
    public void publish(String message) {
        for (var observer : observerList) {
            observer.update(message);
        }
    }
}

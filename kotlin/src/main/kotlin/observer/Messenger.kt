package observer

class Messenger : Subject {
    private val observerList = ArrayList<Observer>()

    override fun subscribe(observer: Observer) {
        observerList.add(observer)
    }

    override fun unsubscribe(observer: Observer) {
        observerList.remove(observer)
    }

    override fun publish(message: String) {
        for (observer in observerList ) {
            observer.update(message)
        }
    }
}
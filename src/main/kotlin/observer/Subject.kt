package observer

interface Subject {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun publish(message: String)
}
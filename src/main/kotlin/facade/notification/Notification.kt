package facade.notification

class Notification {
    fun sendEmail(message: String) {
        println("메일 전송 : $message")
    }

    fun sendAppPush(message: String) {
        println("앱 푸쉬 : $message")
    }
}
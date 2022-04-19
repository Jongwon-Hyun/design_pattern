package observer.sender

import observer.Observer

class AppAlarmSender : Observer {
    override fun update(message: String) {
        pushAlarm(message)
    }

    private fun pushAlarm(message: String) {
        // 파이어베이스 클라우드 메시징 등의 서드파티 라이브러리로 앱에 푸쉬
        println("App Alarm : $message")
    }
}
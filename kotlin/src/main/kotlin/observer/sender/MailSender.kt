package observer.sender

import observer.Observer

class MailSender : Observer {
    override fun update(message: String) {
        sendMail(message)
    }

    private fun sendMail(message: String) {
        // 메일러 등의 서드파티 라이브러리로 메일 전송
        println("Mail : $message")
    }
}
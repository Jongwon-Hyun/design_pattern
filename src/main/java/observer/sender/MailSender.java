package observer.sender;

import observer.Observer;

public class MailSender implements Observer {
    @Override
    public void update(String message) {
        sendMail(message);
    }

    private void sendMail(String message) {
        // 메일러 등의 서드파티 라이브러리로 메일 전송
        System.out.println("Mail : " + message);
    }
}

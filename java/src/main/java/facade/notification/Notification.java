package facade.notification;

public class Notification {
    public void sendEmail(String message) {
        System.out.println("메일 전송 : " + message);
    }

    public void sendAppPush(String message) {
        System.out.println("앱 푸쉬 : " + message);
    }
}

package observer.sender;

import observer.Observer;

public class AppAlarmSender implements Observer {
    @Override
    public void update(String message) {
        pushAlarm(message);
    }

    private void pushAlarm(String message) {
        // 파이어베이스 클라우드 메시징 등의 서드파티 라이브러리로 앱에 푸쉬
        System.out.println("App Alarm : " + message);
    }
}

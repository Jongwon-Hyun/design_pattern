import { Observer } from "../observer";

export class AppAlarmSender implements Observer {
    update(message: string): void {
        this.appPush(message);
    }

    getName(): string {
        return "appAlarmSender";
    }

    private appPush(message: string): void {
        // 파이어베이스 클라우드 메시징 등의 서드파티 라이브러리로 앱에 푸쉬
        console.log(`App Alarm : ${message}`);
    }
}
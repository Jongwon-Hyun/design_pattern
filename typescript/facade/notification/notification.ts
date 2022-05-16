export class Notification {
    sendEmail(message: string): void {
        console.log(`메일 전송 : ${message}`);
    }

    sendAppPush(message: string): void {
        console.log(`앱 푸쉬 : ${message}`);
    }
}
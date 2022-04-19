import { Observer } from "../observer";

export class MailSender implements Observer {
    update(message: string): void {
       this.sendMail(message);
    }

    getName(): string {
        return "mailSender";
    }

    private sendMail(message: string): void {
        // 메일러 등의 서드파티 라이브러리로 메일 전송
        console.log(`Mail : ${message}`);
    }
}
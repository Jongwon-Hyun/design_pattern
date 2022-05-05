import { TransferParam } from "../transfer_param";

export class XyzBank {
    public transfer(transferParam: TransferParam) {
        console.log('XyzBank 이체 시작');

        const fee = this.calculateFee(transferParam?.amount);
        const transferAmount = (transferParam?.amount - fee)?.toFixed(3);

        console.log(
            `${transferAmount} 원을 이체 하였습니다.`);
        console.log('XyzBank 이체 종료');
    }

    private calculateFee(amount: number): number {
        return amount * 0.02;
    }
}
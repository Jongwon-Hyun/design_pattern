import { TransferParam } from "../transfer_param";

export class AbcBank {
    public transfer(transferParam: TransferParam) {
        console.log('AbcBank 이체 시작');

        if (!this.confrimAccount(transferParam?.account)) {
            throw new Error('계좌 변호를 확인해 주세요.')
        }

        const transactionID = this.generateTransactionID()

        console.log(
            `${transferParam?.amount} 원을 이체 하였습니다. 거래 내역은 ${transactionID} 로 확인해 주세요.`);
        console.log('AbcBank 이체 종료');
    }

    private confrimAccount(account: string): boolean {
        console.log(`${account} 계좌를 확인했습니다.`);
        return true;
    }

    private generateTransactionID() {
        return '1234567890';
    }
}
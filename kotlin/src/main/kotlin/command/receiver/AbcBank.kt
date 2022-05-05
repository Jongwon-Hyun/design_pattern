package command.receiver

import command.TransferParam

class AbcBank {
    fun transfer(transferParam: TransferParam) {
        println("AbcBank 이체 시작")

        if (!confirmAccount(transferParam.account)) {
            throw java.lang.IllegalArgumentException("계좌 번호를 확인해 주세요.")
        }

        val transactionID = generateTransactionID()

        println("${transferParam.amount} 원을 이체 하였습니다. 거래 내역은 $transactionID 로 확인해 주세요.")
        println("AbcBank 이체 종료")
    }

    private fun confirmAccount(account: String): Boolean {
        println("$account 계좌를 확인했습니다.")
        return true
    }

    private fun generateTransactionID(): String {
        return "123456789"
    }
}
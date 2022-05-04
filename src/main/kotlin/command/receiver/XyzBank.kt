package command.receiver

import command.TransferParam

class XyzBank {
    fun transfer(transferParam: TransferParam) {
        println("XyzBank 이체 시작")

        val fee = calculateFee(transferParam.amount)
        val transferAmount = transferParam.amount - fee

        println("%.2f 원을 이체 했습니다.".format(transferAmount))
        println("XyzBank 이체 종료")
    }

    private fun calculateFee(amount: Double): Double {
        return amount * 0.02
    }
}
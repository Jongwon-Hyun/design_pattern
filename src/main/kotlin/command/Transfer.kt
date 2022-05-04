package command

class Transfer(private val command: (TransferParam) -> Unit) {
    fun start(transferParam: TransferParam) {
        command(transferParam)
    }
}
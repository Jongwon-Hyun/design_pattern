import command.Transfer
import command.TransferParam
import command.receiver.AbcBank
import command.receiver.XyzBank
import io.kotest.core.spec.style.FunSpec
import java.util.*

class CommandTest : FunSpec({
    test("Command Run") {
        val queue: Queue<Transfer> = LinkedList()

        val abcBank = AbcBank()
        val transferToAbcBank = Transfer { transferParam -> abcBank.transfer(transferParam) }
        queue.offer(transferToAbcBank)

        val xyzBank = XyzBank()
        val transferToXyzBank = Transfer { transferParam -> xyzBank.transfer(transferParam) }
        queue.offer(transferToXyzBank)

        while (!queue.isEmpty()) {
            val transfer = queue.poll()
            transfer.start(TransferParam(123.45, "012345"))
        }
    }
})
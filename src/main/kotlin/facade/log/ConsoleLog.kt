package facade.log

class ConsoleLog : Log {
    override fun info(message: String) {
        println("INFO : $message")
    }

    override fun warn(message: String) {
        println("WARN : $message")
    }

    override fun fatal(message: String) {
        println("FATAL : $message")
    }
}
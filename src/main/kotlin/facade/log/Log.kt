package facade.log

interface Log {
    fun info(message: String)
    fun warn(message: String)
    fun fatal(message: String)
}
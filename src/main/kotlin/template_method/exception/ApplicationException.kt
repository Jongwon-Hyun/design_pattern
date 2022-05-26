package template_method.exception

class ApplicationException(message: String, val status: Int) : RuntimeException(message)
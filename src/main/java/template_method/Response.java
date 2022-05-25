package template_method;

public record Response<T>(T body, int status) {
}

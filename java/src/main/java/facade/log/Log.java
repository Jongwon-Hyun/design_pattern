package facade.log;

public interface Log {
    void info(String message);

    void warn(String message);

    void fatal(String message);
}

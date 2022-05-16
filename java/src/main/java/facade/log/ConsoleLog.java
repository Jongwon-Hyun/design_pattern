package facade.log;

public class ConsoleLog implements Log {
    @Override
    public void info(String message) {
        System.out.println("INFO : " + message);
    }

    @Override
    public void warn(String message) {
        System.out.println("WARN : " + message);
    }

    @Override
    public void fatal(String message) {
        System.out.println("FATAL : " + message);
    }
}

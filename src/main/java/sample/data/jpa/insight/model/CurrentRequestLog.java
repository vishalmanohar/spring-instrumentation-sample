package sample.data.jpa.insight.model;


import java.util.Optional;

public class CurrentRequestLog {
    private static final ThreadLocal<RequestLog> requestLogHolder = new ThreadLocal<>();

    public static void start(String urlPath){
        requestLogHolder.set(new RequestLog(urlPath));
    }

    public static Optional<RequestLog> get() {
        RequestLog requestLog = requestLogHolder.get();
        return Optional.ofNullable(requestLog);
    }

    public static void remove() {
        requestLogHolder.remove();
    }
}

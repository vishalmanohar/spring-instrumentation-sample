package sample.data.jpa.insight.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestLogs {

    private static final Map<String, RequestLog> requestLogs = Collections.synchronizedMap(new FiniteLinkedHashMap<>(10));
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void addLog(RequestLog requestLog){
        requestLogs.put(String.valueOf(counter.incrementAndGet()), requestLog);
    }

    public static Map<String, RequestLog> logs() {
        return requestLogs;
    }
}

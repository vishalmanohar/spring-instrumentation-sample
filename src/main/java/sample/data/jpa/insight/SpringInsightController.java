package sample.data.jpa.insight;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.insight.model.RequestLog;
import sample.data.jpa.insight.model.RequestLogs;

import java.util.Map;

@Controller
public class SpringInsightController {

    @RequestMapping("/insight/logs")
    @ResponseBody
    public Map<String, RequestLog> logs(){
        return RequestLogs.logs();
    }

}

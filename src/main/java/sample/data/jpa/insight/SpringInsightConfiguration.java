package sample.data.jpa.insight;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@EnableLoadTimeWeaving
public class SpringInsightConfiguration extends WebMvcConfigurerAdapter {

    public SpringInsightConfiguration() {
        super();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SpringInsightMVCInterceptor());
    }
}

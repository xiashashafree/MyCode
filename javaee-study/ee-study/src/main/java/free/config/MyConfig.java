package free.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         //所有匹配的路径都会进入拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/1/**")//**代表所有子路径。*代表一级路径
                .excludePathPatterns("/1/login5");//排除路径
    }
}

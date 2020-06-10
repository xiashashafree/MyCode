package free.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//所有匹配的路径都会进入拦截器
                .addPathPatterns("/**")//**代表所有子路径。*代表一级路径
                .excludePathPatterns("/login5");//排除路径
    }
}

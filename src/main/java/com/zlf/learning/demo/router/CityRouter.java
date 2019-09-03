package com.zlf.learning.demo.router;

import com.zlf.learning.demo.handler.CityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @ClassName CityRouter
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/26 16:47
 * @Version 1.0
 */

@Configuration
public class CityRouter {


    @Bean
    public RouterFunction<ServerResponse> routerCity(CityHandler cityHandler){
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                cityHandler::helloCity);
    }
}

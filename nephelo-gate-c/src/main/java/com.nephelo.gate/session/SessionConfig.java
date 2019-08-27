package com.nephelo.gate.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * Created by nephelo on 2018/12/21.
 */
@Configuration
public class SessionConfig {
     @Bean
    public   ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}

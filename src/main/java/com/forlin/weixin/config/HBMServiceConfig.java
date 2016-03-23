package com.forlin.weixin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by forlin on 2016/2/27.
 */
@Configuration
@EnableScheduling
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.forlin.weixin.repository"
)
@ImportResource({"classpath:sup_db_config.xml"})
public class HBMServiceConfig {
    /**
     * �����滻Ϊ����Password
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}

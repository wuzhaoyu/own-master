package com.own.modules.security.config;

import com.own.modules.security.config.bean.LoginProperties;
import com.own.modules.security.config.bean.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类功能说明:  配置文件转换POJO类型
 * 类修改者	创建日期2020/7/28
 * 修改说明
 * @author wzy
 * @version V1.0
 **/
@Configuration
public class ConfigBeanConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "login",ignoreUnknownFields = true)
    public LoginProperties loginProperties(){
      return new LoginProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt",ignoreUnknownFields = true)
    public SecurityProperties securityProperties(){
       return new SecurityProperties();
    }


}

package com.wd7.sso.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomeConfigurationOAuth2Properties {

    private code code;

    @Data
    public class code{
        private Integer timeout;
        private String prefix;
    }

}

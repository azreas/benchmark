package com.xzj.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xzj
 * @Date 2019/06/27.
 */
@Configuration
public class TomcatConfig {
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createH2cConnector());
        return tomcat;
    }

    private Connector createH2cConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http2Protocol upgradeProtocol = new Http2Protocol();
        connector.addUpgradeProtocol(upgradeProtocol);
        //connector.setScheme("http");
        connector.setPort(5080);

        return connector;
    }
}

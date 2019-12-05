package cn.linkpower.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http:localhost:8081  访问  https:localhost:8080
 * @author 76519
 *
 */
@Configuration
public class TomcatConfig {
	
	@Bean
	TomcatServletWebServerFactory tomcatServletWebServerFactory(){
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        factory.addAdditionalTomcatConnectors(createTomcatConnector());
        return factory;
	}
	
	private Connector createTomcatConnector() {
        Connector connector = new
                Connector("org.apache.coyote.http11.Http11NioProtocol");
        //http请求的端口号信息配置：http://localhost:8081
        connector.setScheme("http");
        connector.setPort(8081);
        //请求操作后，重定向操作
        connector.setSecure(false);
        connector.setRedirectPort(8080);
        return connector;
    }
}

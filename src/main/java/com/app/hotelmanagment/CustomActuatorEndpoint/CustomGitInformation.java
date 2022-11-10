package com.app.hotelmanagment.CustomActuatorEndpoint;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class CustomGitInformation implements InfoContributor {

    PropertySourcesPlaceholderConfigurer propsConfig;

    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        propsConfig = new PropertySourcesPlaceholderConfigurer();
        propsConfig.setLocation(new ClassPathResource("git.properties"));
        propsConfig.setIgnoreResourceNotFound(true);
        propsConfig.setIgnoreUnresolvablePlaceholders(true);
        return propsConfig;
    }


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("Git Information",propsConfig);
    }
}

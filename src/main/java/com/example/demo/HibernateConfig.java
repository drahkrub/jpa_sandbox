package com.example.demo;

import com.example.demo.hibernate.HibernateIntegrator;
import java.util.Collections;
import java.util.Map;
import org.hibernate.jpa.boot.spi.IntegratorProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author Burkhard Graves
 */
@Component
public class HibernateConfig implements HibernatePropertiesCustomizer {

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.integrator_provider",
                (IntegratorProvider) () -> Collections.singletonList(HibernateIntegrator.instance()));
    }
}
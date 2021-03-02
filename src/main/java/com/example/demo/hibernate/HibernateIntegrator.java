package com.example.demo.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * @author Burkhard Graves
 */
public class HibernateIntegrator implements Integrator {
    
    private final static HibernateIntegrator ME = new HibernateIntegrator();

    private Metadata metadata;
    private SessionFactoryImplementor sessionFactory;
    private SessionFactoryServiceRegistry serviceRegistry;

    private HibernateIntegrator() {
    }
    
    public static HibernateIntegrator instance() {
        return ME;
    }

    public static Metadata getMetadata() {
        return ME.metadata;
    }

    public static SessionFactoryImplementor getSessionFactory() {
        return ME.sessionFactory;
    }

    public static SessionFactoryServiceRegistry getServiceRegistry() {
        return ME.serviceRegistry;
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        metadata = null;
        sessionFactory = null;
        serviceRegistry = null;
    }

    @Override
    public void integrate(Metadata metadata, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        this.metadata = metadata;
        this.sessionFactory = sfi;
        this.serviceRegistry = sfsr;
    }
}
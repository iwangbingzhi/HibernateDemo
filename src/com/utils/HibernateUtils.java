package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 王炳智 on 2017/9/21.
 */
public class HibernateUtils {
    private static final Configuration cfg;
    private static final SessionFactory sessionFactory;

    static {
        cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

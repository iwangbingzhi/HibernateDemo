package com.test;

import com.example.entity.User;
import com.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by 王炳智 on 2017/9/20.
 */
public class HibernateTest
{
    public static void main(String[] args) {
        testSaveOrUpdate();
    }

    public static void testAdd(){
        /*1.加载hibernate的核心配置文件 在hibernate中封装对象*/
        //Configuration configuration = new Configuration().configure();

        /*2.创建sessionFactory对象 读取配置文件内容，创建sessionFactory
        * 在过程中，根据映射关系，在配置数据库里面把表创建
        * */
        //SessionFactory sessionFactory = configuration.buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        /*3.使用sessionfactory创建session对象*/



        Session session = sessionFactory.openSession();

        /*4.开启事务*/
        Transaction transaction = session.beginTransaction();

        /*5.写crud操作*/
        User user = new User();
        user.setUsername("xuezhiqian");
        user.setPassword("22222");
        user.setAddress("中国");
        session.save(user);

        /*6.提交事务*/
        transaction.commit();

        /*7.关闭资源*/
        session.close();
        sessionFactory.close();
    }
    public static void testReserch(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        //根据Id查询
        User user = session.get(User.class,1);
        System.out.println(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public static void testUpdate(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class,2);
        user.setAddress("中国台湾");
        session.update(user);
        //也可以使用save保存,但是会违反原则
        //session.save(user);
        System.out.println(user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    //常用的删除操作
    public static void testDelete(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class,2);
        session.delete(user);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
    //不常用的删除操作
    public static void testDelete1(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUid(2);
        session.delete(user);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
    public static void testSaveOrUpdate(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


/*      User user = new User();
        user.setUid(2);
        user.setUsername("周杰伦");
        user.setPassword("123");
        user.setAddress("taiwan");
        session.save(user);*/
//1 添加操作
        User user = new User();
        user.setUid(5);
        user.setUsername("金城武");
        user.setPassword("520");
        user.setAddress("日本");
        session.saveOrUpdate(user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

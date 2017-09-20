package com.test;

import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by 王炳智 on 2017/9/20.
 */
public class HibernateTest
{
    public static void main(String[] args) {
        testAdd();
    }

    public static void testAdd(){
        /*1.加载hibernate的核心配置文件 在hibernate中封装对象*/
        Configuration configuration = new Configuration().configure();

        /*2.创建sessionFactory对象 读取配置文件内容，创建sessionFactory
        * 在过程中，根据映射关系，在配置数据库里面把表创建
        * */
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        /*3.使用sessionfactory创建session对象*/
        Session session = sessionFactory.openSession();

        /*4.开启事务*/
        Transaction transaction = session.beginTransaction();

        /*5.写crud操作*/
        User user = new User();
        user.setUsername("wanglihong");
        user.setPassword("666");
        user.setAddress("中国");
        session.save(user);

        /*6.提交事务*/
        transaction.commit();

        /*7.关闭资源*/
        session.close();
        sessionFactory.close();
    }
}

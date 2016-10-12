package store;

import models.Developers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

/**
 * Created by root on 07.10.16.
 */
public class HibernateStorage implements Storage {

    private final SessionFactory sessionFactory;

    public HibernateStorage() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Collection<Developers> values() {
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            return session.createQuery("FROM Developers").list();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public int add(Developers developer) {
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(developer);
            return developer.getId();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public void edit(Developers developer) {

    }

    public void delete(int id) {
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(new Developers(id, null, null, 0));
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public Developers get(int id) {
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            return (Developers) session.get(Developers.class, id);
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public Developers findByName(String name) {
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Developers as user where user.name=:name");
            query.setString("name", name);
            return (Developers) query.iterate().next();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public void close() {
        this.sessionFactory.close();
    }
}

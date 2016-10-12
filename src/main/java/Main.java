import models.Developers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by root on 07.10.16.
 */

/**
 * ТЕСТИРОВАНИЕ ЗАПРОСОВ
 * Запросы:
 * SQL (deprecated)
 * HQL (работает с классами, а не таблицами)
 * Criteria (Hibernate 5 deprecated)
 *
 *
 * транзакция - допустим есть 3 sql запроса,
 * если один из них не может выполнится,
 * то вернуться к базе с начальным состоянием, до этих запросов
 * коммит - применить внесенные изменения, если 3 выше запроса прошли успешно
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        List<Developers> developers = null;

        try {
            session.beginTransaction(); // начать транзакцию


            // запросы HQL
            /*


            */
            Query query = session.createQuery("FROM Developers"); // Developers - это класс
            developers = query.list();


            //Developers developer = new Developers("Dmitry", "Java", 2500);
            //developer.setId(9);

            //session.save(developer); // добавить в БД данные
            //session.update(developer); // обновить данные (по первичному ключу)
            //session.delete(developer); // удалить запись из БД


            session.getTransaction().commit(); // внести изменения в СУБД
        } catch(Exception e) {
            session.getTransaction().rollback(); // отменить изменения
            e.printStackTrace();
        } finally {
            // закрыть соединения
            session.close();
            sessionFactory.close();
        }

        for (Developers developer : developers) {
            System.out.println(developer.toString());
        }

    }
}

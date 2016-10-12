package store;

import models.Developers;

import java.util.Collection;

/**
 * Created by root on 07.10.16.
 */
public interface Storage {

    public Collection<Developers> values();

    public int add(final Developers developer);

    public void edit(final Developers developer);

    public void delete(final int id);

    public Developers get(final int id);

    public Developers findByName(String name);

    public void close();
}

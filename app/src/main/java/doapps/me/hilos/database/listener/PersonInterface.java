package doapps.me.hilos.database.listener;

import java.util.List;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public interface PersonInterface<P> {
    void insert(P p);
    P find(String id);
    List<P> findAll();
}

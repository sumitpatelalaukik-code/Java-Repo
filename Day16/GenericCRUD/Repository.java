import java.util.List;

public interface Repository<T> {

    T findById(String id);

    List<T> findAll();

    void add(T entity);

    boolean update(String id, T entity);

    boolean delete(String id);
}
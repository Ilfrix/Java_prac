package lab3;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private final List<T> list = new ArrayList<>();
    synchronized public int size() {
        return list.size();
    }

    synchronized public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean add(T t) {
        return list.add(t);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }
    public T get(int index) {
        return list.get(index);
    }

    public T set(int index, T element) {
        return list.set(index, element);
    }
}

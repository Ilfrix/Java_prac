package lab3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class MySet<T> {
    private final Set<T> set = Collections.synchronizedSet(new HashSet<>());
    private static final Semaphore semaphore = new Semaphore(1);

    public boolean add (T element) throws InterruptedException {
        boolean res = false;
        semaphore.acquire();
        try {
            res = set.add(element);
        } finally {
            semaphore.release();
        }
        return res;
    }

    public boolean isEmpty() throws InterruptedException{
        semaphore.acquire();
        boolean res = true;
        try {
            res = set.isEmpty();
        } finally {
            semaphore.release();
        }
        return res;
    }

    public int size() throws InterruptedException{
        semaphore.acquire();
        int res = 0;
        try{
            res = set.size();
        } finally {
            semaphore.release();
        }
        return res;
    }

    public boolean remove(Object key) throws InterruptedException{
        semaphore.acquire();
        boolean res = false;
        try{
            res = set.remove(key);
        } finally {
            semaphore.release();
        }
        return res;
    }
    public void clear() throws InterruptedException{
        semaphore.acquire();
        try{
            set.clear();
        } finally {
            semaphore.release();
        }
    }
}

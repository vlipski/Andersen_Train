import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private Lock lock;
    private Condition cond;
    private int goods;

    Storage() {
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }

    public void unload() {
        lock.lock();
        try {
            while (goods >= 3) {
                cond.await();
            }
            goods++;
            System.out.println("Разгрузили машину");
            System.out.println("На складе: " + goods + " товаров");
            cond.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void load() {
        {
            lock.lock();
            try {
                while (goods < 1) {
                    cond.await();
                }
                goods--;
                System.out.println("Загрузили машину");
                System.out.println("На складе: " + goods + " товаров");
                cond.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

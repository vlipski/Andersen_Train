import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class StorageTest {

    private Storage storage;
    private Queue<EmptyCar> emptyCarQueue;
    private Queue<FullCar> fullCarQueue;

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        emptyCarQueue = new LinkedList<>();
        fullCarQueue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            emptyCarQueue.add(new EmptyCar(storage));
            fullCarQueue.add(new FullCar(storage));
        }
    }

    @Test
    public void storageTest() throws InterruptedException {
        for (int i = 0; i < emptyCarQueue.size() && i < fullCarQueue.size(); i++) {
            Thread thread = new Thread(emptyCarQueue.poll());
            thread.start();
            Thread thread1 = new Thread(fullCarQueue.poll());
            thread1.start();
        }
        Thread.sleep(10000);
    }

}
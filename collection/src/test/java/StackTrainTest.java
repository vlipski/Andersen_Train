import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTrainTest {

    StackTrain<Integer> stackTrainIsNull = new StackTrain<>();
    StackTrain<Integer> stackTrain = new StackTrain<>();

    @Before
    public void setUp() throws Exception {
        stackTrain.add(1);
        stackTrain.add(4);
        stackTrain.add(6);
        stackTrain.add(5);
    }


    @Test(expected = NullPointerException.class)
    public void sizeTest() {
        stackTrainIsNull.size();
    }

    @Test(expected = NullPointerException.class)
    public void isEmptyTest() {
        stackTrainIsNull.isEmpty();
    }

    @Test
    public void addTest() {
        stackTrainIsNull.add(1);
        assertEquals(stackTrainIsNull.size(), 1);
        assertFalse(stackTrainIsNull.isEmpty());
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        stackTrainIsNull.add(1);
        assertEquals(stackTrainIsNull.size(), 11);
    }

    @Test
    public void containTest(){
        assertTrue(stackTrain.contains(1));
        assertFalse(stackTrain.contains(9));
    }

    @Test
    public void removeTest(){
        assertEquals(stackTrain.size(), 4);
        assertTrue(stackTrain.contains(5));
        stackTrain.remove();
        assertEquals(stackTrain.size(), 3);
        assertFalse(stackTrain.contains(5));
    }

    @Test
    public void getTest() {
        assertEquals(stackTrain.get(), 5);
        stackTrain.remove();
        assertEquals(stackTrain.get(), 6);
    }
}
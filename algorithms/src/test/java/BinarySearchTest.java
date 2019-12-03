

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] testArray = {3, 22, 27, 47, 57, 67, 89, 91, 99};


    @Test
    public void searchIndexTest(){
        int  index = BinarySearch.searchIndex(testArray,47);
        assertEquals(index,3);
        assertNotEquals(index,4);
    }
}

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private int[] arrayForBubble = {3, 1, 45, 67, 5};
    private int[] arrayForSelection = {3, 1, 45, 67, 5};

    @Test
    public void bubbleSortTest() {
        int[] expected = Sort.bubbleSort(arrayForBubble);
        assertArrayEquals(expected,new int[]{1,3,5,45,67});
    }

    @Test
    public void selectionSortTest() {
        int[] expected = Sort.selectionSort(arrayForSelection);
        assertArrayEquals(expected,new int[]{1,3,5,45,67});
    }
}
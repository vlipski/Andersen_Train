

public class Sort {


    public static int[] bubbleSort(int[] array) {

        for (int i = array.length; i > 0; i--) {
            for (int k = 0; k < array.length - 1; k++) {
                if (array[k] > array[k + 1]) {
                    int buffer = array[k + 1];
                    array[k + 1] = array[k];
                    array[k] = buffer;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {

        for(int i = 0; i < array.length - 1; i++){
            int min = array[i];
            int index = i;
            for(int k = i + 1;k < array.length; k++){
                if(min > array[k]){
                    min = array[k];
                    index = k;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
        return array;
    }
}

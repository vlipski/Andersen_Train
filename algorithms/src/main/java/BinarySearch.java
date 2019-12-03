

public class BinarySearch {



    public static int searchIndex(int[] array, int number){
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (true) {
            int index = (firstIndex + lastIndex) / 2;
            if(array[index] == number){
                return index;
            }
            if (array[index] < number){
                firstIndex = index + 1;
            } else {
                lastIndex = index - 1;
            }
        }

    }

}

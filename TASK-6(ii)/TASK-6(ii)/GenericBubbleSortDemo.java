import java.util.Arrays;

public class GenericBubbleSortDemo {
    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 8, 1, 4};
        Double[] doubleArray = {3.2, 1.5, 4.7, 2.9};
        String[] strArray = {"banana", "apple", "grape", "orange"};

        // Sorting integers
        System.out.println("Before sorting integers: " + Arrays.toString(intArray));
        GenericBubbleSort.bubbleSort(intArray);
        System.out.println("After sorting integers: " + Arrays.toString(intArray));

        // Sorting doubles
        System.out.println("Before sorting doubles: " + Arrays.toString(doubleArray));
        GenericBubbleSort.bubbleSort(doubleArray);
        System.out.println("After sorting doubles: " + Arrays.toString(doubleArray));

        // Sorting strings
        System.out.println("Before sorting strings: " + Arrays.toString(strArray));
        GenericBubbleSort.bubbleSort(strArray);
        System.out.println("After sorting strings: " + Arrays.toString(strArray));
    }
}

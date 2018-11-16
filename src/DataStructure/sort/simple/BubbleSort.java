package DataStructure.sort.simple;
/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{93, 456, 23, 2, 56, 23909, 28, 66, 2348, 75, 78, 458, 5678, 5672, 5};

        sort(array);
    }


    private static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        System.out.println("排序前:");
        printArray(array);

        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        System.out.println("排序后:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int item : array){
            builder.append(item);
            builder.append(",");
        }
        System.out.println(builder.toString());
    }

    private static void swap(int[] array, int onePos, int twoPos) {
        int one = array[onePos];
        array[onePos] = array[twoPos];
        array[twoPos] = one;
    }
}

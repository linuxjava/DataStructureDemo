package DataStructure.sort.high;

/**
 * 快速排序
 */
public class QuickSort {
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

        sort(array, 0, array.length - 1);

        System.out.println("排序后:");
        printArray(array);
    }

    public static void sort(int sortArray[], int left, int right) {
        if (left < right) {
            int result = partition2(sortArray, left, right);
            sort(sortArray, left, result - 1);
            sort(sortArray, result + 1, right);
        }
    }


    private static int partition2(int[] array, int left, int right){
        int key = array[right];
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true){
            while (array[++leftPtr] < key);

            while (array[--rightPtr] > key);

            if(rightPtr <= leftPtr){
                break;
            }else {
                swap(array, leftPtr, rightPtr);
            }
        }

        swap(array, leftPtr, right);

        return leftPtr;
    }

    /**
     * 划分
     *
     * @param sortArray
     * @param left
     * @param right
     * @return
     */
    private static int partition(int sortArray[], int left, int right) {
        int key = sortArray[left];

        while (left < right) {
            while (left < right && sortArray[right] >= key)
                right--;
            sortArray[left] = sortArray[right];

            while (left < right && sortArray[left] <= key)
                left++;
            sortArray[right] = sortArray[left];
        }
        sortArray[left] = key;

        return left;
    }


    private static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int item : array) {
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

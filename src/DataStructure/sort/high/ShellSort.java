package DataStructure.sort.high;

/**
 * 插入排序
 */
public class ShellSort {
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

        int gap = 1;//
        int lenght = array.length;

        while (gap < lenght / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < lenght; i++) {
                int j = i;
                while (j - gap >= 0 && array[j - gap] > array[j]) {
                    swap(array, j - gap, j);
                    j -= gap;
                }
            }

            gap = (gap - 1) / 3;
        }

        System.out.println("排序后:");
        printArray(array);
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

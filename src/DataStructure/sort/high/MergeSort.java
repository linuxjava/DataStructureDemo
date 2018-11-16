package DataStructure.sort.high;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
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

        int[] workspace = new int[array.length];
        mergeSort(array, workspace, 0, array.length - 1);

        System.out.println("排序后:");
        printArray(array);
    }

    private static void mergeSort(int[] array, int[] workspace, int left, int right) {
        int mid = (left + right) / 2;

        if (left == right) {
            //递归返回的结束条件
            return;
        } else {
            mergeSort(array, workspace, left, mid);
            mergeSort(array, workspace, mid + 1, right);

            merge(array, workspace, left, mid, right);
        }
    }

    /**
     * 将两个数组归并到一个数组
     *
     * @param array
     * @param workspace
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] array, int[] workspace, int left, int mid, int right) {
        int leftPtr = left;
        int rightPtr = mid + 1;
        int j = 0;

        while (leftPtr <= mid && rightPtr <= right) {
            if (array[leftPtr] < array[rightPtr]) {
                workspace[j++] = array[leftPtr++];
            } else {
                workspace[j++] = array[rightPtr++];
            }
        }

        while (leftPtr <= mid) {
            workspace[j++] = array[leftPtr++];
        }

        while (rightPtr <= right) {
            workspace[j++] = array[rightPtr++];
        }

        for (int i = 0; i < j; i++) {
            array[i + left] = workspace[i];
        }
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

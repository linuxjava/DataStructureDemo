package DataStructure.find;

/**
 * 二分查找(前置条件：数组是有序的)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 100, 1000, 10000, 100000, 2330030};

        //System.out.println("find = " + search(array, 23300300));
        System.out.println("find = " + search1(array, 0, array.length-1, 1));
    }

    private static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return array[mid];
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int search1(int[] array, int low, int high, int target) {
        if(low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return array[mid];
            } else if (array[mid] < target) {
                low = mid + 1;
                return search1(array, low, high, target);
            } else {
                high = mid - 1;
                return search1(array, low, high, target);
            }
        }

        return -1;
    }

    private static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int item : array) {
            builder.append(item);
            builder.append(",");
        }
        System.out.println(builder.toString());
    }
}

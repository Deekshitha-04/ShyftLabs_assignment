public class Problem1 {
    public static int findIndex(int[] arr) {
        int low = 0;
        int left = 1;

        if (arr[low] == -1) {
            return low;
        }

        while (low + left < arr.length && arr[low + left] != -1) {
            low += left;
            left *= 2;
        }

        int right = low;
        int high = Math.min(low + left, arr.length - 1);

        while (right <= high) {
            int middle = right + (high - right) / 2;

            if (arr[middle] == -1) {
                high = middle - 1;
            } else {
                right = middle + 1;
            }
        }

        return high + 1;// never happen based on the problem statement
    }

    public static void main(String[] args) {
        int[] array1 = { 3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1 };
        System.out.println("Output for array1: " + findIndex(array1));

        int[] array2 = { -1, -1, -1, -1 };
        System.out.println("Output for array2: " + findIndex(array2));
    }
}
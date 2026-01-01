class MergeSort {

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        MergeSort object = new MergeSort();
        int[] array = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89 };
        object.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
    }
}

/**
 * Left Index: 0
 * Right Index: 17
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 0
 * Right Index: 8
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 0
 * Right Index: 4
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 0
 * Right Index: 2
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 0
 * Right Index: 1
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 3
 * Right Index: 4
 * 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 5
 * Right Index: 8
 * 12, 13, 23, 43, 93, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 5
 * Right Index: 6
 * 12, 13, 23, 43, 93, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 7
 * Right Index: 8
 * 12, 13, 23, 43, 93, 19, 59, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 9
 * Right Index: 17
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 9
 * Right Index: 13
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 9
 * Right Index: 11
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 9
 * Right Index: 10
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 12
 * Right Index: 13
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, 53, 90, 143, 28, -13, 85, 20, 73, 89
 * Left Index: 14
 * Right Index: 17
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, -13, 28, 53, 90, 143, 85, 20, 73, 89
 * Left Index: 14
 * Right Index: 15
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, -13, 28, 53, 90, 143, 85, 20, 73, 89
 * Left Index: 16
 * Right Index: 17
 * -16, 10, 12, 13, 19, 23, 43, 59, 93, -13, 28, 53, 90, 143, 20, 85, 73, 89
 *
 * Sorted Array
 * -16, -13, 10, 12, 13, 19, 20, 23, 28, 43, 53, 59, 73, 85, 89, 90, 93, 143
 */

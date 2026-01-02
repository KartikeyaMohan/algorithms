class HeapSort {

    private void sort(int[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);
        for(int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            swap(arr, i, max);
            heapify(arr, n, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort object = new HeapSort();
        int[] arr = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20, 73, 89 };
        object.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
    }
}
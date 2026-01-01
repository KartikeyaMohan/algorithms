class QuickSort {

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low;
        for(int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, left);
                left++;
            }
        }
        swap(arr, left, high);
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort object = new QuickSort();
        int[] arr = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20 };
        object.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
    }
}

/**
 *
    Array: 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20
    Low: 0
    High: 15
    Pivot: 6 (Element arr[15] i.e. 20 is set on it's correct 6th position after running partition)
    Array: 12, 13, 19, 10, -16, -13, 20, 43, 23, 53, 90, 143, 28, 59, 85, 93
    Low: 0
    High: 5
    Pivot: 1 (Element arr[5] i.e. -13 is set on it's correct 1st position after running partition)
    Array: -16, -13, 19, 10, 12, 13, 20, 43, 23, 53, 90, 143, 28, 59, 85, 93
    Low: 2
    High: 5
    Pivot: 4 (Element arr[5] i.e. 13 is set on it's correct 4th position after running partition)
    Array: -16, -13, 10, 12, 13, 19, 20, 43, 23, 53, 90, 143, 28, 59, 85, 93
    Low: 2
    High: 3
    Pivot: 3 (Element arr[3] i.e. 12 is already in correct position since arr[2] is 10 and smaller, no swapping done)
    Array: -16, -13, 10, 12, 13, 19, 20, 43, 23, 53, 90, 143, 28, 59, 85, 93
    --------------------------------- First half sorted (elements till 20 (6th index)) ---------------------------------
    Low: 7
    High: 15
    Pivot: 14 (Element arr[15] i.e. 93 is set on it's correct 14th position after running partition)
    Array before sort: -16, -13, 10, 12, 13, 19, 20, 43, 23, 53, 90, 28, 59, 85, 93, 143
    Low: 7
    High: 13
    Pivot: 12 (Element arr[13] i.e. 85 is set on it's correct 12th position after running partition)
    Array before sort: -16, -13, 10, 12, 13, 19, 20, 43, 23, 53, 28, 59, 85, 90, 93, 143
    Low: 7
    High: 11
    Pivot: 11 (Element arr[11] i.e. 59 is already on it's designated position of 11 the index)
    Array before sort: -16, -13, 10, 12, 13, 19, 20, 43, 23, 53, 28, 59, 85, 90, 93, 143
    Low: 7
    High: 10
    Pivot: 8 (Element arr[10] i.e. 28 is set on it's correct 8th position after running partition)
    Array before sort: -16, -13, 10, 12, 13, 19, 20, 23, 28, 53, 43, 59, 85, 90, 93, 143
    Low: 9
    High: 10
    Pivot: 9 (Element arr[10] i.e. 43 is set on it's correct 9th position after running partition)
    Array sorted: -16, -13, 10, 12, 13, 19, 20, 23, 28, 43, 53, 59, 85, 90, 93, 143
    ----------------------------- Entire array is sorted since the second half got sorted ------------------------------
 *
 */
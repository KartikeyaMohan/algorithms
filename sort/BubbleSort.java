class BubbleSort {

    private void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort object = new BubbleSort();
        int[] arr = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20 };
        object.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
    }
}
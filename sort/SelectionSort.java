class SelectionSort {

    private int[] sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = minIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        SelectionSort object = new SelectionSort();
        int[] array = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20 };
        int[] sortedArray = object.sort(array);
        for(int i = 0; i < sortedArray.length; i++) {
            if (i == sortedArray.length - 1) {
                System.out.println(sortedArray[i]);
            }
            else {
                System.out.print(sortedArray[i] + ", ");
            }
        }
    }
}
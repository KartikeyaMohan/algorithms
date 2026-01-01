class BinarySearch {

    private int search(int[] arr, int searchItem) {
        int left = 0;
        int right = arr.length;
        int middle = (left + right) / 2;
        while (left < right) {
            if (arr[middle] == searchItem) {
                return middle;
            }
            else {
                if (arr[middle] > searchItem) {
                    right = middle;
                }
                else {
                    left = middle;
                }
            }
            middle = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch object = new BinarySearch();
        int[] array = {6, 12, 43, 56, 65, 88, 93, 102, 204, 533, 649, 834, 949}; //Sorted array only
        int searchItem = 204;
        System.out.println(object.search(array, searchItem));
    }
}
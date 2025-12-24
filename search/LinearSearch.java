class LinearSearch {

    private int search(int[] array, int searchItem) {
        for(int i = 0; i < array.length; i++) {
            if (searchItem == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch object = new LinearSearch();
        int[] array = { 12, 43, 93, 13, 23, 59, 19, 10, -16, 53, 90, 143, 28, -13, 85, 20 };
        int searchItem = 10;
        System.out.println(object.search(array, searchItem));
    }
}
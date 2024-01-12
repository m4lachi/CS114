public class insertionSort_Michelle_main {
    
    public static void main(String[] args) {
        int[] test = {16,86,98,34,8,53,-1};

        System.out.println("Original Array");
        printArray(test);

        insertionSort(test);
        System.out.println();

        System.out.println("Sorted Array");
        printArray(test);
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i =1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr){
        for(int element : arr){
            System.out.println(element + " ");
        }
        System.out.println();
    }
}

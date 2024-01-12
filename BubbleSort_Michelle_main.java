public class BubbleSort_Michelle_main {

    public static void main(String[] args) {
        int[] test = {16,86,98,34,8,53,-1};

        System.out.println("Original Array:");
        printArray(test);

        bubbleSort(test);

        System.out.println();

        System.out.println("Sorted Array:");
        printArray(test);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // Swap
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class selectionSort_Michelle_main {

    public static void main(String[] args) {
        int[] test = {16,86,98,34,8,53,-1};

        System.out.println("Original Array");
        printArray(test);

        selectionSort(test);
        System.out.println();

        System.out.println("Sorted Array");
        printArray(test);

    }
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse the array
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr){
        for(int element : arr){
            System.out.println(element + " ");
        }
        System.out.println();
    }
}

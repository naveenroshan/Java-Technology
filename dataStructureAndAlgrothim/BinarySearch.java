package dataStructureAndAlgrothim;

public class BinarySearch {
    // Returns index of x if it is present in arr[l..// r], else return -1
    static int binarySearch(int arr[], int l, int r, int x) {
        //here l is the starting index of the array
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        // n is the total lenght of the array, x is the no we have to find
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == 0)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr, 1, arr.length - 2);
    }

    private int binarySearch(int[] arr, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        if (arr[mid - 1] < arr[mid]) {
            // Peak lies to the right
            return binarySearch(arr, mid + 1, end);
        } else {
            // Peak lies to the left
            return binarySearch(arr, start, mid - 1);
        }
    }
}
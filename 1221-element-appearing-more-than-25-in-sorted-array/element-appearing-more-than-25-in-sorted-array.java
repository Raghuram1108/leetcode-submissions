class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        // Handle the case where quarter is zero
        if (quarter == 0) {
            return n > 0 ? arr[0] : -1;
        }

        // Check every possible candidate element
        for (int i = quarter; i < n; i += quarter) {
            // Use binary search to find the first and last occurrence of the candidate element
            int leftOccurrence = binarySearch(arr, arr[i], true);
            int rightOccurrence = binarySearch(arr, arr[i], false);

            // Check if the frequency is greater than 25%
            if (rightOccurrence - leftOccurrence + 1 > quarter) {
                return arr[i];
            }
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target, boolean isFirst) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }    
}
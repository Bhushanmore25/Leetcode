class Solution {

    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// class Solution {

//     public int[] sortArray(int[] nums) {
//         mergeSort(nums, 0, nums.length - 1);
//         return nums;
//     }

//     private void mergeSort(int[] nums, int left, int right) {
//         if (left >= right) {
//             return;
//         }

//         int mid = left + (right - left) / 2;

//         mergeSort(nums, left, mid);
//         mergeSort(nums, mid + 1, right);

//         merge(nums, left, mid, right);
//     }

//     private void merge(int[] nums, int left, int mid, int right) {

//         int[] temp = new int[right - left + 1];

//         int i = left;
//         int j = mid + 1;
//         int k = 0;

//         while (i <= mid && j <= right) {
//             if (nums[i] <= nums[j]) {
//                 temp[k++] = nums[i++];
//             } else {
//                 temp[k++] = nums[j++];
//             }
//         }

//         while (i <= mid) {
//             temp[k++] = nums[i++];
//         }

//         while (j <= right) {
//             temp[k++] = nums[j++];
//         }

//         for (int x = 0; x < temp.length; x++) {
//             nums[left + x] = temp[x];
//         }
//     }
// }
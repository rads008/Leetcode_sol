class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int medi = -1;

        if ((m + n) % 2 == 0)
            medi = (m + n) / 2;
        else
            medi = (m + n - 1) / 2;

        int nums3[] = new int[medi + 1];
        int j = 0, k = 0;

        for (int i = 0; i <= medi; i++) {
            if (j < m && k < n) {
                if (nums1[j] < nums2[k]) {
                    nums3[i] = nums1[j];
                    j++;
                } else {
                    nums3[i] = nums2[k];
                    k++;
                }
            } else if (j < m) {
                nums3[i] = nums1[j];
                j++;
            } else {
                nums3[i] = nums2[k];
                k++;
            }
        }

        if ((m + n) % 2 == 1)
            return (double) nums3[medi];
        else
            return (double) (nums3[medi] + nums3[medi - 1]) / 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double result = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + result); // Output: 2.0
    }
}

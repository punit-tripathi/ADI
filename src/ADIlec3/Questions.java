package ADIlec3;


        //leetcode 215
        public class Question {
            public int findKthLargest(int[] nums, int k) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                for (int i = 0; i < k; i++) {
                    minHeap.offer(nums[i]);
                }

                for (int i = k; i < nums.length; i++) {
                    if (nums[i] > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(nums[i]);
                    }
                }

                return minHeap.peek();
            }
        }
        //leetcode 973


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap to store the k closest points
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.offer(point);

            // If the heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the result array to store the k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result; // Return the k closest points
    }
}

// Example usage:
// Solution sol = new Solution();
// int[][] closestPoints = sol.kClosest(new int[][]{{1, 3}, {-2, 2}, {5, 8}, {0,
// 1}}, 2);
// for (int[] point : closestPoints) {
// System.out.println("[" + point[0] + ", " + point[1] + "]");
// }



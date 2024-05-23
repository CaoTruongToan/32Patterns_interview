import java.util.*;
public class KSmallestPairs {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            result.add(new int[]{cur[0], cur[1]});

            if (cur[2] + 1 < nums2.length) {
                minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<int[]> result = kSmallestPairs(nums1, nums2, k);

        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}

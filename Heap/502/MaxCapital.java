import java.util.PriorityQueue;
import java.util.Arrays;

public class MaxCapital {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentCapital = w;
        int i = 0;

        for (int j = 0; j < k; j++) {
            while (i < n && projects[i][0] <= currentCapital) {
                maxProfitHeap.offer(projects[i][1]);
                i++;
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            currentCapital += maxProfitHeap.poll();
        }

        return currentCapital;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));  // Output should be 4
    }
}

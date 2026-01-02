import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 2054
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will
 * receive a value of valuei. You can choose at most two non-overlapping events to attend such that the
 * sum of their values is maximized.

 * Return this maximum sum.

 * Note that the start time and end time is inclusive: that is, you cannot attend two events where
 * one of them starts and the other ends at the same time. More specifically, if you attend an event
 * with end time t, the next event must start at or after t + 1.
 */
class TwoBestNonOverlappingEvents {

    public int maxTwoEventsSlowApproach(int[][] events) {
        HashMap<Integer, ArrayList<Integer>> mapper = new HashMap<>();
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i = 0; i < events.length; i++) {
            for(int j = i + 1; j < events.length; j++) {
                if (events[i][1] < events[j][0] ||
                        events[j][1] < events[i][0]) {
                    ArrayList<Integer> list = mapper.get(i);
                    if (list != null) {
                        list.add(events[j][2]);
                    }
                    else {
                        list = new ArrayList<>();
                        list.add(events[j][2]);
                    }
                    mapper.put(i, list);
                }
            }
            scores.add(events[i][2]);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mapper.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            for(int i = 0; i < value.size(); i++) {
                scores.add(events[key][2] + value.get(i));
            }
        }
        int max = -1;
        for (int i = 0; i < scores.size(); i++) {
            if (max < scores.get(i)) {
                max = scores.get(i);
            }
        }
        return max;
    }

    public int maxTwoEventsFastApproach(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);
    }

    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length) return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (events[mid][0] > end) hi = mid;
                else lo = mid + 1;
            }
            int include =
                    events[idx][2] +
                            (lo < events.length && events[lo][0] > end
                                    ? findEvents(events, lo, cnt + 1, dp)
                                    : 0);
            int exclude = findEvents(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents object = new TwoBestNonOverlappingEvents();
        int[][] events = {{1,3,2}, {4,5,2}, {2,4,3}};
        System.out.println("Slow approach: " + object.maxTwoEventsSlowApproach(events));
        System.out.println("Fast approach: " + object.maxTwoEventsFastApproach(events));
    }
}
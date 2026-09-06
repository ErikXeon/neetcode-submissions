/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(x -> x.start));
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        if(intervals.size() > 0) min_heap.add(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(min_heap.peek() > curr.start) {
                min_heap.add(curr.end);
            }
            else {
                min_heap.poll();
                min_heap.add(curr.end);
            }
        }
        return min_heap.size();

    }
}

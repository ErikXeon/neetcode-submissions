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
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            if(minheap.isEmpty()) minheap.add(end);
            else if(start < minheap.peek()) {
                minheap.add(end);
            }
            else{
                minheap.poll();
                minheap.add(end);
            }
        }
        return minheap.size();

    }
}
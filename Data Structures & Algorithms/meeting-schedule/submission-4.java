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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(x -> x.start));

        for(int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i - 1);
            if(prev.end > curr.start) {
                return false;
            }
        }
        return true;
    }
}


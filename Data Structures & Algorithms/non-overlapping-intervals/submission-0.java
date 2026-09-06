class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        int[] prev = intervals[0];
        int counter = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prev[1]) {
                counter++;
            }
            else {
                prev = intervals[i];
            }
        }
        return counter;
    }
}

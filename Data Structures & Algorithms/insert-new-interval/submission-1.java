class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean pasted = false;
        int[][] intervals2 = new int[intervals.length+1][];
        int j = 0;
        for(int[] curr : intervals) {
            int s = curr[0];
            if(pasted == false && s > newInterval[0]) {
                intervals2[j++] = newInterval;
                intervals2[j++] = curr;
                pasted = true;
            }
            else {
                intervals2[j++] = curr;
            }
        }
        if(pasted == false) intervals2[j] = newInterval;
        
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals2[0];

        for(int i = 1; i < intervals2.length; i++) {
            int[] curr = intervals2[i];
            if(prev[1] >= curr[0]) {
                prev = new int[]{prev[0], Math.max(prev[1], curr[1])};
            }
            else {
                merged.add(new int[]{prev[0], prev[1]});
                prev = curr;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean pasted = false;
        int j = 0;
        int[][] result = new int[intervals.length +1][2];
        for(int i = 0; i < intervals.length; i++) {
            if(!pasted && intervals[i][0] > newInterval[0]) {
                result[j++] = newInterval;
                result[j++] = intervals[i];
                pasted = true;
            }
            else {
                result[j++] = intervals[i];
            }
        }
        if(!pasted) result[j] = newInterval;

        List<int[]> res = new ArrayList<>();
        int[] prev = result[0];
        for(int i = 1; i < result.length; i++) {
            if(prev[1] >= result[i][0]) {
                prev[1] = Math.max(prev[1], result[i][1]);
            }
            else {
                res.add(prev);
                prev = result[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
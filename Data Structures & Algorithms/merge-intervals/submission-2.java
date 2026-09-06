class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]) {
                prev = new int[]{prev[0], Math.max(prev[1], curr[1])};
            }
            else{
                merged.add(new int[]{prev[0], prev[1]});
                prev = curr;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}



class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]); 
            }
            else {
                result.add(prev);
                prev = intervals[i];
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}



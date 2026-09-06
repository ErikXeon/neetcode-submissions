class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int[][] orig = new int[queries.length][];
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            orig[i] = new int[]{queries[i], i};
        }
        Arrays.sort(orig, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int j = 0;
        for(int[] pairs : orig) {
            int query = pairs[0];
            int idx = pairs[1];
            while(j < intervals.length && intervals[j][0] <= query) {
                min_heap.add(intervals[j]);
                j++;
            }
            if(min_heap.isEmpty()) {
                result[idx] = -1;
                continue;
            }
            while(!min_heap.isEmpty() && min_heap.peek()[1] < query) {
                min_heap.poll();    
            }
            if(min_heap.isEmpty()) {
                result[idx] = -1;
                continue;
            }
            int s = min_heap.peek()[0];
            int e = min_heap.peek()[1];
            int res = e - s + 1;
            result[idx] = res;
        }
        return result;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(n1,n2)->n1[0]-n2[0]);
        List<int[]> lst=new ArrayList<>();
        for (int i=0; i<intervals.length;++i) {
            int j=i;
            int max=intervals[i][1];
            while (j<intervals.length-1 && (intervals[j][1]>=intervals[j+1][0] || max>=intervals[j+1][0])) {max=Math.max(max,intervals[j][1]);j++;}
            int[] temp=new int[]{intervals[i][0],Math.max(max,intervals[j][1])};
            lst.add(temp);
            i=j;
        }
        /*int[][] ans=new int[lst.size()][2];
        int i=0;
        for (int[] a:lst) {
            ans[i]=a;
            i++;
        }
        
        return ans;*/
        return lst.toArray(new int[lst.size()][]);
    }
}

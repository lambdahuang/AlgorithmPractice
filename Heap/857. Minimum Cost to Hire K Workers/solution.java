class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][3];
        for(int i = 0; i < quality.length; i++)
        {
            workers[i][0]=quality[i];
            workers[i][1]=wage[i];
            workers[i][2]=(double)wage[i]/(double)quality[i];
        }
        Arrays.sort(workers, (double[] a, double[] b) -> (Double.compare(a[2],b[2])));
        //for(double[] worker: workers) System.out.println(worker[2]);
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(quality.length, (double[] a, double[] b) -> (int)(b[0]-a [0]));
        double minimum_wages = Double.MAX_VALUE;
        double current_total_quality = 0;
        for(double[] worker : workers)
        {
            pq.offer(worker);
            current_total_quality+=worker[0];
            if(pq.size() > K)
            {
                //System.out.println(worker[0] + " " +  current_total_quality  + " " + current_total_quality*worker[2]);
                current_total_quality-=pq.poll()[0];
                //System.out.println(worker[0] + " " +  current_total_quality  + " " + current_total_quality*worker[2]);
            }
            
            if(pq.size() == K)
                minimum_wages = Math.min(minimum_wages, current_total_quality*worker[2]);
        }
        //System.out.println("----");
        return minimum_wages;
    }
}

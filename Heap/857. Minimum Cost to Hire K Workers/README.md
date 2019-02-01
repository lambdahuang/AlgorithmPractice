[857. Minimum Cost to Hire K Workers](https://github.com/lambdahuang/AlgorithmPractice/tree/master/Heap/857.%20Minimum%20Cost%20to%20Hire%20K%20Workers)

# Greedy

The time complexity would be O(nlog(n)+n^2)

```
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int[][] qnw = new int[quality.length][2];
        for(int i = 0; i < quality.length; i ++) {qnw[i][0] = quality[i]; qnw[i][1] = wage[i];}
        Arrays.sort(qnw, (int[] a, int[] b) -> a[0] - b[0]);
        double minimum_wages = Double.MAX_VALUE;
        for(int i = 0; i < qnw.length; i ++)
        {
            double tmp_wages = (double)qnw[i][1];
            int selected = 0;
            double rate = (double)qnw[i][1] / (double)qnw[i][0];
            for(int j = 0; j < qnw.length && selected < K-1; j++)
            {
                double paying = rate * (double)qnw[j][0];
                if(j != i && paying >= (double)qnw[j][1])
                {
                    selected++;
                    tmp_wages+=paying;
                }
            }
            if(selected == K-1)
                minimum_wages=Math.min(tmp_wages, minimum_wages);
            //System.out.println(i + " " + qnw[i][0] + " " + qnw[i][1] + " " + tmp_wages);
        }
        //System.out.println("----");
        return minimum_wages;
    }
}
```


# Heap

This is best practice to show functionality of heap over the sorting.

Heap can help you maintain an component of a certain size, which can be viewed as an state of anything.

On the contrary, sorting won't bring you such thing because the sorting is done in an instant there won't be any state being maintained. 

```
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
```

2019.2.1

```
class Solution {
    public class Employee{
        public int quality = 0;
        public int wage = 0;
        public double wpq = 0.0;
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Employee[] e = new Employee[quality.length];
        for(int i = 0; i < quality.length; i ++) 
        {
            e[i] = new Employee();
            e[i].quality = quality[i];
            e[i].wage = wage[i];
            e[i].wpq = (double)wage[i] / quality[i];
        }
        Arrays.sort(e, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                if (((Double) o2.wpq).compareTo(o1.wpq) != 0)
                    return ((Double) o1.wpq).compareTo(o2.wpq);
                else 
                    return ((Integer) o2.quality).compareTo(o1.quality);
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int total_quality = 0;
        double ret = Double.MAX_VALUE;
        for(int i = 0; i < quality.length; i ++)
        {
            System.out.println(e[i].wpq);
            pq.offer(e[i].quality);
            total_quality += e[i].quality;
            if(pq.size() > K)
            {
                total_quality -= pq.poll();
            }
            if(pq.size() == K)
            {
                ret = Math.min(ret, total_quality * e[i].wpq);
            }

        }
        return ret;
      }
}
```

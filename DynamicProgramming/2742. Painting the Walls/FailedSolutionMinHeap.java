class FailedSolutionMinHeap {
    public int paintWalls(int[] cost, int[] time) {
        

        // you don't care how long it takes, really, we minimize cost
        // occupy the paid painter on the cheap, and consume as many other expensive walls as possible with the free guy

        // sort them by the longest time
        // occupy the paid guy with the cheapest, longest
        
        // maximum number of ticks for the lowest cost
        // for each tick count, 1 2 3 4, what's the lowest cost I can get away with?

        // create int[][], sort by time asc, then cost asc

        // int ticks = Math.ceil(cost.length / 2.0f);
        int ticks = (int) Math.ceil((double)cost.length / 2);
        
        // smallest cost sum of times summing to >= ticks
        
        // map of sum ticks to sum cost
        
        // sum all the ticks
        // if sum ticks larger than target, find ticks that qualify, take out tick with greatest cost

        PriorityQueue<Load> minHeap = new PriorityQueue<>(Comparator.comparing(Load::getLoad));
        for (int i = 0; i < cost.length; i++) {
            minHeap.add(new Load(i, cost[i], time[i], cost[i]/time[i]));
        }

        int c = 0;
        int t = 0; // walls free painter painted in time paid painter was working
        int w = 0; // walls paid painter has painted
        while (true) {
            Load l = minHeap.remove();
            //System.out.println("t=" + t + ", Pulled off load=" + l.toString());
            if (t+w < cost.length) {
                //System.out.println("Time t=" + t + ", and l.time=" + l.time + " is less than ticks=" + ticks);
                t+=l.time;
                c+=l.cost;
                w++;
            } else {
                break;
            }
        }
        return c;
    }

    public class Load {
        public int i;
        public int cost;
        public int time;
        public double load;

        public Load(int i, int cost, int time, double load) {
            this.i=i;
            this.cost=cost;
            this.time=time;
            this.load=load;
        }
        public double getLoad() {
            return this.load;
        }
        public String toString() {
            return "i=" + i + ", " +
            "cost=" + cost + ", " +
            "time=" + time + ", " +
            "load=" + load;
        }
    }
}

/*
 * Learned:
 * - Refresher: Arrays.sort operates on the provided array, and returns void.
 * - Refresher: Comparator.comparingInt convenient comparator, default is decrementing
 * - Refresher: new PriorityQueue<Integer>() is a min heap, where default constructor is min
 * - Refresher: PriorityQueue uses add/remove, not push/pop (which are for Stack)
 */
class SortedMinHeap {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);

        // sort flowers
        Arrays.sort(flowers, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // default is min
        Map<Integer, Integer> personSeenCount = new HashMap<>();
        int f = 0;

        for (int arrivedAt : sortedPeople) {

            // for all the flowers with start time before person, add to heap
            while (f < flowers.length && flowers[f][0] <= arrivedAt) {
                minHeap.add(flowers[f][1]); // end times
                f++; // next flower
            }

            // remove flowers done blooming before person p got there
            while (!minHeap.isEmpty() && minHeap.peek() < arrivedAt) {
                minHeap.remove();
            }

            int seen = minHeap.size();
            personSeenCount.put(arrivedAt, seen);
        }

        int[] res = new int[people.length];
        for (int person = 0; person < people.length; person++) {
            int personArrived = people[person];
            res[person] = personSeenCount.get(personArrived);
        }

        return res;
    }
}

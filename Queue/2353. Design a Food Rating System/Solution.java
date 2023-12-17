/**
 * Learned:
 *   - Updating the field of an object in a PriorityQueue obviously dosn't reorder the queue.
 *   - Instead, PriorityQueue::add will put the new element in the correctly ordered spot
 *   - So then we have to discard duplicates (Foods with previous ratings) using a source-of-rating-truth map: foodRating
 */
class FoodRatings {
    private class Food{
        public String name;
        public int val;
        Food(String name, int rating) {
            this.name = name;
            val = rating;
        }
        public int getVal() {
            return this.val;
        }
        public String getName() {
            return this.name;
        }
        public String toString() {
            return "Food: name=" + this.name + ", rating=" + this.val;
        }
    }

    public Map<String, PriorityQueue<Food>> dict;
    public Map<String, String> foodC;
    public Map<String, Integer> foodRating;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        dict = new HashMap<>();
        foodC = new HashMap<>();
        foodRating = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            PriorityQueue<Food> q = dict.getOrDefault(cuisine, new PriorityQueue<>(Comparator.comparingInt(Food::getVal).reversed().thenComparing(Food::getName)));
            // SortedSet<Food> foodsSet = dict.getOrDefault(cuisine, new TreeSet<>(Comparator.comparingInt(Food::getVal).reversed().thenComparing(Food::getName)));
            q.add(new Food(food, rating));
            dict.put(cuisine, q);

            foodC.put(food, cuisine);
            foodRating.put(food, rating);
        }
        // System.out.println(dict);
        // System.out.println(foodC);
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodC.get(food);
        PriorityQueue<Food> foods = dict.get(cuisine);
        foods.add(new Food(food, newRating));
        foodRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> foods = dict.get(cuisine);
        Food highest = foods.peek();
        while (foodRating.get(highest.name) != highest.val) {
            foods.poll(); // discard duplicate with outdated rating
            highest = foods.peek();
        }
        // System.out.println("highestRated cuisine: " + cuisine);
        // System.out.println(foods);
        return highest.getName();

    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

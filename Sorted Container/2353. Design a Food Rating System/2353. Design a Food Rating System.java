class FoodRatings {
    // class CusineData {
    //     int rate;
    //     String food;
    //     public void CusinData(int rate, String f) {
    //         this.rate = rate;
    //         this.food = f;
    //     }
    // }

    //Comparator<CusineData> cuisineComparator;
    // map -> priorityqueue: cuise -> rate + food name
    // map: food -> cuisine and rate
    // 2nd map: cuisine -> rate order map(rate + food order set)
    Map<String, String> food2cusine;
    Map<String, Integer> food2rate;
    Map<String, TreeMap<Integer, TreeSet<String>>> cuisine2rate;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         cuisineComparator = (c1, c2) -> {
//     // 1. Compare rates (Descending - typical for ratings)
//     if (c1.rate != c2.rate) {
//         return Integer.compare(c2.rate, c1.rate); 
//     }
//     // 2. Tie-breaker: Compare food names (Alphabetical/Natural order)
//     return c1.food.compareTo(c2.food);
// };
        food2cusine = new HashMap<>();
        food2rate = new HashMap<>();
        cuisine2rate = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];
            food2cusine.put(f, c);
            food2rate.put(f, r);
            cuisine2rate.computeIfAbsent(c, k -> new TreeMap<>(Collections.reverseOrder()))
                .computeIfAbsent(r, k -> new TreeSet<>()).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String c = food2cusine.get(food);
        int oldR = food2rate.get(food);
        food2rate.put(food, newRating);
        if (newRating == oldR) return;
        // get oldR and remove it 
        TreeMap<Integer, TreeSet<String>> r2f = cuisine2rate.get(c);
        TreeSet<String> of = r2f.get(oldR);
        of.remove(food);
        if (of.isEmpty() || of.size() == 0) {
            r2f.remove(oldR);
        }
        r2f.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> r2f = cuisine2rate.get(cuisine);
        int key = r2f.firstKey();
        return r2f.get(key).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

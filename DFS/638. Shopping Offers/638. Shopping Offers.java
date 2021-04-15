class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return backTrace(price, special, needs, 0);
    }
    private int backTrace(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
  int res = directPurchase(price, needs);
  for (int i = start; i < special.size(); i++) {
    List<Integer> offer = special.get(i);
    if (isValid(offer, needs)) {                    // offer is a valid one
      List<Integer> tempNeeds = new ArrayList<Integer>();
      for (int j = 0; j < needs.size(); j++) {      // using this valid offer
        tempNeeds.add(needs.get(j) - offer.get(j));
      }
      res = Math.min(res, offer.get(offer.size()-1) + backTrace(price, special, tempNeeds, i));
    }
  }
  return res;
}

private boolean isValid(List<Integer> offer, List<Integer> needs) {
  for (int i = 0; i < needs.size(); i++) {
    if (needs.get(i) < offer.get(i)) return false;
  }
  return true;
}
    private int directPurchase(List<Integer> price, List<Integer> needs) {
  int total = 0;
  for (int i = 0; i < needs.size(); i++) {
    total += price.get(i) * needs.get(i);
  }
  return total;
}
}

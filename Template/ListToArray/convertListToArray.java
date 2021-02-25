class Solution {
    public int[] covertIntegerArray(List<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }
}

class Solution {
    public int[] covertIntegerArray(List<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }
    public String[] covertStirngArray(List<String> list) {
        return list.stream().toArray(n -> new String[n]); // list.stream ().toArray (String[]::new);
    }
}

class ProductOfNumbers {
    // preprduct
    List<Integer> preproduct;
    int lastzero;
    int idx;
    public ProductOfNumbers() {
        preproduct = new ArrayList<>();
        preproduct.add(1);
        lastzero = -1;
        idx = 0;
    }
    
    public void add(int num) {
        idx++;
        if (num == 0) {
            preproduct.add(1);
            lastzero = idx;
        } else preproduct.add(preproduct.get(preproduct.size()-1)*num);
    }
    
    public int getProduct(int k) {
        // get range
        if (lastzero > idx-k && lastzero <= idx) return 0;
        else {
            return preproduct.get(idx)/ preproduct.get(idx-k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

//    2,3, 4, 5,  6
// pm:2 6 24 120 720
// p[i...j] = pre[i]/pre[j] pre[0]= 1
//  2 3 [4 0 5] 6 7 : lastzero
//  2 6 24 1 5 30 210
//  2 3 4 0 [5 6 7] : lastzero

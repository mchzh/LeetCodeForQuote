class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // double pointer
        int lena = A.length, lenb = B.length;
        int first = 0, second = 0;
        List<int[]> middle = new ArrayList<>();
        while (first < lena || second < lenb) {
            if (first < lena && second < lenb) {
                
                // no intersection
                if (A[first][1] < B[second][0]) {
                    //middle.add(A[first]);
                    first++;
                } else if (B[second][1] < A[first][0]) {
                    //middle.add(B[second]);
                    second++;
                } else { // intersection
                    int[] temp = new int[2];
                    temp[0] = Math.max(A[first][0], B[second][0]);
                    temp[1] = Math.min(A[first][1], B[second][1]);
                    middle.add(temp);
                    if (A[first][1] <= B[second][1]) {
                        first++;
                    } else {
                        second++;
                    }
                }
            } else if (first < lena) {
                //middle.add(A[first]);
                first++;
            } else {
                //middle.add(B[second]);
                second++;
            }
        }
                                            
        // convert list to int array with stream
        int[][] res = new int[middle.size()][2];
        for (int i = 0; i < middle.size(); i++) {
            res[i] = middle.get(i);
        }
        return res;
    }
}

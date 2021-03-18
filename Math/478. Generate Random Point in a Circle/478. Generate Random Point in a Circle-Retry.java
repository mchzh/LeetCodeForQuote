class Solution {
    Random rand;
    double R;
    double x0;
    double y0;
    public Solution(double radius, double x_center, double y_center) {
        rand = new Random();
        R = radius;
        x0 = x_center;
        y0 = y_center;
    }
    
    public double[] randPoint() {
        double r1 = rand.nextDouble();
        double x = x0+r1*2*R-R;
        double r2 = rand.nextDouble();
        double y = y0+r2*2*R-R;
        
        if ( (x-x0)*(x-x0)+(y-y0)*(y-y0)<=R*R ) return new double[] {x, y};
        else return randPoint();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */

// rand10() -> rand7();
// [1,2,3,4,5,6,7,8,9,10]
// [1,2,3,4,5,6,7]
// inside -> directly return; outside -> retry

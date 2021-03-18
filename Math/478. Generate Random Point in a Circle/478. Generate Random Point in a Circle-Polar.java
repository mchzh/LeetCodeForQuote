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
        double pi = 3.1415926;
        double r1 = rand.nextDouble();
        double theatra = 2*pi*r1;
        double t = rand.nextDouble();
        double r = R*Math.sqrt(t);
        double x = x0+r*Math.sin(theatra);
        double y = y0+r*Math.cos(theatra);
        
        return new double[] {x, y};
    }
}

// polar coordinates
// (r, therta)
// S = r*r*delta
// [0, R*R*therta)
// t -> [0, 1]
// t*R*R*delta = S = r*r*delta
// r = R*sqrt(t)

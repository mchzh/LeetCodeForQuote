class Solution {
    public double getMinDistSum(int[][] positions) {
        int n = positions.length;
        double[][] points = new double[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = positions[i][0]*1.0;
            points[i][1] = positions[i][1]*1.0;
        }
        
        // meeting point
        double[] curp = {0.0, 0.0};
        for (double[] p : points) {
            curp[0] += p[0];
            curp[1] += p[1];
        }
        curp[0] /= n;
        curp[1] /= n;
        
        // appoximate
        for (double step = 10.0; step >1e-6;) {
            boolean found = false;
            double[][] attempts = {{curp[0]+step, curp[1]},
                                   {curp[0]-step, curp[1]},
                                   {curp[0], curp[1]+step},
                                   {curp[0], curp[1]-step}};
            for (double[] a : attempts) {
                if (getDis(points, a) < getDis(points, curp)) {
                    curp[0] = a[0];
                    curp[1] = a[1];
                    found = true;
                    break;
                }
            }
            // only if not found we decrease step
            if (!found) {
                step /= 2;
            }
        }
        return getDis(points, curp);
    }
    private double getDis(double[][] points, double[] curp) {
        double sum = 0.0;
        
        for(int i = 0; i < points.length; i++){
            sum += Math.sqrt(Math.pow(points[i][0]-curp[0], 2.0)+Math.pow(points[i][1]-curp[1], 2.0));
        }
        
        return sum;
    }
}

// [x.  x      ]
// [
// [x. x  x x x] 
// [  x x x x  ]
    
// get the max boundary

// *          *
      
//       *    
    
// *          *
// find mid point and initial jump length
// four vertex points

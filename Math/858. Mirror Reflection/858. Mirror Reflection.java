class Solution {
    // https://www.cnblogs.com/grandyang/p/10646040.html
    public int mirrorReflection(int p, int q) {
        if (q == 0) return 0;
        if (q == p) return 1;
        while (p%2 == 0 && q%2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p%2 == 0) return 2;
        if (q%2 == 0) return 0;
        return 1;
    }
}

/*class Solution {
    public int mirrorReflection(int p, int q){
        // m*p=n*q
        // if n is even, then it's 2
        // else if m is odd, then it;s 1
        // else it's 0
        
        int m=1, n=1;
        while(m*p!=n*q){
            n++;
            m=(n*q)/p;
        }
        
        if(n%2==0) return 2;
        else if(m%2==1) return 1;
        else return 0;
        
    }    
    
    
    
//     double EPS = 1e-6;

//     public int mirrorReflection(int p, int q) {
//         double x = 0, y = 0;
//         double rx = p, ry = q;    

//         // While it hasn't reached a receptor,...
//         while (!( close(x, p) && (close(y, 0) || close(y, p))
//                   || close(x, 0) && close (y, p) )) {
//             // Want smallest t so that some x + rx, y + ry is 0 or p
//             // x + rxt = 0, then t = -x/rx etc.
//             double t = 1e9;
//             if ((-x / rx) > EPS) t = Math.min(t, -x / rx);
//             if ((-y / ry) > EPS) t = Math.min(t, -y / ry);
//             if (((p-x) / rx) > EPS) t = Math.min(t, (p-x) / rx);
//             if (((p-y) / ry) > EPS) t = Math.min(t, (p-y) / ry);

//             x += rx * t;
//             y += ry * t;

//             if (close(x, p) || close(x, 0)) rx *= -1;
//             if (close(y, p) || close(y, 0)) ry *= -1;
//         }

//         if (close(x, p) && close(y, p)) return 1;
//         return close(x, p) ? 0 : 2;
//     }

//     public boolean close(double x, double y) {
//         return Math.abs(x - y) < EPS;
//     }
    
    
//     public int mirrorReflection(int p, int q){
//         // find m*p=n*q
//         // if n==even, return 2
//         // else if m==odd return 1 else return 0
        
//         int m=1,n=1;
//         while(m*p!=n*q){
//             n++;
//             m=n*q/p;
//         }
        
//         if(n%2==0) return 2;
//         else if(m%2==1) return 1;
//         else return 0;
        
        
        
        
//     }
//}

public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

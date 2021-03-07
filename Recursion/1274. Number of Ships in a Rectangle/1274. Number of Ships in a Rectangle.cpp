class Solution {
public:
    int countShips(Sea sea, vector<int> topRight, vector<int> bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        int x1 = bottomLeft[0], x2 = topRight[0];
        int y1 = bottomLeft[1], y2 = topRight[1];
        
        if (x1 == x2 && y1 == y2) return 1;
        int x3 = (x1+x2)/2, y3 = (y1+y2)/2;
        int a = 0, b = 0, c = 0, d = 0;
        
        if (x3 >= x1 && y3 >= y1) 
            a = countShips(sea, {x3, y3}, bottomLeft);
        
        if (x2 >= x3+1 && y3 >= y1)
            b = countShips(sea, {x2, y3}, {x3+1, y1});
        
        if (x3 >= x1 && y2 >= y3+1)
            c = countShips(sea, {x3, y2}, {x1, y3+1});
        
        if (x2 >= x3+1 && y2 >= y3+1)
            d = countShips(sea, topRight, {x3+1, y3+1});
        
        return a+b+c+d;
    }
};

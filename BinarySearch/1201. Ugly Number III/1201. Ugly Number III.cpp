typedef long long ll;
class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        ll left = 1, right = INT_MAX;
        while (left < right) {
            ll mid = left + (right-left)/2;
            if (count(mid, a, b, c) < n) {
                left = mid+1;
            } else right = mid;
        }
        return (int)left;
    }
    ll count(ll m, ll a, ll b, ll c) {
        return m/a + m/b + m/c - m/lcm(a, b) - m/lcm(b, c) - m/lcm(a, c) + m/lcm(a, lcm(b,c));
    }
    ll lcm(ll a, ll b) {
        return a*b/gcd(a,b);
    }
    ll gcd(ll a, ll b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
};

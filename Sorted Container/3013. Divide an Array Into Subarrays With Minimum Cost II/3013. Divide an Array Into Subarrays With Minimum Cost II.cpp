using LL = long long;
// https://chatgpt.com/s/t_6981260c4a0481919ed5f43625316c8b
class Solution {
public:
// find the k-1 element(divide as k-1 subarray) sum inside silde window which has the dist+1 size
    long long minimumCost(vector<int>& nums, int k, int dist) {
        // int n = nums.size();
        // multiset<int> Set1;
        // multiset<int> Set2;

        // LL sum = 0;
        // LL rets = LLONG_MAX;
        // k--;
        // for (int i = 1; i < n; i++) {
        //     int a = nums[i];
        //     // add new element
        //     if (Set1.size() < k) {
        //         Set1.insert(a);
        //         sum += a;
        //     } else if (*Set1.rbegin() <= a) {
        //         Set2.insert(a);
        //     } else {
        //         // a need into set1 
        //         // remove the last one from set1 to set2
        //         sum -= *Set1.rbegin();
        //         sum += a;
        //         Set2.insert(*Set1.rbegin());
        //         Set1.erase(prev(Set1.end()));
        //         Set1.insert(a);
        //     }

        //     // window need to remove the leftmost element
        //     if (i >= dist+1) {
        //         rets = min(rets, sum);
        //         // t in set1 or set2
        //         int t = nums[i-dist];
        //         // in set2 directly delete : not in set2 then in set1
                // if (Set2.find(t) != Set2.end()) {
                //     Set2.erase(Set2.find(t));
                // } else {
                //     sum -= t;
                //     Set1.erase(Set1.find(t));
                //     // set2 is not empty and set2 first element into set1
                //     if (!Set2.empty()) {
                //         Set1.insert(*Set2.begin());
                //         sum += *Set2.begin();
                //         Set2.erase(*Set2.begin());
                //     }
                    
        //         }
        //     }
        // }

        // return rets + nums[0];

        int n = nums.size();
        
        multiset<int>Set1;
        multiset<int>Set2;
        
        LL sum = 0;
        LL ret = LLONG_MAX;
        
        k--;
        
        for (int i=1; i<n; i++)
        {        
            // if (Set1.size() < k)
            // {
            //     Set1.insert(nums[i]);
            //     sum += nums[i];
            // }                
            // else if (*Set1.rbegin() <= nums[i])
            //     Set2.insert(nums[i]);
            // else
            // {
            //     sum -= *Set1.rbegin();
            //     sum += nums[i];
            //     Set2.insert(*Set1.rbegin());
                
            //     Set1.erase(prev(Set1.end()));
            //     Set1.insert(nums[i]);
                
            // }
            int a = nums[i];
            // add new element
            if (Set1.size() < k) {
                Set1.insert(a);
                sum += a;
            } else if (*Set1.rbegin() <= a) {
                Set2.insert(a);
            } else {
                // a need into set1 
                // remove the last one from set1 to set2
                sum -= *Set1.rbegin();
                sum += a;
                Set2.insert(*Set1.rbegin());
                Set1.erase(prev(Set1.end()));
                Set1.insert(a);
            }
            
            if (i>=dist+1)
            {
                ret = min(ret, sum);
                
                int t = nums[i-dist];
                if (Set2.find(t) != Set2.end()) {
                    Set2.erase(Set2.find(t));
                } else {
                    Set1.erase(Set1.find(t));
                    sum -= t;
                    // set2 is not empty and set2 first element into set1
                    if (!Set2.empty()) {
                        Set1.insert(*Set2.begin());
                        sum += *Set2.begin();
                        Set2.erase(Set2.begin()); // erase by value or by iterator difference
                    }
                }
                // if (Set2.find(t)!=Set2.end())
                //     Set2.erase(Set2.find(t));
                // else
                // {
                //     Set1.erase(Set1.find(t));
                //     sum -= t;
                //     if (!Set2.empty()) 
                //     {
                //         Set1.insert(*Set2.begin());
                //         sum += *Set2.begin();
                //         Set2.erase(Set2.begin());                    
                //     }
                // }
            }
        }
        
        return ret + nums[0];
    }
};

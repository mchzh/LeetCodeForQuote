class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char,int>Map;
        for (auto ch: tasks)
            Map[ch]++;
        priority_queue<int>pq;
        for (auto a:Map) pq.push(a.second);
        
        n++;
        int count = 0;
        while (pq.size()>0)
        {                            
            int k = min(n, (int)pq.size());            
            
            vector<int>temp;
            for (int i=0; i<k; i++)
            {
                int a = pq.top();
                pq.pop();
                a--;
                if (a!=0) temp.push_back(a);
            }
            if (temp.size()>0)
                count+=n;
            else
                count+=k;
            
            for (auto x: temp)
                pq.push(x);
        }
        return count;        
//         unordered_map<char, int>Map;
//         for (auto ch : tasks) {
//             Map[ch]++;
//         }
//         priority_queue<int>pq;
//         for (auto a : Map) pq.push(a.second);
            
//         n++;
//         int count = 0;
//         while (pq.size() > 0) {
            
//             int k = min(n, (int)pq.size());
//             vector<char>temp;
//             for (int i = 0; i < k; i++) {
//                 int cur = pq.top();
//                 pq.pop();
//                 cur--;
//                 if (cur != 0) temp.push_back(cur);
//             } 
//             for (auto t : temp) pq.push(t);
//             // get the tash num of curr round
//             if (pq.size() != 0) count += n;
//             else count += k;
            
            
//         }
//         return count;
    }
};

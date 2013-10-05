class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        unordered_map<int,bool> hmap;
        for(int &val:num)
        {
            if(hmap.count(val)==0)
            {
                hmap[val] = false;
            }
        }
        
        
        int N = num.size();
        int max = 0;
       
        for(int i = 0; i < N; i++)
        {
           
            int val = num[i];
            if(hmap[val]==false)
            {
                int count = 1;
                int up = val+1;
                while(hmap.count(up))
                {
                    hmap[up] = true;
                    count++;
                    up++;
                }
                
                int down = val-1;
                while(hmap.count(down))
                {
                    hmap[down] = true;
                    count++;
                    down--;
                }
                
                max = count>max?count:max; 
            }
        }
        
        return max;
    }
};
class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        unordered_set<string> checkmap;
        list<string> layer;
        checkmap.insert(start);
        layer.push_back(start);
        string layerend = start;
        
        if(start == end)
        {
            return 1;
        }
        
        if(start.size()!=end.size())
        {
            return 0;
        }
        
        int step = 1;
        string last;
        while(!layer.empty())
        {
          
            string s = layer.front();
            layer.pop_front();
            int L = s.size();
            for(int i = 0; i< L; i++)
            {
                string temp = s;
                for(int j = 0; j < 26; j++)
                {
                    temp[i] = j+'a';
                    if(temp==end)
                    {
                        return step+1;
                    }
                    if(checkmap.count(temp)==0&&dict.count(temp))
                    {
                        checkmap.insert(temp);
                        layer.push_back(temp);
                        last = temp;
                    }
                }
            }
            
            if(s == layerend)
            {
                step++;
                layerend = last;
            }
        }
        
        return 0;
    }
};
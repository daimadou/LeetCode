class Solution {
public:
    vector<vector<string>> partition(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<bool>> part(s.size(), vector<bool>(s.size(),false));
        
        const int len = s.size();
        int i = 0;
        for(i = len-1; i > -1; i--)
        {
            int j = 0;
            for(j = i; j<len; j++)
            {
                part[i][j] = (((j-i<2)||(part[i+1][j-1]))&&(s[i]==s[j]))?true:false;
            }
        }
        
        vector<vector<string>> resultList;
        vector<string> result;
         
        buildList(s, 0,  part,  resultList, result);
        return resultList;
    }
    
    void buildList(string s, int index,  vector<vector<bool> > &part,  vector<vector<string> > &resultList, vector<string> &result) {
        if(index == s.size())
        {
            resultList.push_back(result);
            return; 
        }
        else{
            const int len = s.size();
            for(int i = index; i < len; i++)
            {
                if(part[index][i])
                {
                    result.push_back(s.substr(index, i-index+1));
                    buildList(s, i+1, part, resultList, result);
                    result.pop_back();
                }
                
            }
            
        }
    }
    
};
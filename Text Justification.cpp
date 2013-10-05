class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> result;
        if(words.empty())
            return result;
        
        int wordLen = 0;
        int start = 0;
        int Len = 0;
        for(int i = 0; i< words.size();i++)
        {
            
            wordLen += words[i].size()+1;
            Len += words[i].size();
            if(wordLen>=L+1)
            {
                if(wordLen==L+1)
                    wordLen--;
                else
                {
                    Len =  Len-words[i].size();
                    i--;
                }
                insertResult(start, i, Len, false, L, words, result);
                start = i+1;
                wordLen = 0;
                Len = 0;
            }
        }
        
        if(wordLen>0)
        {
            insertResult(start, words.size() - 1, Len, true, L, words, result);
        }
        return result;
    }
    
    void insertResult(int start, int end, int wordLen, bool isLastLine, int L, vector<string> &words, vector<string> &result)
    {
        int size = end - start + 1;    
     //   int spaceLen = L - wordLen;
        int numspace = size>1?size-1:1;
        int spaceLen =isLastLine? numspace : L - wordLen;
        int eachSpaceLen = spaceLen/numspace;
        int extraspace = spaceLen%numspace;
        
        string ret;
        for(int i = start; i<=end; i++)
        {
            ret += words[i];
            if(i-start<numspace)
            {
                ret.append(eachSpaceLen, ' ');
            }
            if(i-start<extraspace)
            {
                ret.append(" ");
            }
        }
        if(isLastLine)
            ret.append(L-ret.size(), ' ');
        
        result.push_back(ret);
        
    }
};

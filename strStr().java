class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(needle==NULL)
        {
            return haystack;
        }
        int haystackLen = strlen(haystack);
        int needleLen = strlen(needle);
        for(int i = 0; i < haystackLen - needleLen + 1; i++)
        {
            int j = 0;
            int offset = i;
            while(j < needleLen && needle[j] == haystack[offset])
            {
                j++;
                offset++;
            }
            
            if(j == needleLen)
            {
                return haystack + i;
            }
        }
        return NULL;
    }
};
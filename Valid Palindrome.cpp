class Solution {
public:

    bool processingLetters(char &c)
    {
        if(c>='A'&&c<='Z')
        {
            c = tolower(c);
            return true; 
        }
        else if((c>='a'&&c<='z')||isdigit(c))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    bool isPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int start = 0;
        int end  = s.size()-1;
        bool flag = true;
        while(start<end)
        {
            if(!processingLetters(s[start]))
                start++;
            else if(!processingLetters(s[end]))
                end--;
            else
            {
                if(s[start]!=s[end])
                {
                    flag = false;
                    break;
                }
                else
                {
                    start++;
                    end--;
                }
            }
                
        }
        
        return flag;
    }
};

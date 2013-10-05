class Solution {
public:
    vector<string> result;
    vector<string> restoreIpAddresses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        result.clear();
        int n = s.size();
        string IP;
        buildIPList(s, 4, IP);
        return result;
    }
    
    void buildIPList(string s, int remainingParts, string IP)
    {
        int n = s.size();
        if(n < remainingParts|| n > 3*remainingParts)
        {
            return;
        }
   
        if(n==0&&remainingParts==0)
        {
            int l = IP.size();
            IP = IP.substr(0, l-1);
            result.push_back(IP);
        }
        int num = 0;
        int len = min(3, n);
        for(int i = 0; i<len; i++)
        {
            num  = num*10 + (s[i]-'0');
            if(num <= 255)
            {
                IP =IP + s[i];
                buildIPList(s.substr(i+1), remainingParts-1, IP+'.');
            }
            if(num==0)
                break;
        }
        
    }
};
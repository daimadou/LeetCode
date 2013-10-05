public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []sChars = Arrays.copyOf(s.toCharArray(), s.length()+1);
        char []pChars = Arrays.copyOf(p.toCharArray(), p.length()+1);
        sChars[s.length()] = '\0';
        pChars[p.length()] = '\0';
        return isMatch(sChars, 0, pChars, 0);
    }
    
    public boolean isMatch(char[] s, int i, char[] p, int j) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p[j]=='\0')
        {
            return s[i] == '\0';
        }
        
        if(p[j+1] != '*')
        {
            return (p[j]==s[i]|| (p[j]=='.' && s[i]!='\0'))? isMatch(s, i + 1, p, j + 1): false;
        }
        else
        {
            while(s[i] == p[j] ||(p[j]=='.' && s[i] != '\0'))
            {
                if(isMatch(s, i, p, j+2))
                {
                    return true;
                }
                else
                {
                    i++;
                }
            }
            return isMatch(s, i, p, j+2);
        }
    }
}
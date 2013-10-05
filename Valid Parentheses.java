public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> pStack = new Stack<Character>();
        boolean ret = true;
        for(char c:s.toCharArray())
        {
            if(c=='('||c=='{'||c=='[')
            {
                pStack.push(c);
            }
            else
            {
                if(!pStack.isEmpty())
                {
                    char p = pStack.pop();
                    if((p == '(' && c!=')')||(p == '[' && c!=']')||(p == '{' && c!='}'))
                    {
                        ret = false;
                        break;
                    }
                }
                else
                {
                    ret = false;
                    break;
                }
            }
        }
        return ret && pStack.isEmpty();
    }
}
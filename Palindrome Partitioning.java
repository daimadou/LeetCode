    private ArrayList<ArrayList<String>> allRets;
    private boolean [][]dp;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        allRets = new ArrayList<ArrayList<String>>();
        ArrayList<String> ret = new ArrayList<String>();
        dp = buildPalidrome(s);
        partitionHelper(ret, 0, s); 
        return allRets;
        
    }
    
    private boolean [][]buildPalidrome(String s)
    {
        int len = s.length(); 
        boolean [][]palidrome = new boolean[len][len];
        for(int i = len-1; i > -1; i--)
        {
            for(int j=i; j < len; j++)
            {
                palidrome[i][j] = ((j-i < 2)||palidrome[i+1][j-1])&&(s.charAt(i)==s.charAt(j))?true:false;
            }
        }
        
        return palidrome;
    }
    
    void partitionHelper(ArrayList<String> ret, int index, String s)
    {
        if(index==s.length())
        { 
            ArrayList<String> tempRet= (ArrayList<String>)ret.clone(); 
            allRets.add(tempRet);
        }
        else
        {
            for(int i = index; i < s.length(); i++)
            {
                if(dp[index][i])
                {
                    ret.add(s.substring(index, i+1));
                    partitionHelper(ret, i+1, s);
                    int lastIndex = ret.size()-1;
                    ret.remove(lastIndex);
                }
            }
        }
    }
    
    
}
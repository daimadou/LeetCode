public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        restoreIp(ret, "", s, 4);
        return ret;
    }

    private void restoreIp(ArrayList<String> ret, String Ip, String s, int remainParts)
    {
    	if(s.length() < remainParts || s.length() > 3*remainParts)
    	{
    		return;
    	}
    	
    	if(s.length()==0)
    	{
    		int lastIndex = Ip.length() - 1;
    		ret.add(Ip.substring(0, lastIndex));
    		return;
    	}
    	int num = 0;
    	for(int i = 0; i < Math.min(3, s.length()); i++)
    	{
    		num = num*10 + (s.charAt(i) - '0');
    		if(num <= 255)
    		{ 
    			Ip += s.charAt(i);
    			restoreIp(ret, Ip+".", s.substring(i+1), remainParts - 1);
    		}
    		if(num == 0)
    		{
    			break;
    		}
    	}

    }
}
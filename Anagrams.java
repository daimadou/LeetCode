public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        HashMap<String, LinkedList<String>> keyMap = new HashMap<String, LinkedList<String>>();
        for(String s: strs)
        {
            char []keyChars = s.toCharArray();
            Arrays.sort(keyChars);
            int val = 0;
            String keyStr = new String(keyChars);
            if(keyMap.containsKey(keyStr))
            {
                keyMap.get(keyStr).add(s);
            }
            else
            {
                LinkedList<String> strList = new LinkedList<String>();
                strList.add(s);
                keyMap.put(keyStr, strList);   
            }
        }
        
        for(String key: keyMap.keySet())
        {
            LinkedList<String> strList = keyMap.get(key);
            if(strList.size() > 1)
            {
                for(String s: strList)
                {
                    ret.add(s);
                }
            }
        }
        return ret;
    }
}b
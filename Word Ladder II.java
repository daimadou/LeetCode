public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        HashMap<String, Integer> layer = new HashMap<String, Integer>();
        HashMap<String, HashSet<String>> parentsMap = new HashMap<String, HashSet<String>>();
        HashSet<String> parents = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        int minLayers = Integer.MAX_VALUE; 
        parentsMap.put(start, parents);
        layer.put(start, 0);
        q.offer(start);
        while(!q.isEmpty())
        {
            String curStr = q.poll();
            char []chars = curStr.toCharArray();
            int len = chars.length;
            for(int i=0; i < len; i++)
            {
                char old = chars[i];
                for(char c = 'a'; c <= 'z'; c++)
                {
                    chars[i] = c; 
                    String tempStr = new String(chars);
                    
                    if(dict.contains(tempStr))
                    {
                        if(!layer.containsKey(tempStr))
                        {
                            parents = new HashSet<String>();
                            parents.add(curStr);
                            parentsMap.put(tempStr, parents);
                            layer.put(tempStr, layer.get(curStr)+1);
                            q.offer(tempStr);
                        }
                        else if(layer.get(tempStr) > layer.get(curStr))
                        {
                            parents = parentsMap.get(tempStr);
                            parents.add(curStr);
                        }
                    }
                    
                    
                    if(tempStr.equals(end))
                    {
                        if(layer.get(curStr) < minLayers)
                        {
                            minLayers = layer.get(curStr) + 1;
                            ArrayList<String> path = new ArrayList<String>();
                            path.add(0, end);
                            addPathToResults(path, results, parentsMap, curStr, start);
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                chars[i] = old;
            }
        }
        
        return results;
    }
    
    
    private void addPathToResults(ArrayList<String> path, ArrayList<ArrayList<String>>results, HashMap<String, HashSet<String>> parentsMap, String word, String start)
    {
        path.add(0, word);
        if(word.equals(start))
        {
        
            results.add((ArrayList<String>)path.clone());
        }
        else
        {
            HashSet<String> parents = parentsMap.get(word);
            for(Object i:parents)
            {
                addPathToResults(path, results, parentsMap, (String)i, start);
            }
        }
        path.remove(0);
    }
}
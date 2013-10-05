/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> ret = new ArrayList<Interval>();
        for(Interval interval: intervals)
        {
            if(newInterval != null)
            {
                if(newInterval.start <= interval.end && newInterval.end >= interval.start)
                {
                    newInterval.end = Math.max(newInterval.end, interval.end);
                    newInterval.start = Math.min(newInterval.start, interval.start);
                }
                else
                {
                    if(newInterval.end < interval.start)
                    {
                        ret.add(newInterval);
                        newInterval = null;
                    }
                    ret.add(interval);
                }
            }
            else
            {
                ret.add(interval);
            }
        }
        
        if(newInterval != null)
        {
            ret.add(newInterval);
        }
        
        return ret;
        
    }
}
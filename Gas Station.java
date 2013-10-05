public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int totalGas = 0;
        int extraNeedGas = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++)
        {
            totalGas += gas[i] - cost[i];
            if(totalGas < 0)
            {
                extraNeedGas = -totalGas;
                start = i+1;
                totalGas = 0;
            }
        }
        
        return totalGas >= extraNeedGas? start: -1;
    }
}
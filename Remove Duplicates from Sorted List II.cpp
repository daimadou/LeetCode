/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(head == NULL)
            return NULL;
        
        unordered_map<int, int>checkmap;
        ListNode *cur = head;
        while(cur)
        {
            if(checkmap.count(cur->val)==0)
            {
                checkmap[cur->val] = 0;
            }
            else
            {
                checkmap[cur->val]++;
            }
            
            cur = cur->next;
        }
        
        
        ListNode temp(0);
        ListNode *pre = &temp;
        pre->next = head;
        cur = head;
        while(cur)
        {
            int val = cur->val;
            ListNode *next = cur->next;
            if(checkmap[val]>0)
            {
                free(cur);
                pre->next = next;
            }
            else
            {
                pre = cur;
            }
            cur = next;
        }
        
        return temp.next;
    }
};
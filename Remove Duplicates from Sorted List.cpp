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
        
        if(head==NULL)
            return NULL;
        
        unordered_set<int> checkSet;
        ListNode *cur = head;
        ListNode temp(0);
        ListNode *pre = &temp;
        pre->next = head;
        
        while(cur)
        {
            int val = cur->val;
            ListNode *next = cur->next;
            if(checkSet.count(val)==0)
            {
                checkSet.insert(val);
                pre = cur;
            }
            else
            {
                free(cur);
                pre->next = next;
            }
            
            cur = next;
        }
        
        return temp.next;
    }
};
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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
 
   //     ListNode *newL = NULL;
        if(l1==NULL&&l2==NULL)
            return NULL;
    
        ListNode *cur1 = l1;
        ListNode *cur2 = l2;
        ListNode temp(-1);
        ListNode *pre = &temp;
        while(l1&&l2)
        {
            if(l1->val < l2-> val)
            {
                pre->next = l1;
                l1 = l1->next;
            }
            else
            {
                pre->next = l2;
                l2 = l2->next;
            }
            
            pre = pre->next;
        }
        
        if(l1)
            pre->next = l1;
        else
            pre->next = l2;
        
        return temp.next;
    }
};
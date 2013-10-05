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
    ListNode *partition(ListNode *head, int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode temp1(0);
        ListNode temp2(0);
        ListNode *lessX = &temp1;
        ListNode *biggerX = &temp2;
        ListNode *cur = head;
        
        while(cur)
        {
            if(cur->val < x)
            {
                lessX->next = cur;
                lessX = lessX->next;
            }
            else
            {
                biggerX->next = cur;
                biggerX = biggerX->next;
            }
            cur = cur->next;
        }
        
        
        //Always consider ending node!!!! And that should be NULL.
        biggerX->next = NULL;
        lessX->next = temp2.next;
        
        return temp1.next;
    }
};
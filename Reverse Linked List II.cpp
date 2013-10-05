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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(head == NULL)
            return NULL;
        if(m<1||m>n)
            return NULL;
        if(m==n)
            return head;
        ListNode *cur = head;
        ListNode *pre = NULL;
        ListNode *last = NULL;
        ListNode temp(-1);
        pre = &temp;
        pre->next = head;
        
        int count = 0;
        while(cur)
        {
            count++;
            if(count<m)
            {
                pre = cur;
            }
            else if(count==m)
            {
                last = cur;
                
            }
        
            if(count<=m||count>n)
            {
                cur = cur->next;
            }
            else
            {
                last->next = cur->next;
                cur->next = pre->next;
                pre->next = cur;
                cur = last->next;
            }
        }
        
        if(m==1)
            return pre->next;
        else
            return head;
 
            
     
    }
};
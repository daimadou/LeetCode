/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if(head==NULL)
        {
            return NULL;
        }
        
        ListNode *twosteps = head->next;
        ListNode *onestep = head;
        ListNode *pre = NULL;
        while(twosteps)
        {
            if(twosteps->next)
            {
                twosteps = twosteps->next->next;
            }
            else
            {
                twosteps = NULL;
            }
            pre = onestep;
            onestep = onestep->next;
        }
        
        TreeNode *root = new TreeNode(onestep->val);
        
        if(pre)
            pre->next = NULL;
        else
            head = pre;
            
        root->left = sortedListToBST(head);
        root->right = sortedListToBST(onestep->next);
        onestep->next = NULL;
        free(onestep);
        
        return root;
    }
    
  
};
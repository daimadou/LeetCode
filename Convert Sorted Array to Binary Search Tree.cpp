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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return convert(num, 0, num.size()-1);
    }
    
    TreeNode *convert(vector<int> &num, int start, int end)
    {
        if(start>end)
        {
            return NULL;
        }
        
        int mid = (start+end)/2;
        
        TreeNode *root = new TreeNode(num[mid]);
        
        root->left = convert(num, start, mid-1);
        root->right = convert(num, mid+1, end);
        
        return root;
    }
};

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
    
    unordered_map<int, int> indexMap;
    
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        //this->preorder = preorder;
        //this->inorder = inorder;
        
        int N = preorder.size();
        indexMap.clear();
        for(int i = 0; i < N; i++)
        {
            indexMap[inorder[i]] = i;
        }
        
        return buildTree(preorder, 0, N, 0);
    }
    
    TreeNode *buildTree(vector<int> &preorder, int preorderStart, int N, int offset)
    {
        if(N<=0)
            return NULL;
        
        int val = preorder[preorderStart];
        int inorderIndex = indexMap[val];
        TreeNode *root = new TreeNode(val);
        int i = inorderIndex - offset;
        
        root->left = buildTree(preorder, preorderStart+1, i, offset);
        root->right = buildTree(preorder, preorderStart+i+1, N-i-1, offset + i + 1);
        
        return root;
    }
    
};
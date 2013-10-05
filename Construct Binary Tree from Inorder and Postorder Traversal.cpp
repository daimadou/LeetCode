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
    
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        //this->preorder = preorder;
        //this->inorder = inorder;
        
        int N = inorder.size();
        indexMap.clear();
        for(int i = 0; i < N; i++)
        {
            indexMap[inorder[i]] = i;
        }
        
        return buildTree(postorder, 0, N, 0);
    }
    
    TreeNode *buildTree(vector<int> &postorder, int postorderStart, int N, int offset)
    {
        if(N<=0)
            return NULL;
        
        int val = postorder[N-1+postorderStart];
        int inorderIndex = indexMap[val];
        TreeNode *root = new TreeNode(val);
        int i = inorderIndex - offset;
        
        root->left = buildTree(postorder,postorderStart, i, offset);
        root->right = buildTree(postorder, postorderStart+i, N-i-1, offset + i + 1);
        
        return root;
    }
};
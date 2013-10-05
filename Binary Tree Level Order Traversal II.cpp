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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        vector<vector<int>> result;
        list<TreeNode *>nodeList;
        nodeList.push_back(root);
        
        TreeNode *curNode = NULL;
        int cur = 1;
        int next = 0;
        vector<int> oneResult;
        
        while(!nodeList.empty())
        {
            curNode=nodeList.front();
            nodeList.pop_front();
            cur--;
           
            if(curNode)
            {
                oneResult.push_back(curNode->val);
                
                if(curNode->left)
                {
                    nodeList.push_back(curNode->left);
                    next++;
                }
                
                if(curNode->right)
                {
                    nodeList.push_back(curNode->right);
                    next++;
                }
                
                if(cur==0)
                {
                    auto it = result.begin();
                    result.insert(it, oneResult);
                    oneResult.clear();
                    cur = next;
                    next = 0;
                }
            }
            
         
        }
        
        return result;
        
    }
};
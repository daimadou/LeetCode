/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 


//recursive version

class Solution {
public:
    bool isSymmetric(TreeNode *root) {
       return isSymmetric(root, root); 
    }
    
    bool isSymmetric(TreeNode* root, TreeNode* reverse)
    {
        if(reverse==NULL&&root==NULL)
        {
            return true;  
        }
        else if(reverse&&root)
        {
            if(reverse->val !=root->val)
            {
                return false;
            }
            else{
                bool left = isSymmetric(root->left, reverse->right);
                if(left==false)
                    return false;
                else
                {
                    bool right = isSymmetric(root->right, reverse->left);
                    return right&&left;
                }
            }
        }
        else
        {
            return false;
        }
    }
};


// iterative version
/*
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if(root==NULL)
            return true;
            
        list<TreeNode *> nodeList;
        nodeList.push_back(root);
        list<TreeNode *> reverseList;
        reverseList.push_back(root);
        
        bool result = true;
        
        while(!nodeList.empty())
        {
            TreeNode *cur = nodeList.front();
            TreeNode *reverse = reverseList.front();
            nodeList.pop_front();
            reverseList.pop_front();
            
            if(cur==NULL&&reverse==NULL)
                continue;
            else if(cur&&reverse)
            {
                if(cur->val==reverse->val)
                {
                    nodeList.push_back(cur->left);
                    nodeList.push_back(cur->right);
                    reverseList.push_back(reverse->right);
                    reverseList.push_back(reverse->left);
                }
                else
                {
                    result = false;
                    break;
                }
            }
            else
            {
                result = false;
                break;
            }
        }
        
        return result;
        
    }
};

*/
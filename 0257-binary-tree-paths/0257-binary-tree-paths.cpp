
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    private:
    void findPaths(TreeNode* node, string path, vector<string>& paths) {
        if (node==NULL) return;
        if(!path.empty()) {
            path += "->";
        }
        path+=to_string(node->val);
        // If it's a leaf node, add the path to the list
       if (node->left == NULL && node->right == NULL){
            paths.push_back(path);
        }else{
            // Otherwise, continue to explore the left and right subtree
            findPaths(node->left, path, paths);
            findPaths(node->right, path, paths);
        }
    }
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        if(root != NULL){
            findPaths(root, "", paths);
        }
        return paths;
    }
};
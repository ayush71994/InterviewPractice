package MayChallenge;

import java.util.HashSet;
import java.util.Set;

public class BinaryCamera {
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        putCamera(root);
        if(root.val == 0) root.val=1;
        return postOrderTraversal(root);
    }

    private int postOrderTraversal(TreeNode root) {
        if(root == null) return 0;
        int val = postOrderTraversal(root.left) + postOrderTraversal(root.right);
        if(root.val == 1)
            return 1+val;
        else
            return val;
    }

    private void putCamera(TreeNode root) {
        if(root == null) return;
        if(isLeafNode(root)){
            root.val = -1;
            return;
        }
        putCamera(root.left);
        putCamera(root.right);
        if (root.left != null && root.right != null) {
            if (isLeafNode(root.right) || isLeafNode(root.left)){
                root.val = 1;
            } else if (root.left.val == 0 || root.right.val == 0) {
                root.val = 1;
            } else if (root.left.val == 1 || root.right.val == 1) {
                root.val = -1;
            }
        } else if (root.left != null) {
            if (isLeafNode(root.left)){
                root.val = 1;
            } else if (root.left.val == 0) {
                root.val = 1;
            } else if (root.left.val == 1) {
                root.val = -1;
            }
        } else if (root.right != null) {
            if (isLeafNode(root.right)){
                root.val = 1;
            } else if (root.right.val  == 0) {
                root.val = 1;
            } else if (root.right.val == 1) {
                root.val = -1;
            }
        }
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private boolean isChildLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

class BinaryCameraCleanerSolution {
    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}

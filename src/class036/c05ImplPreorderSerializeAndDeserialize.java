package class036;

public class c05ImplPreorderSerializeAndDeserialize {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            f(root, builder);
            return builder.toString();
        }

        void f(TreeNode root, StringBuilder builder){
            if (root == null){
                builder.append("#,");
            }else {
                builder.append(root.val + ",");
                f(root.left, builder);
                f(root.right, builder);
            }
        }

        public static int cnt;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            cnt = 0;
            return g(split);
        }

        TreeNode g(String[] vals){
            String cur = vals[cnt++];
            if (cur.equals("#")){
                return null;
            }else {
                TreeNode head = new TreeNode(Integer.valueOf(cur));
                head.left = g(vals);
                head.right = g(vals);
                return head;
            }

        }
    }

}

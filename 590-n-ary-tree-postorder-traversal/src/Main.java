import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {

        if (root == null) {
            return new ArrayList<>(0);
        }

        LinkedList<Integer> answer = new LinkedList<>();

        Deque<Node> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            answer.addFirst(cur.val);
            if (cur.children != null && cur.children.size() != 0) {
                for (Node child : cur.children) {
                    st.push(child);
                }
            }
        }
        return answer;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
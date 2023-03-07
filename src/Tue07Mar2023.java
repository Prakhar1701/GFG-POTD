import java.util.LinkedList;
import java.util.Queue;

public class Tue07Mar2023 {
    private class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }

    }

    public int maxLevelSum(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = -999999999;

        while (!queue.isEmpty()) {
            int n = queue.size();
            int currentSum = 0;

            for (int i = 0; i < n; i++) {
                if (queue.peek() != null) {
                    queue.add(queue.peek().left);
                    queue.add(queue.peek().right);
                    //System.out.print(queue.peek().data + " ");
                    currentSum = currentSum + queue.poll().data;
                } else {
                    queue.poll();
                }
            }
            if (!queue.isEmpty()) if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            //System.out.println("--->"+currentSum);
        }
        return maxSum;
    }
}
//Expected Time Complexity: O(N), where N is no of node.
//Expected Auxiliary Space: O(W), Where W is the max width of the tree.

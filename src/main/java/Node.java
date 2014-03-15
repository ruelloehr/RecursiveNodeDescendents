/**
 * A node element
 * User: ruel
 */

public class Node {

    public Node firstChild;
    public Node nextSibling;

    public Node() {
        this.firstChild = null;
        this.nextSibling = null;
    }

    /**
     * Count the number of descendents for a given node.
     *
     * @param node
     * @return
     */
    public int countDescendants(Node node) {

        int numParentDescendants = 0;

        //if a sibling exists, count the number of its descendents
        if (node.nextSibling != null) {
            numParentDescendants += countDescendants(node.nextSibling);
            numParentDescendants++;  //include the sibling itself in the the count
        }

        //if a child exists, count the number of its descendents
        if (node.firstChild != null) {
            numParentDescendants += countDescendants(node.firstChild);
            numParentDescendants++;   //include the child itself in the count
        }

        return numParentDescendants;

    }
}

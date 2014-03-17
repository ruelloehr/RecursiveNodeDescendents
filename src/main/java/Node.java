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

        //for the given node, we want to count all of its descendants (but not its siblings)
        if (node.firstChild != null)
            //include the child itself in the count
            return 1+ countDescendantsAndSiblings(node.firstChild);
        else
            return 0;

    }

    /**
     * Get a count of all descendant and sibling (and sibling descendant) nodes
     * related to the given node
     * @param node
     * @return
     */
    public int countDescendantsAndSiblings(Node node) {
        int numParentDescendants = 0;

        //if a child exists, count the number of its descendants
        if (node.firstChild != null) {
            numParentDescendants += countDescendantsAndSiblings(node.firstChild);
            numParentDescendants++;   //include the child itself in the count
        }


        //if a sibling exists, count the number of its descendents
        if (node.nextSibling != null) {
            numParentDescendants += countDescendantsAndSiblings(node.nextSibling);
            numParentDescendants++;  //include the sibling itself in the the count
        }


        return numParentDescendants;

    }
}

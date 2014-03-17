import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ruel
 * Date: 3/13/14
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeTest {


    @Test
    public void testEmptyParent() {
        Node node = new Node();

        int descCount = node.countDescendants(node);

        Assert.assertEquals(descCount, 0);
    }

    @Test
    public void testParent4Children() {
        Node parentNode = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        parentNode.firstChild  = node1;
        node1.nextSibling = node2;
        node2.nextSibling = node3;
        node3.nextSibling = node4;


        int descCount = parentNode.countDescendants(parentNode);

        Assert.assertEquals(descCount, 4);
    }

    @Test
    public void testMultiChildrenAndSiblings() {
        Node parentNode = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        Node node11 = new Node();

        parentNode.firstChild  = node1;
        node1.nextSibling = node2;
        node2.nextSibling = node3;
        node3.nextSibling = node4;

        node2.firstChild = node5;
        node5.nextSibling = node6;
        node6.nextSibling = node7;

        node7.firstChild = node8;
        node8.nextSibling = node11;

        node1.firstChild = node9;
        node9.nextSibling = node10;

        int descCount = parentNode.countDescendants(parentNode);

        Assert.assertEquals(descCount, 11);
    }


    /**
     * Count the descendents of a tree that mimics sample data
     */
    @Test
    public void testWithSampleData() {
        Node parentNode = new Node();  //div id="container"
        Node node1 = new Node();   //a
        Node node2 = new Node();   //div id="header"
        Node node3 = new Node();   //div id="header_nav"
        Node node4 = new Node();   //div class="avatar"
        Node node5 = new Node();   //img
        Node node6 = new Node();   //a
        Node node7 = new Node();   //ul
        Node node8 = new Node();   //li
        Node node9 = new Node();   //a
        Node node10 = new Node();   //li
        Node node11 = new Node();   //a
        Node node12 = new Node();   //form



        parentNode.firstChild  = node1;
        node1.nextSibling = node2;

        node2.firstChild =  node3;
        node3.firstChild = node4;
        node4.firstChild = node5;
        node4.nextSibling = node6;
        node6.nextSibling = node7;

        node7.firstChild = node8;
        node8.firstChild = node9;
        node8.nextSibling = node10;
        node10.firstChild = node11;

        node7.nextSibling=node12;


        int descCount = node3.countDescendants(node3);

        Assert.assertEquals(descCount, 9);
    }


    /**
      * Count the descendents of a tree that mimics sample data
      */
     @Test
     public void testWithSampleDataAndSiblingNodes() {
         Node parentNode = new Node();  //div id="container"
         Node node1 = new Node();   //a
         Node node2 = new Node();   //div id="header"
         Node node3 = new Node();   //div id="header_nav"
         Node node4 = new Node();   //div class="avatar"
         Node node5 = new Node();   //img
         Node node6 = new Node();   //a
         Node node7 = new Node();   //ul
         Node node8 = new Node();   //li
         Node node9 = new Node();   //a
         Node node10 = new Node();   //li
         Node node11 = new Node();   //a
         Node node12 = new Node();   //form
         Node node13 = new Node();

         parentNode.firstChild  = node1;
         node1.nextSibling = node2;

         node2.firstChild =  node3;
         node3.firstChild = node4;
         node3.nextSibling = node13;
         node4.firstChild = node5;
         node4.nextSibling = node6;
         node6.nextSibling = node7;

         node7.firstChild = node8;
         node8.firstChild = node9;
         node8.nextSibling = node10;
         node10.firstChild = node11;

         node7.nextSibling=node12;


         int descCount = node3.countDescendants(node3);

         Assert.assertEquals(9, descCount);
     }

}


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


/**
 * <h1>BTVertView</h1>
 *
 * <p>This class was modeled off of the BTView, but flips
 * the tree 90 degrees so that it branches horizontally
 * instead of vertically. None of the other classes were touched
 * except to call upon BTVertView instead of BTView.</p>
 *
 * <p>Created: 01/05/2022</p>
 *
 * @author Rhett Boatright
 */
public class BTVertView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two Branches in a tree

    BTVertView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null)
            // Display tree recursively
            displayTree(tree.getRoot(), getWidth() / 8, 100, getWidth() / 10, 0);

    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> root,
                             double x, double y, double hGap, double length) {
        if (root.left != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayTree(root.left, x + hGap , y + vGap, hGap / 2, length);
        }

        if (root.right != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y - vGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.right, x + hGap , y - vGap, hGap / 2, length);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}

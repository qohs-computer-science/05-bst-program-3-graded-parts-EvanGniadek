import java.lang.Comparable;

public class BST implements BSTInterface
{
    private int size;
    private TreeNode root;
    
    public BST()
    {
        int size = 0;
        root = null;
    }//end of constructor 
    
    public BST(TreeNode start)
    {
        int size = 1;
        root = start;
    }//end of constructor 

    public int size()
    {
        return size; 
    } //end of int size 

    public void add(Comparable newVal)
    {
            if(root == null)
                root = new TreeNode(newVal);
            else if(root.getValue().compareTo(newVal) >= 0)
            {
                if(root.getLeft() == null)
                    root.setLeft(new TreeNode(newVal));
                else
                    addHelper(newVal, root.getLeft());
            }
            else if(root.getValue().compareTo(newVal) < 0)
            {
                if(root.getRight() == null)
                    root.setRight(new TreeNode(newVal));
                else
                            addHelper(newVal, root.getRight());
            }
    }//end of add 
    
    public boolean find(Comparable toFind)
    {
        if(root == null)
            return false;
        else if(root.getValue().compareTo(toFind) > 0)
            {
                if(root.getLeft() == null)
                    return false; 
                else
                    return findHelper(toFind, root.getLeft());
            }
        else if(root.getValue().compareTo(toFind) < 0)
        {
                if(root.getRight() == null)
                    return false;
                else
                    return findHelper(toFind, root.getRight());
        }
        return false;
    } //end of find 

    public boolean isEmpty()
    {
        if(root == null)
            return false;
        else
            return true;
    }//end of isEmpty 
    
    public boolean delete(Comparable toDelete)
    {
        return true;
    } //end of delete 

    public boolean replace(Comparable old, Comparable toAdd)
    {
        return true;
    }//end of replace

    public void printPostOrder()
    {
        if(root!=null)postOrderHelper(root);
    }//ebd of post order
    
    public void printInOrder()
    {
        if(root !=null)inOrderHelper(root);
    } //endOfInOrder
    
    public void printPreOrder()
    {
        if(root != null)preOrderHelper(root);
    }//end of preOrder




    private void addHelper(Comparable newVal, TreeNode parent)
    {
        if(parent.getValue().compareTo(newVal) >= 0 && parent.getLeft() == null)
            parent.setLeft(new TreeNode(newVal));
        else if(parent.getValue().compareTo(newVal) >= 0)
            addHelper(newVal, parent.getLeft());
        else if(parent.getValue().compareTo(newVal) < 0 && parent.getRight() == null)
            parent.setRight(new TreeNode(newVal));
        else if(parent.getValue().compareTo(newVal) < 0 )
            addHelper(newVal, parent.getRight());
    } //end of addHelper;

    private boolean findHelper(Comparable toFind, TreeNode parent)
    {
        if(parent.getValue().compareTo(toFind) == 0)
            return true;
        else if(parent.getValue().compareTo(toFind) > 0 && parent.getLeft() == null)
            return false;
        else if(parent.getValue().compareTo(toFind) > 0)
            findHelper(toFind, parent.getLeft());
        else if(parent.getValue().compareTo(toFind) < 0 && parent.getRight() == null)
            return false;
        else
            findHelper(toFind, parent.getRight());
            return false;
    } //end of findHelper;

    private void inOrderHelper(TreeNode node)
    {
        if(node == null)
            return;

        if(node.getLeft() != null)
            inOrderHelper(node.getLeft());
        System.out.println(node.getValue());
        if(node.getRight() != null)
            inOrderHelper(node.getRight());

        } //endOfInOrderHelper
    private void preOrderHelper(TreeNode node)
    {
        System.out.println(node.getValue());
        if(node.getLeft() != null)
            preOrderHelper(node.getLeft());
        if(node.getRight() != null)
            preOrderHelper(node.getRight());
    } //end of preOrderHelper
    private void postOrderHelper(TreeNode node)
    {
        if(node.getLeft() != null)
            postOrderHelper(node.getLeft());
        if(node.getRight() != null)
            postOrderHelper(node.getRight());
        System.out.println(node.getValue());
    } //end of PostOrderHelper
}
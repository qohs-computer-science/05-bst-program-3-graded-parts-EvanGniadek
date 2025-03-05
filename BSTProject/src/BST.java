import java.lang.Comparable;

public class BST implements BSTInterface
{
    private int size;
    private TreeNode root;
    boolean isReplace;
    boolean isFound;
    boolean isDelete;
    
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
            size++;
    }//end of add 
    
    public boolean find(Comparable toFind)
    {
        isFound = false;
        if(root == null)
            return isFound;
        else if(root.getValue().compareTo(toFind) > 0)
            {
                if(root.getLeft() == null)
                    return isFound; 
                else
                     findHelper(toFind, root.getLeft());
            }
        else if(root.getValue().compareTo(toFind) < 0)
        {
                if(root.getRight() == null)
                    return isFound;
                else
                     findHelper(toFind, root.getRight());
        }
        return isFound;
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
        isDelete = false;
        if(root == null)
            return isDelete;
        else if(root.getValue().compareTo(toDelete) >= 0)
            {
                if(root.getLeft() == null)
                    return isDelete; 
                else
                     deleteHelper(toDelete, root.getLeft());
            }
        else if(root.getValue().compareTo(toDelete) < 0)
        {
                if(root.getRight() == null)
                    return isDelete;
                else
                     deleteHelper(toDelete, root.getRight());
        }
        if(isDelete)
            size--;
        return isDelete;
    } //end of delete 

    public boolean replace(Comparable old, Comparable toAdd)
    {
        isReplace = false;
        isReplace = find(old);
        if(isReplace) size--;
        size++;
        delete(old);
        addHelper(toAdd, root);
        return isReplace;
    }//end of replace

    public void printPostOrder()
    {
        if(root!=null)postOrderHelper(root);
    }//end of post order
    
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

    private void findHelper(Comparable toFind, TreeNode parent)
    {
        if(parent.getValue().compareTo(toFind) == 0)
            isFound = true;
        else if(parent.getValue().compareTo(toFind) > 0 && parent.getLeft() == null);
        else if(parent.getValue().compareTo(toFind) > 0)
            findHelper(toFind, parent.getLeft());
        else if(parent.getValue().compareTo(toFind) < 0 && parent.getRight() == null);
        else
            findHelper(toFind, parent.getRight());
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

    private TreeNode deleteHelper( Comparable search, TreeNode parent)
    {
       if(parent == null){
            return parent;
       }
       if(parent.getValue().compareTo(search) > 0)
       {
            parent.setLeft(deleteHelper(search, parent.getLeft()));
       }
       else if(parent.getValue().compareTo(search) < 0)
       {
            parent.setRight(deleteHelper(search, parent.getRight()));
       }
       else
       {
            isDelete = true;
            if(parent.getLeft() == null)
                return parent.getRight();
            if(parent.getRight() == null)
                return parent.getLeft();
            
            TreeNode temp = getThat(parent);
            parent.setValue(temp.getValue());
            parent.setRight(deleteHelper(temp.getValue(), parent.getRight()));
       }
       return parent;
    }//end of delete helper 

    private TreeNode getThat(TreeNode curr)
    {
        curr = curr.getRight();
            while(curr != null && curr != null)
                curr = curr.getLeft();
        return curr;
    }//end of get that 

}
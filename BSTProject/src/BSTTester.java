/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST test = new BST();

    String alpha = "qwertyuiopasdfghjklzxcvbnm";
    for(int j = 0; j < 26; j++)
    {
      test.add(alpha.charAt(0));
      alpha = alpha.substring(1);
    }//end of for loop
    System.out.println("now in order");
    test.printInOrder();
    System.out.println("now pre order");
    test.printPreOrder();
    System.out.println("now post order");
    test.printPostOrder();
    test.replace('d', 't');
    System.out.println("peep");
    test.printInOrder();
    if(test.find('u')) System.out.println("works");
    test.delete('s');
    System.out.println("s has been deleted ");
    test.printInOrder();
 }
}
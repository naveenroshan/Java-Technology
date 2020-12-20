import java.util.Random;

public final class Shuffle
{
   private static class Node
   {
      String name;
      Node next;
      Node prev;
   }

   public static void main(String[] args)
   {
      // Build a doubly-linked list.

      Node topForward = new Node();
      topForward.name = "A";
      Node temp = new Node();
      temp.name = "B";
      Node topBackward = new Node();
      topBackward.name = "C";
      topForward.next = temp;
      temp.next = topBackward;
      topBackward.next = null;
      topBackward.prev = temp;
      temp.prev = topForward;
      topForward.prev = null;

      // Dump forward singly-linked list.

      System.out.print("Forward singly-linked list: ");
      temp = topForward;
      while (temp != null)
      {
         System.out.print(temp.name);
         temp = temp.next;
      }
      System.out.println();

      // Dump backward singly-linked list.

      System.out.print("Backward singly-linked list: ");
      temp = topBackward;
      while (temp != null)
      {
         System.out.print(temp.name);
         temp = temp.prev;
      }
      System.out.println();

      // Shuffle list.

      Random rnd = new Random();
      for (int i = 3; i > 1; i--)
         swap(topForward, i - 1, rnd.nextInt(i));

      // Dump forward singly-linked list.

      System.out.print("Forward singly-linked list: ");
      temp = topForward;
      while (temp != null)
      {
         System.out.print(temp.name);
         temp = temp.next;
      }
      System.out.println();

      // Dump backward singly-linked list.

      System.out.print("Backward singly-linked list: ");
      temp = topBackward;
      while (temp != null)
      {
         System.out.print(temp.name);
         temp = temp.prev;
      }
      System.out.println();
   }

   public static void swap(Node top, int i, int j)
   {
      // Locate ith node.

      Node nodei = top;
      for (int k = 0; k < i; k++)
         nodei = nodei.next;

      // Locate jth node.

      Node nodej = top;
      for (int k = 0; k < j; k++)
         nodej = nodej.next;

      String namei = nodei.name;
      String namej = nodej.name;
      nodej.name = namei;
      nodei.name = namej;
   }
}
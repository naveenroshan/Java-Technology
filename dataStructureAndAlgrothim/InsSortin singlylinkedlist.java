public final class InsSort
{
   private static class Node
   {
      String name;
      Node next;
   }

   public static void main(String[] args)
   {
      Node top = null;

      // 1. The singly-linked list does not exist.

      top = new Node();
      top.name = "B";
      top.next = null;

      // 2. The singly-linked list exists and the node must be inserted
      //    after the last node.

      Node temp = new Node();
      temp.name = "D";
      temp.next = null;
      Node temp2 = top;
      while (temp2.next != null)
         temp2 = temp2.next;
      temp2.next = temp;

      // 3. The singly-linked list exists and the node must be inserted
      //    after the last node.

      temp = new Node();
      temp.name = "C";
      temp.next = null;
      temp2 = top;
      while (temp2.next != null)
         temp2 = temp2.next;
      temp2.next = temp;

      // 4. The singly-linked list exists and the node must be inserted
      //    after the last node.

      temp = new Node();
      temp.name = "A";
      temp.next = null;
      temp2 = top;
      while (temp2.next != null)
         temp2 = temp2.next;
      temp2.next = temp;

      // 5. Dump the unsorted list.

      dump("Unsorted list", top);

      // 6. Sort the list.

      top = sort(top);

      // 7. Dump the sorted list.

      dump("Sorted list", top);
   }

   private static void dump(String msg, Node topNode)
   {
      System.out.print(msg + " ");
      while (topNode != null)
      {
         System.out.print(topNode.name + " ");
         topNode = topNode.next;
      }
      System.out.println();
   }

   private static Node sort(Node top)
   {
      if (top == null || top.next == null)
         return top;

      Node sTop = null;
      while (top != null)
      {
         Node current = top;
         top = top.next;
         if (sTop == null || current.name.compareTo(sTop.name) < 0)
         {
            current.next = sTop;
            sTop = current;
         }
         else
         {
            Node p = sTop;
            while (p != null)
            {
               if (p.next == null || current.name.compareTo(p.next.name) < 0)
               {
                  current.next = p.next;
                  p.next = current;
                  break;
               }
               p = p.next;
            }
         }
      }
      return sTop;
   }
}
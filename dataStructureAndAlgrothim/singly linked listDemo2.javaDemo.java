public final class SLLDemo
{
   private static class DictEntry
   {
      String word;
      String meaning;
      DictEntry next;
   }

   // ListInfo is necessary because buildList() must return two pieces
   // of information.

   private static class ListInfo
   {
      DictEntry top;
      DictEntry last;
   }

   public static void main(String[] args)
   {
      String[] wordsMaster = { "aardvark", "anxious", "asterism" };
      ListInfo liMaster = new ListInfo();
      buildList(liMaster, wordsMaster);
      dump("Master list =", liMaster.top);
      String[] wordsWorking = { "carbuncle", "catfish", "color" };
      ListInfo liWorking = new ListInfo();
      buildList(liWorking, wordsWorking);
      dump("Working list =", liWorking.top);

      // Perform the concatenation

      liMaster.last.next = liWorking.top;
      dump("New master list =", liMaster.top);
      invert(liMaster);
      dump("Inverted new master list =", liMaster.top);
   }

   private static void buildList(ListInfo li, String[] words)
   {
      if (words.length == 0)
         return;

      // Create a node for first word/meaning.

      li.top = new DictEntry();
      li.top.word = words[0];
      li.top.meaning = null;

      // Initialize last reference variable to
      // simplify append and make concatenation possible.

      li.last = li.top;
      for (int i = 1; i < words.length; i++)
      {
         // Create (and append) a new node for next word/meaning.

         li.last.next = new DictEntry();
         li.last.next.word = words[i];
         li.last.next.meaning = null;

         // Advance last reference variable to simplify append and 
         // make concatenation possible.

         li.last = li.last.next;
      }
      li.last.next = null;
   }

   private static void dump(String msg, DictEntry topEntry)
   {
      System.out.print(msg + " ");
      while (topEntry != null)
      {
         System.out.print(topEntry.word + " ");
         topEntry = topEntry.next;
      }
      System.out.println();
   }

   private static void invert(ListInfo li)
   {
      DictEntry p = li.top, q = null, r;
      while (p != null)
      {
         r = q;
         q = p;
         p = p.next;
         q.next = r;
      }
      li.top = q;
   }
}
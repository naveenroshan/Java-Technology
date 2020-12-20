package collection.Framework;

import java.util.Comparator;

/**
*
* @author Naveen
*/

/*For a more practical example that uses a custom comparator, the following program is an
updated version of the TreeMap program shown earlier that stores account balances. In the
previous version, the accounts were sorted by name, but the sorting began with the first name.
The following program sorts the accounts by last name. To do so, it uses a comparator that
compares the last name of each account. This results in the map being sorted by last name.*/

//linked class is TreeMapTwoDemo.
public class TreeMapTwo implements Comparator<String>{
    public int compare(String aStr, String bStr) {
        int i, j, k;
        
        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        
        if (k == 0) // last names match, check entire name
            return aStr.compareToIgnoreCase(bStr);
        else
            return k;
    }
    // No need to override equals.
}

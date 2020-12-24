package lambda.Expressions;
/**
*
* @author Naveen
*/

//Use an instance method reference with different objects

//the linked class HighTempInstancemethodreference and interface are MyFuncInstancemethodreference
public class InstanceMethWithObjectRefDemo {
    
    // A method that returns the number of occurrences
    // of an object for which some criteria, as specified by
    // the MyFunc parameter, is true.
    static <T> int counter(T[] vals, MyFuncInstancemethodreference<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++)
            if (f.func(vals[i], v))
                count++;
        return count;
    }

    public static void main(String args[]) {
        int count;
       
        // Create an array of HighTemp objects.
        HighTempInstancemethodreference[] weekDayHighs = { new HighTempInstancemethodreference(89),
                new HighTempInstancemethodreference(82), new HighTempInstancemethodreference(90),
                new HighTempInstancemethodreference(89), new HighTempInstancemethodreference(89),
                new HighTempInstancemethodreference(91), new HighTempInstancemethodreference(84),
                new HighTempInstancemethodreference(83) };
        
        // Use counter() with arrays of the class HighTemp.
        // Notice that a reference to the instance method
        // sameTemp() is passed as the second argument.
        count = counter(weekDayHighs, HighTempInstancemethodreference::sameTemp, new HighTempInstancemethodreference(89));
        System.out.println(count + " days had a high of 89");
       
        // Now, create and use another array of HighTemp objects.
        HighTempInstancemethodreference[] weekDayHighs2 = { new HighTempInstancemethodreference(32),
                new HighTempInstancemethodreference(12), new HighTempInstancemethodreference(24),
                new HighTempInstancemethodreference(19), new HighTempInstancemethodreference(18),
                new HighTempInstancemethodreference(12), new HighTempInstancemethodreference(-1),
                new HighTempInstancemethodreference(13) };
        count = counter(weekDayHighs2, HighTempInstancemethodreference::sameTemp, new HighTempInstancemethodreference(12));
        System.out.println(count + " days had a high of 12");
        
        // Now, use lessThanTemp() to find days when temperature was less
        // than a specified value.
        count = counter(weekDayHighs, HighTempInstancemethodreference::lessThanTemp, new HighTempInstancemethodreference(89));
        System.out.println(count + " days had a high less than 89");
       
        count = counter(weekDayHighs2, HighTempInstancemethodreference::lessThanTemp, new HighTempInstancemethodreference(19));
        System.out.println(count + " days had a high of less than 19");
    }
}

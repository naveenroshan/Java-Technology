package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class is LambdaExceptionDemo and the interface is DoubleNumericArrayFunc
//this classes nothing but the creation of user custom exception by extending the main Exception class

@SuppressWarnings("serial")
class EmptyArrayException extends Exception {
    
    //this is the consturctor for this user cutom exception which display the message "Array Empty". 
    EmptyArrayException() {
        super("Array Empty");
    }
}

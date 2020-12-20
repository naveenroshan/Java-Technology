package pratieces;

public class Subject
	{
	
    
	    void methodOfSubject()
	    {
	        System.out.println("From Subject");
	       
	    }
	}
	 	class Physics extends Subject
	{
	    @Override
	    void methodOfSubject()
	    {
	        System.out.println("From Physics");
	    }
	}
	 	class Biology extends Subject
	{
	    @Override
	    void methodOfSubject()
	    {
	        System.out.println("From Biology");
	    }
	}
	 	class Botany extends Biology
	{
	    @Override
	    void methodOfSubject()
	    {
	        System.out.println("From Botany");
	    }
	}
	 	class Zoology extends Biology
	{
	    @Override
	    void methodOfSubject()
	    {
	        System.out.println("From Zoology");
	    }
}


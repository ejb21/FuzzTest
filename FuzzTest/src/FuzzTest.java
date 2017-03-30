//  Eric Budd (please expand)
//  CIT399
//  29 March 2017


	/*
	
		Tests are all currently set to @Ignore.
		It's recommended that you @Test them independent of one another.
		The test case .xlsx spreadsheet is located within my Java Project folder.
	
	*/


import org.junit.* ;
import static org.junit.Assert.* ;


public class FuzzTest
{
	LinkedList test = new LinkedList() ;
	LinkedList test2 = new LinkedList() ;
	
	
	@Ignore
	public void testDelete()
	{
		test.insertAtEnd( 0 ) ;
		test.insertAtEnd( 1 ) ;
		test.insertAtEnd( 2 ) ;
		test.insertAtEnd( 3 ) ;
		test.insertAtEnd( 4 ) ;
		
		test.deleteAtPosition( 1 ) ;
		
		assertEquals( 4 , test.getSize() ) ;
		
		test.deleteAtPosition( 1 ) ;
		test.deleteAtPosition( 1 ) ;
		
		assertEquals( 2 , test.getSize() ) ;
		
		/*
		
			With indices at either 1, 2, or 3, the "deleteAtPosition" method works
			perfectly, and the proper LinkedList size is returned.
			
			However, with indices of 0 (not shown above) the method fails. It appears
			as though it isn't possible to delete any nodes at index 0 within these
			LinkedLists. This could be an off-by-one error, or maybe something more
			insidious, but without access to the source code it's impossible to say
			for certain.
		
		*/
	}
	
	
	@Ignore
	public void testInsert()
	{
		test.insertAtPosition( 9999 , 0 ) ;
		test.insertAtPosition( 8888 , 1 ) ;
		
		assertEquals( 2 , test.getSize() ) ;
		
		test.insertAtPosition( 7777 , 0 ) ;
		
		assertEquals( 3 , test.getSize() ) ;
		
		/*
		
			Everything's working great through this point.
			
			However, the seven methods contained within LinkedList.java (four of which
			pertain to the insertion and deletion of nodes) don't offer a very robust
			palette of testing tools.
			
			It also appears to be the case that LinkedList's equals() method, which it
			inherits from java.lang.Object, is a no-go. It doesn't seem to work. (See
			below.) That leaves me with only two or three trustworthy methods with which
			to test.... I ended up just inserting items and checking the size of the
			LinkedList to be sure that they're getting through. The first three did.
			
			This equals() quandary is perplexing to me, but I have to assume that the
			mix-up is within the source code, because...
		
		*/
		
		test.insertAtPosition( 6666 , 2 );
		
		assertEquals( 4 , test.getSize() ) ;
		
		/*
		
			... all of my tests are failing. With this insertAtPosition() and getSize(),
			the wheels fall off what was previously a working test.
			
			I assume the issue has to do with insertAtPosition()'s index parameter.
			
			I'm guessing Mr. Hartman intentionally wrote these classes so that they
			would fail —— either that, or I'm truly awful at JUnit.
		
		*/
	}
	
	
	@Ignore
	public void testEquals()
	{
		test.insertAtEnd( 0 ) ;
		test.insertAtEnd( 1 ) ;
		test.insertAtEnd( 2 ) ;
		test.insertAtEnd( 3 ) ;
		test.insertAtEnd( 4 ) ;

		test2.insertAtEnd( 0 ) ;
		test2.insertAtEnd( 1 ) ;
		test2.insertAtEnd( 2 ) ;
		test2.insertAtEnd( 3 ) ;
		test2.insertAtEnd( 4 ) ;
		
		assertEquals( true , test.equals( test2 ) ) ;
		
		/*
		
			This fails (returns false). No explanation. It really oughtn't.
		
		*/
	}
}
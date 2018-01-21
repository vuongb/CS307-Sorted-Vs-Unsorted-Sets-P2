import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;


import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

//Student information for assignment

//On <my|our> honor, <NAME1> and <NAME2>, 
//this programming assignment is <my|our> own work and <we|I> have
// not provided this code to anyone else in the class.

//Student 1, Name: Emil Dides
//Student 1, UTEID: ED6295
//Student 1, CS307 class unique section id: 
//Student 1, email address: thegreatone150@gmail.com
//Student 1, Grader name: Oliver
//
//Student 2, Name: Bryan Vuong
//Student 2, UTEID: BKV85
//Student 2, CS307 class unique section id: 
//Student 2, email address: vuong.bryan@gmail.com
//Student 2, Grader name: Oliver
//
//Number of slip days used on this assignment:

/*
1)	307Sets: N^2
	JavaSets: N
2)	
3)	O(N); O(1)
4)	Hash: Random
	Tree: Ordered/Sorted


*/


public class SetTester {
	
	public static void main(String[] args){

		ISet<String> s1 = new UnsortedSet<String>();
		s1.add("A");
		s1.add("C");
		s1.add("A");
		s1.add("B");

		//test 1
		if( s1.contains("A") )
			System.out.println("Passed test 1: add and contains methods SortedSet");
		else
			System.out.println("Failed test 1: add and contains methods SortedSet");

		//test 2
		s1.remove("A");
		if( !s1.contains("A") )
			System.out.println("Passed test 2: remove method UnsortedSet");
		else
			System.out.println("Failed test 2: remove method UnsortedSet");

		//test 3
		if( s1.size() == 2 )
			System.out.println("Passed test 3: size method UnsortedSet");
		else
			System.out.println("Failed test 3: size method UnsortedSet");

		ISet<String> s2 = new UnsortedSet<String>();
		s2.add("C");
		s2.add("A");
		s2.add("B");

		//test 4
		if( s2.containsAll(s1) )
			System.out.println("Passed test 4: containsAll method UnsortedSet");
		else
			System.out.println("Failed test 4: containsAll method UnsortedSet");

		//test 5
		if( !s1.containsAll(s2) )
			System.out.println("Passed test 5: containsAll method UnsortedSet");
		else
			System.out.println("Failed test 5: containsAll method UnsortedSet");

		//test 6
		ISet<String> s3 = s2.difference(s1);
		ISet<String> expected = new UnsortedSet<String>();
		expected.add("A");
		if( s3.equals(expected))
			System.out.println("Passed test 6: difference and equals methods UnsortedSet");
		else
			System.out.println("Failed test 6: difference and equals methods UnsortedSet");

		//test 7
		s3 = s2.union(s1);
		expected.add("B");
		expected.add("C");
		if( s3.equals(expected))
			System.out.println("Passed test 7: union and equals methods UnsortedSet");
		else
			System.out.println("Failed test 7: union and equals methods UnsortedSet");

		//test 8
		s3 = s2.intersection(s1);
		expected.remove("A");
		if( s3.equals(expected))
			System.out.println("Passed test 8: intersection and equals methods UnsortedSet");
		else
			System.out.println("Failed test 8: intersection and equals methods UnsortedSet");

		//sorted sets
		s1 = new SortedSet<String>();
		s1.add("A");
		s1.add("C");
		s1.add("A");
		s1.add("B");

		//test 9
		if( s1.contains("A") )
			System.out.println("Passed test 9: add and contains methods SortedSet");
		else
			System.out.println("Failed test 9: add and contains methods SortedSet");

		//test 10
		s1.remove("A");
		if( !s1.contains("A") )
			System.out.println("Passed test 10: remove and contains methods SortedSet");
		else
			System.out.println("Failed test 10: remove and contains methods SortedSet");

		//test 11
		if( s1.size() == 2 )
			System.out.println("Passed test 11: size method SortedSet");
		else
			System.out.println("Failed test 11: size method SortedSet");

		s2 = new SortedSet<String>();
		s2.add("C");
		s2.add("A");
		s2.add("B");

		//test 12
		if( s2.containsAll(s1) )
			System.out.println("Passed test 12: containsAll method SortedSet");
		else
			System.out.println("Failed test 12: containsAll method SortedSet");

		//test 13
		if( !s1.containsAll(s2) )
			System.out.println("Passed test 13: containsAll method SortedSet");
		else
			System.out.println("Failed test 13: containsAll method SortedSet");

		//test 14
		s3 = s2.difference(s1);
		expected = new SortedSet<String>();
		expected.add("A");
		if( s3.equals(expected))
			System.out.println("Passed test 14: difference and equals methods SortedSet");
		else
			System.out.println("Failed test 14: difference and equals methods SortedSet");
		
	      //test 14.1
        s3 = s1.difference(s2);
        expected = new SortedSet<String>();
        if( s3.equals(expected))
            System.out.println("Passed test 14.1: difference and equals methods SortedSet");
        else
            System.out.println("Failed test 14.1: difference and equals methods SortedSet");

		//test 15
		s3 = s1.union(s2);
		expected = new SortedSet<String>();
		expected.add("A");
		expected.add("B");
		expected.add("C");
		if( s3.equals(expected))
			System.out.println("Passed test 15: union and equals methods SortedSet");
		else
			System.out.println("Failed test 15: union and equals methods SortedSet");

		//test 16
		s3 = s1.intersection(s2);
		expected.remove("A");
		if( s3.equals(expected))
			System.out.println("Passed test 16: intersection and equals methods SortedSet");
		else
			System.out.println("Failed test 16: intersection and equals methods SortedSet");
		
		// test 17
        s1.add("A");
        Iterator<String> it1 = s1.iterator();
        Iterator<String> it2 = s2.iterator();
        boolean good = true;
        while( good && it1.hasNext() )
            good = it1.next().equals(it2.next());
        if( good )
            System.out.println("Passed test 17: iterator and add methods SortedSet");
        else
            System.out.println("Failed test 17: iterator and add methods SortedSet");
        
        // test 18
        s1 = new UnsortedSet<String>();
        UnsortedSet<Integer> si1 = new UnsortedSet<Integer>();
        if(si1.equals(s1))
            System.out.println("Passed test 18: equals methods UnsortedSet");
        else
            System.out.println("Failed test 18: equals methods UnsortedSet");
        
        // test 19
        s1.add("is");
        s1.add("a");
        si1.add(12);
        si1.add(13);
        si1.add(12);
        if(!si1.equals(s1))
            System.out.println("Passed test 19: equals methods UnsortedSet");
        else
            System.out.println("Failed test 19: equals methods UnsortedSet");  
        
        // test 20
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.add(12);
        ar.add(13);
        if(!si1.equals(ar))
            System.out.println("Passed test 20: equals methods UnsortedSet");
        else
            System.out.println("Failed test 20: equals methods UnsortedSet"); 
        
        // test 21
        Object obj1 = s1;
        s2 = new UnsortedSet<String>();
        s2.add("a");
        s2.add("is");
        Object obj2 = s2;
        if(obj1.equals(obj2)) 
            System.out.println("Passed test 21: equals methods UnsortedSet");
        else
            System.out.println("Failed test 21: equals methods UnsortedSet"); 
        
		s1 = new SortedSet<String>();
		s2 = new SortedSet<String>();
		s3 = new SortedSet<String>();
		expected = new SortedSet<String>();
		boolean result;

		s1.add("c");
		s1.add("a");
		s1.add("b");
		s1.add("a");
		expected.add("a");
		expected.add("b");
		expected.add("c");
		if( s1.equals(expected))
			System.out.println("Passed test 22: add method SortedSet");
		else
			System.out.println("Failed test 22: add method SortedSet");

		s1.remove("a");
		expected.clear();
		expected.add("b");
		expected.add("c");
		if( s1.equals(expected))
			System.out.println("Passed test 23: remove method SortedSet");
		else
			System.out.println("Failed test 23: remove method SortedSet");

		s2.addAll(s1);
		if( s2.equals(expected))
			System.out.println("Passed test 24: addAll method SortedSet");
		else
			System.out.println("Failed test 24: addAll method SortedSet");

		result = s2.contains("a");
		if( !result)
			System.out.println("Passed test 25: contains method SortedSet");
		else
			System.out.println("Failed test 25: contains method SortedSet");


		result = s2.containsAll(expected);
		if( result)
			System.out.println("Passed test 26: containsAll method SortedSet");
		else
			System.out.println("Failed test 26: containsAll method SortedSet");

		s2.add("a");
		if( s2.size()==3)
			System.out.println("Passed test 27: size method SortedSet");
		else
			System.out.println("Failed test 27: size method SortedSet");

		result = s2.containsAll(expected);
		if( ((SortedSet<String>)s2).first().equals("a"))
			System.out.println("Passed test 28: first method SortedSet");
		else
			System.out.println("Failed test 28: first method SortedSet");

		if( ((SortedSet<String>)s2).last().equals("c"))
			System.out.println("Passed test 29: last method SortedSet");
		else
			System.out.println("Failed test 29: last method SortedSet");

		Iterator<String> it = s2.iterator();
		if( it.next().equals("a"))
			System.out.println("Passed test 30: iterator method SortedSet");
		else
			System.out.println("Failed test 30: iterator method SortedSet");

		s1.clear();
		s2.clear();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("a");
		s2.add("b");
		s2.add("c");
		s2.add("d");
		if(!s2.equals(s1))
			System.out.println("Passed test 31: equals method SortedSet");
		else
			System.out.println("Failed test 31: equals method SortedSet");



		s3 = s2.difference(s1);
		expected.clear();
		expected.add("d");
		if(s3.equals(expected))
			System.out.println("Passed test 32: difference method SortedSet");
		else
			System.out.println("Failed test 32: difference method SortedSet");


		s1.add("e");
//		s3 = s2.union(s1);
		expected.clear();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		expected.add("d");
		expected.add("e");
		if(s3.equals(expected))
			System.out.println("Passed test 33: union method SortedSet");
		else
			System.out.println("Failed test 33: union method SortedSet");

		s1.clear();
		s2.clear();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("c");
		s2.add("d");
		s2.add("e");
		expected.clear();
		expected.add("c");
		if(s1.intersection(s2).equals(expected))
			System.out.println("Passed test 34: intersect method AbtractSet");
		else
			System.out.println("Failed test 34: intersect method AbtractSet");

		s1 = new UnsortedSet<String>();
		s2 = new UnsortedSet<String>();
		s3 = new UnsortedSet<String>();
		expected = new UnsortedSet<String>();

		s1.add("a");
		if(s1.toString().equals("(a)"))
			System.out.println("Passed test 35: toString method AbtractSet");
		else
			System.out.println("Failed test 35: toString method AbtractSet");

		if(!s1.contains("b"))
			System.out.println("Passed test 36: contains method AbtractSet");
		else
			System.out.println("Failed test 36: contains method AbtractSet");

		s1.add("b");
		s1.add("!");
		s1.add("fun");	
		expected.add("a");
		expected.add("b");
		expected.add("!");
		if(s1.containsAll(expected))
			System.out.println("Passed test 37: containsAll method AbtractSet");
		else
			System.out.println("Failed test 37: containsAll method AbtractSet");

		expected.add("fun");
		if(s1.equals(expected))
			System.out.println("Passed test 38: equals method AbtractSet");
		else
			System.out.println("Failed test 38: equals method AbtractSet");


		s1.clear();
		expected.clear();
		s1.add("a");
		s1.add("a");
		expected.add("a");
		if(s1.equals(expected))
			System.out.println("Passed test 39: add method UnsortedSet");
		else
			System.out.println("Failed test 39: add method UnsortedSet");

		if(s1.size()==1)
			System.out.println("Passed test 40: size method UnsortedSet");
		else
			System.out.println("Failed test 40: size method UnsortedSet");

		s1.remove("a");
		if(s1.size()==0)
			System.out.println("Passed test 41: remove method UnsortedSet");
		else
			System.out.println("Failed test 41: remove method UnsortedSet");

		s2.add("a");
		s2.add("b");
		s2.add("c");
		s2.add("d");
		s1.addAll(s2);
		if(s1.equals(s2))
			System.out.println("Passed test 41: addAll method UnsortedSet");
		else
			System.out.println("Failed test 41: addAll method UnsortedSet");

		s3.add("h");
		s3.add("i");
		expected.clear();
		expected.addAll(s3);
		expected.addAll(s1);
		s2 = s1.union(s3);
		if(s2.equals(expected))
			System.out.println("Passed test 42: union method UnsortedSet");
		else
			System.out.println("Failed test 42: union method UnsortedSet");

		s2 = s1.difference(s3);
		if(s2.equals(s1))
			System.out.println("Passed test 43: difference method UnsortedSet");
		else
			System.out.println("Failed test 43: difference method UnsortedSet");
		
//		it = s1.iterator();
//		if(it.next().equals("a"))
//			System.out.println("Passed test 44: iterator method UnsortedSet");
//		else
//			System.out.println("Failed test 44: iterator method UnsortedSet");

        // CS307 Students. Uncomment this section when ready to 
        // run your experiments
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }
//        catch(Exception e){
//            System.out.println("Unable to change look and feel");
//        }
//		Scanner sc = new Scanner(System.in);
//		String response = "";
//		do{
//			largeTest();
//			System.out.print("Another file? Enter y to do another file: ");
//			response = sc.next();
//		}
//		while( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") );
        
	}

	public static void largeTest(){
		String text = convertFileToString();
		processTextCS307Sets(new SortedSet<String>(), text);
		processTextCS307Sets(new UnsortedSet<String>(), text);
		processTextJavaSets( new HashSet<String>(), text);
		processTextJavaSets( new TreeSet<String>(), text);
	}
	
	public static void processTextCS307Sets(ISet<String> set, String text){
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		s.start();
		while( sc.hasNext() ){
			set.add(sc.next());
		}
		s.stop();
		sc.close();
		
		System.out.println("Time to add the elements in the text to this set: " + s.toString() );
		System.out.println("Number of distinct words in this text " + set.size() );
		System.out.print("Enter y to see the contents of this set: ");
		sc = new Scanner(System.in);
		String response = sc.next();

		if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
			for(Object o : set)
				System.out.println(o);
		}
	}
	
	public static void processTextJavaSets(Set<String> set, String text){
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		s.start();
		while( sc.hasNext() ){
			set.add(sc.next());
		}
		s.stop();
		sc.close();
		
		System.out.println("Time to add the elements in the text to this set: " + s.toString() );
		System.out.println("Number of distinct words in this text " + set.size() );
		System.out.print("Enter y to see the contents of this set: ");
		sc = new Scanner(System.in);
		String response = sc.next();

		if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
			for(Object o : set)
				System.out.println(o);
		}
	}
	
	public static String convertFileToString() {
		//create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
	    StringBuilder text = new StringBuilder();
	    int retval = chooser.showOpenDialog(null);

	    chooser.grabFocus();

	    //read in the file
		if (retval == JFileChooser.APPROVE_OPTION)
		{   File source = chooser.getSelectedFile();
			try
			{   Scanner s = new Scanner( new FileReader( source ) );

				while( s.hasNextLine() )
				{   text.append( s.nextLine() );
					text.append(" ");
				}

				s.close();
			}
			catch(IOException e)
			{   System.out.println("An error occured while trying to read from the file: " + e);
			}
		}

		return text.toString();
	}
}
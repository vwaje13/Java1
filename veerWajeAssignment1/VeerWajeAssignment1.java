package veerWajeAssignment1;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 
// ^^ includes all imports necessary for code implemented
public class VeerWajeAssignment1 {

	static ArrayList < String > veerWajeList = new ArrayList<>(); // list for method 1; needs to be accessed later so is created here
	static Set<String> veerWajeSet; // set for method 3, also needs to be accessed outside of that method
	
	  public static String veerWajeRecursion(String s) {
	    int n = s.length(); // making it easy
	    if(n == 0) { // base case; empty string
	        return "";
	    }
	    if(n == 1) { // base case; returns capitalized char
		return s.substring(0, 1).toUpperCase();
	    }
	    return s.substring(0, 1).toUpperCase() + veerWajeRecursion(s.substring (1)); // recursive case; if string length greater than 1
	  }
	  public static void veerWajeCreateList() {
		  try {
			  File file = new File("/Users/veerwaje/eclipse-workspace/veerWajeAssignment1/veerWajeAssignment1/Assignment1DataFile.txt");
			  Scanner scanner = new Scanner(file); // needed to read the file

			  // Set the delimiters to split the text into words
	            scanner.useDelimiter("[\\s,.;:!?\"'()\\[\\]{}<>|\\\\]");

	          // Read each word and add it to the list
	          while (scanner.hasNext()) {
	        	  String word = scanner.next().trim();
	              if (!word.isEmpty()) {
	                    veerWajeList.add(word);
	              }
	          }

	            scanner.close();
	      } catch (FileNotFoundException e) { // file not found exception code 
	            e.printStackTrace();
	      }
	    System.out.println("LIST"); // beginning of list 
	    for(int i = 0; i < veerWajeList.size(); i++) { // traversing through list
	    	String s = veerWajeList.get(i);
	    	if(s.equals("") || s.equals(" ")) { // removing empty spaces, i think
	    		veerWajeList.remove(i);
	    	}
	    	else {
	    		 System.out.println(s); // printing each element on a new line
	    	}
	       
	    }
	  }
	  public static void veerWajeProcessList() {
	      System.out.println("CAPITALIZED LIST"); // beginning of cap list
	      for(int i = 0; i < veerWajeList.size(); i++) { // traversing through list
	          veerWajeList.set(i, veerWajeRecursion(veerWajeList.get(i))); // sends each element in list to recursive capitalization method
	          System.out.println(veerWajeList.get(i)); // prints the cap. words
	      }
	      
	  }
	  public static void veerWajeCreateSet() {
		  veerWajeSet = new HashSet<>(veerWajeList); // initializes the set
		  System.out.println("SET"); // beginning of set
		  for(String w : veerWajeSet) { // traversing through set
			  System.out.println(w); // printing each element on new line
		  }

	  }
	  public static int veerWajeCreateMapHelper(String string) { // created to make code easier to process; counts frequency of a word in the list
		  int ct = 0; // frequency count
		  for (String s : veerWajeList) { // traversing through list
		      if (s.equals(string)) {
		          ct++; // frequency increases whenever a word is repeated
		      }
		  }
		  return ct; // returns the frequency
	  }
	  public static void veerWajeCreateMap()
	  {
		  HashMap<String, Integer> veerWajeMap = new HashMap<String, Integer>();// new map created
		  System.out.println("MAP"); // beginning of map list
		  for(String w : veerWajeSet) { // traversing through set
			  int key = veerWajeCreateMapHelper(w); // creates the key to the frequency of the element in the list
			  veerWajeMap.put(w, key); // puts key and element pair into map
		  }
		  for (String i : veerWajeMap.keySet()) { // traverses through the map
			  System.out.println( "word: " + i + " frequency: " + veerWajeMap.get(i)); // prints the word and key pair
		  }

	  }
	  public static void main(String[]args)
	  {
	    veerWajeCreateList();
	    veerWajeProcessList();
	    veerWajeCreateSet();
	    veerWajeCreateMap();
	  }

}

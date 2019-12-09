
import java.util.*;
import java.io.*;
public class DSAssignment3 {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub		
		        //this opens the file with our lyrics
		        Scanner input = new Scanner(new File("Pocketful of Sunshine"));

		        // this creates the dictionary wordCounts
		        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
		        while (input.hasNext()) {
		            String next = input.next().toLowerCase();
		            String clean = next.replaceAll("\\p{Punct}", "").toLowerCase();

		            if (!wordCounts.containsKey(clean)) {
		                wordCounts.put(clean, 1);
		            } else {
		                wordCounts.put(clean, wordCounts.get(clean) + 1);
		            }
		        }

		        
		        HashMap<String, Integer> wordCount = sortByValue(wordCounts);
		        // prints frequency to a new file
		        PrintStream ps=new PrintStream("OrderedDictionary");
		        ps.println("Total words = " + wordCounts.size());
		        for (String word : wordCount.keySet()) {
		            int count = wordCount.get(word);
		            ps.println(count + ": " + word);
		        }
	}
public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
//to sort the map by value using a List
	      //creates a list of entries from our map
	      java.util.List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

	      // Sort the list
	      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
	        public int compare(Map.Entry<String, Integer> o1,
	                           Map.Entry<String, Integer> o2) {
	          return (o2.getValue()).compareTo(o1.getValue());
	        }
	      });

	      // put data from sorted list to hashmap
	      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
	      for (Map.Entry<String, Integer> aa : list) {
	        temp.put(aa.getKey(), aa.getValue());
	      }
	      return temp;
	    }
}

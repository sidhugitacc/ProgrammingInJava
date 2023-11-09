import java.util.Arrays;
public class StringMethods
{

public static void main(String args[])
{
String example1="We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano";

String example2=" Nano";

int length= example1.length();// Using Length
System.out.println("Length of string = "+length);

char index=example1.charAt(3);// Using charAt
System.out.println("The character at this position = " +index);

System.out.println("After comparing "+example1.compareTo(example2));// Using compareTo
System.out.println("After comparing ignoring case "+example1.compareToIgnoreCase(example2));

System.out.println(example1.concat(example2));// Using concat
System.out.println("After concat = "+example1.contains(example2));

System.out.println("The string ends with " +example1.endsWith("o"));// endsWith

System.out.println(example1.equals(example2));// Using equals()

System.out.println(example1.equalsIgnoreCase(example2));// Using equalsIgnoreCase

String example3= String.format(example1); // format()

System.out.println("Formatted string = " + example3);

byte[] bytes = example2.getBytes();// Using getBytes()
System.out.println("Bytes of the text: " + Arrays.toString(bytes));

System.out.println(" First occurence of thriving is at " +example1.indexOf("thriving")); // Using indexOf()

String internedText = example1.intern(); // Using intern()
System.out.println("Interned text: " + internedText);

System.out.println("The give array is empty or not = " +example1.isEmpty());

String joinedText = String.join(",", example1,example2);// Using join()
System.out.println("Joined text: " + joinedText);

int lastIndex = example1.lastIndexOf("workers"); // Using lastIndexOf()
System.out.println("Index of the last occurrence of 'workers': " + lastIndex);

String replacedText = example1.replace("thriving", "qwerty"); //Using replacedText()
System.out.println("Text with 'thiriving' replaced by 'qwerty': " + replacedText);

String replacedAllText = example1.replaceAll("I", "We");//Using replaceAll()
System.out.println("Text with all occurrences of 'I' replaced by 'We': " + replacedAllText);

String[] splittedText = example2.split("a");// Using split()
System.out.println("Splitted text: " + Arrays.toString(splittedText));

System.out.println("The string ends with " +example1.startsWith("W"));// Using startsWith()

String subString = example1.substring(10, 15);// Using substring()
System.out.println("Substring from index 10 to 15: " + subString);

char[] chars = example2.toCharArray(); // Using toCharArray()
System.out.println("Characters of the text: " + Arrays.toString(chars));


String lowerCaseText = example2.toLowerCase();//Using toLowerCase()
System.out.println("Text in lowercase: " + lowerCaseText);


String upperCaseText = example2.toUpperCase();// Using toUpperCase()
System.out.println("Text in uppercase: " + upperCaseText);

String example4 = "       Hello World!       ";//Using trim()
System.out.println(example4.trim());

String example5 = String.valueOf(100); //Using valueOf()
System.out.println(example5);

char[] charArray = new char[20];// Using getchar()
example1.getChars(0, 20, charArray, 0);
System.out.println("Characters from 0 to 19: " + Arrays.toString(charArray));

}


}
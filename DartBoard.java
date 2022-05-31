/*Written by Michael Richie*/

/*-The Random class was selected from the Java API because it is
 * a seeded number generator whereas the Math.random method is not.*/
import java.util.Random;

public class DartBoard {
	/*-Public method to generate an input number of random coordinates between 0 and 1.
	 *-Method determines whether each coordinate is within 1 distance of the origin.*/
	public void tossDarts(int e) {
		//-Save the beginning time stamp to track the total execution time of the method.
		long beginTime = System.currentTimeMillis();
		//-Variables for x and y coordinates and the estimated pi value.
		double x = 0;
		double y = 0;
		double estimate = 0;
		//-Variable to keep track of the number of coordinates within the circle.
		int inside = 0;
		//-Create a new random number generator.
		Random n = new Random();
		//-For loop executes the input number of desired coordinates
		for (int j=0; j<e; j++) {
			//-Generate new x and y coordinates
			x = n.nextDouble();
			y = n.nextDouble();
			/*-Check to see if the coordinate is within 1 distance of the origin
			 * and thus within the circle.*/
			if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) < 1) {
				//-Increment the number of coordinates within the circle if true.
				inside++;
			}
		}
		/*-Pi is estimated by dividing the number of coordinates inside the circle by the total
		 * number of coordinates and then multiplying that number by four since the original
		 * estimate is for one quarter of the actual circle*/
		estimate = 4 * ((double) inside / e);
		//-Save the end time and subtract the beginning time to find the total execution time.
		long endTime = System.currentTimeMillis() - beginTime;
		//-Print the information
		System.out.println("For " + e + " random coordinates, " + inside + " fell inside the circle.");		
		System.out.println("Pi is estimated at: " + estimate);	
		System.out.println("Calculated in " + endTime + " milliseconds.\n");	
	}
	
	//-Main method for testing
	public static void main(String[] args) {
		//-Tester example of the class
		DartBoard test = new DartBoard();
		System.out.println("Estimating Pi using the area method Monte Carlo simulation:");
		System.out.println("By generating a uniformly random point within a space that contains\n" +
						   "a quarter circle and bounding square, the probability that the point\n" +
						   "is inside the quarter circle is equal to the ratio of the area of the\n" +
						   "quarter circle divided by the area of the bounding square.\n");
		//-Output random number generator used
		System.out.println("The Random class was selected from the Java API for this project because\n" + 
						   "it uses a 48 bit seed to generate random numbers whereas Math.random is\n" +
						   "an unseeded number generator.\n");
		//-The estimated the time complexity of this solution should be linear
		System.out.println("The time complexity for this solution is linear time.\n" +
						   "This is because despite having several nested operations,\n" +
						   "the program uses only one loop.\n");
		System.out.println("Press enter to continue");
		try{
			System.in.read();
		}
		catch(Exception e){
		}
		//-Multiple method calls each using an increasing number of points
		test.tossDarts(100);
		test.tossDarts(100000);
		test.tossDarts(1000000);
		test.tossDarts(10000000);
		test.tossDarts(100000000);
		System.out.println("Note that although time complexity is approximately linear\n" +
						   "and our estimates do improve with larger sample sizes, the\n" +
						   "estimates of Pi may be effected by the reliability of the\n" +
						   "random number seed used and the chosen algorithm.");
	}
}
import java.util.*;

public class JobAssigner {

	// Method for randomizing the inputs entered
	public static HashMap<String, String> getRandom(HashMap<String, String> in)
	{
		// Declare a HashMap of society names and jobs
		HashMap<String, String> strMap = new HashMap<String, String>();
		
		// Declare Arrays and ArrayLists
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		int[] valuesArr = new int[in.size()];
		
		// Transfers and splits all the elements of the HashMap to the ArrayLists
		for(String i : in.keySet())
		{
			keys.add(i);
			values.add(in.get(i));
		}

		// Randomizes the values of the HashMap (the jobs)
		for(int i = 0; i<valuesArr.length; i++)
			valuesArr[i] = i;
		
		Random randomGenerator = new Random();
        int randomIndex;
        int randomValue;

		for(int i = 0; i<valuesArr.length; ++i)
		{
			randomIndex = randomGenerator.nextInt(valuesArr.length);
			randomValue = valuesArr[randomIndex];
			valuesArr[randomIndex] = valuesArr[i];
			valuesArr[i] = randomValue;
		}
		
		// Assign the randomized order to the master HashMap
		for(int i = 0; i<valuesArr.length; i++)
			strMap.put(keys.get(i), values.get(valuesArr[i]));
			
		return strMap;
	}
	
	// Method for displaying the master HashMap
	public static void assignJobs(HashMap<String, String> in)
	{
		// Declare the HashMap by receiving aforementioned randomized one
		HashMap<String, String> result = getRandom(in);
		
		// Neatly display the names and jobs
		System.out.println("\n| RANDOMIZED JOBS FOR THIS MONTH |\n");
		
		for(String i : result.keySet())
			System.out.println(i + "\t:::\t" + result.get(i) + "\n");
		
		System.out.println("| ALL WHO LIVE WITH THE PEOPLE LISTED HAVE THE SAME / ASSISTING JOBS |\n");
	}
	
	public static void main(String[] args) {

		// Set up Scanner
		Scanner input = new Scanner(System.in);
		
		// Declare and set a HashMap of preset names and jobs
		HashMap<String, String> namesAndJobs = new HashMap<String, String>();
		
		namesAndJobs.put("Will", "Trash Duty");
		namesAndJobs.put("Ally", "Kitchen Duty");
		namesAndJobs.put("Jason", "Environmental Cleanup Duty");
		namesAndJobs.put("Chris", "Security Guard");
		namesAndJobs.put("A.J.", "Research / Escape Planner Duty");
		namesAndJobs.put("Katherine", "Food Census Duty");
		namesAndJobs.put("Dewey", "Electronics Keeper");
		namesAndJobs.put("Harry", "Weapons Keeper");
		namesAndJobs.put("Mark", "Shopkeeper");
		namesAndJobs.put("Jefferson", "Water Maintainer");
		namesAndJobs.put("Jeff", "Activity Planner");
		namesAndJobs.put("Victor", "Head Chef");
		namesAndJobs.put("Ricky", "Communications Duty");
		namesAndJobs.put("Allison", "Agriculture Keeper");
		namesAndJobs.put("Wilson", "Peace Maintainer");
		namesAndJobs.put("Larry", "Contemporary Leader");
		namesAndJobs.put("Bob", "Vehicle Keeper");
		namesAndJobs.put("Gordon", "Trash Duty");
		namesAndJobs.put("Daequan", "Kitchen Duty");
		namesAndJobs.put("Simmons", "Security Guard");
		namesAndJobs.put("Donald", "Research / Escape Planner Duty");
		namesAndJobs.put("Gregory", "Food Census Duty");
		namesAndJobs.put("Jahseh", "Shopkeeper");
				
		// Ask user if they would like to make a custom list
		// If not, randomize the aforementioned HashMap of names and jobs
		System.out.println("\nWould you like to enter a customized list? (Y / N):");
		String customizedOrNot = input.nextLine();
		
		switch (customizedOrNot) {
		case "N":
		case "n":
			assignJobs(namesAndJobs);
			break;
			
		case "Y": 
		case "y": 
			// Declare the master HashMap
			HashMap<String, String> finalList = new HashMap<String, String>();
		
			// Ask for user name and job input and add to HashMap
			// Instantiate the following sentinel loop
			System.out.print("Start entering the names and jobs respectively / ");
			System.out.println("(Enter 'done' when you are finished)\n");
		
			System.out.println("Name 1 (Enter 'done' when finished): ");
			String name = input.nextLine();
	
			System.out.println("Job 1: ");
			String job = input.nextLine();
			System.out.println();
		
			finalList.put(name, job);
		
			String SENTINEL = "done";
			int count = 2;
		
			// Begin the sentinel loop
			while(name.equalsIgnoreCase(SENTINEL) != true)
			{
				System.out.println("Name " + count + " (Enter 'done' when finished): ");
				name = input.nextLine();
			
				// Break instance
				if(name.equalsIgnoreCase(SENTINEL))
				{
					System.out.println("\n------- FINISHED -------\n\n");
					break;
				}
			
				System.out.println("Job " + count + ": ");
				job = input.nextLine();
			
				finalList.put(name, job);
			
				count++;
				System.out.println();
			}
			assignJobs(finalList);
			break;
			
		default: System.out.println("You did not enter a 'Y' or 'N'");
		}
		
		input.close();
	}
	
}

import java.util.*;

public class fairTeams {
	
	public static int C;
	
	
	public static class Player {
	    private String name;
	    private int skill=50; //From 0-100

	    public Player(String name, int skill) {
	        this.name = name;
	        this.skill = skill;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getSkill() {
	        return skill;
	    }

	    public void setSkill(int skill) {
	        this.skill = skill;
	    }   
	}
	
	public static class Team {
	    private String name;
	    public ArrayList<Player> players=new ArrayList<>();

	    public Team(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void add(Player player) {
	    	this.players.add(player);
	    }
	    
	    public ArrayList<Player> getPlayers() {
	    	return players;
	    }
	}
	

	public static void main(String[] args) {
		
		C = 0;
		
		int francis, victor, george, peter, joe, alain, patrick, mitri, paul, tony, johnny, mark;
		francis = 70;
		victor = 68;
		george = 40;
		peter = 86;
		joe = 68;
		alain = 68;
		patrick = 15;
		mitri = 55;
		paul = 33;
		tony = 78;
		johnny = 78;
		mark = 25;
		
		ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Francis", 70));
        players.add(new Player("Victor", 68));
        players.add(new Player("George", 40));
        players.add(new Player("Peter", 86));
        players.add(new Player("Joe", 68));
        players.add(new Player("Alain", 68));
        players.add(new Player("Patrick", 15));
        players.add(new Player("Mitri", 55));
        players.add(new Player("Paul", 33));
        players.add(new Player("Tony", 78));
        players.add(new Player("Johnny", 78));
        players.add(new Player("Mark", 25));
        
        Collections.shuffle(players);
        
        ArrayList<Team> teams = new ArrayList<>();
        
        ArrayList<Player> t1 = new ArrayList<>();
        ArrayList<Player> t2 = new ArrayList<>();
        ArrayList<Player> t3 = new ArrayList<>();      
   	
		double average = francis + victor + george + peter + joe + alain + patrick + mitri + paul + tony + johnny + mark;
		System.out.println("The total score of all players is: " + average);
		System.out.println("The recomenned team score is: " + average/3);
		//average = average /12;
		//System.out.println(average);
		
		int arr[] = {francis, victor, george, peter, joe, alain, patrick, mitri, paul, tony, johnny, mark}; 
        int r = 4; 
        int n = arr.length; 
        printCombination(players, n, r, teams);
        
        ArrayList <Team> finalTeams = new ArrayList<>();
        
        finalTeams.add(teams.get(0));
        t1.addAll(finalTeams.get(0).getPlayers());    

        
        ArrayList<Player> tempo = new ArrayList<>();
        ArrayList <Team> teamData = new ArrayList<>();
        

        for(int i = 0; i < teams.size(); i++)
        {
        	tempo.clear();
        	for(int j = 0; j < 4; j++)
        		tempo.add(teams.get(i).getPlayers().get(j));
        	if (Collections.disjoint(tempo, t1))
        	{
        		teamData.add(teams.get(i));
        	}
        }
        
        finalTeams.add(teamData.get(0));
        t2.addAll(teamData.get(0).getPlayers());
     
        
        ArrayList<Team> teamData2 = new ArrayList<>();
        
        for(int i = 0; i < teamData.size(); i++)
        {
        	tempo.clear();
        	for(int j = 0; j < 4; j++)
        		tempo.add(teamData.get(i).getPlayers().get(j));
        	if (Collections.disjoint(tempo, t2))
        	{
        		teamData2.add(teamData.get(i));
        	}
        }
        
        finalTeams.add(teamData2.get(0));
        
        

        System.out.println(teams.size());
        
        for(int i = 0; i < finalTeams.size(); i++)
        	printTeam(finalTeams, i);

		
	}
	
	 /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static void combinationUtil(ArrayList<Player> players, int n, int r, int index, ArrayList<Player> data, int i, ArrayList<Team> teams) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
        	int score = 0;
        	for (int k = 0; k < 4; k++)
        		score = score + data.get(k).skill; 
        		
        	if (score > 223 && score < 233) 
        	{	
        		C++;
        		Team team = new Team("Team " + Integer.toString(C));
        		for (int j=0; j<r; j++) 
        		{
        			//System.out.print(data.get(j).name +" ");
        			team.add(data.get(j));
        		}
        		teams.add(team);
        		//System.out.println(""); 
        	}
        return; 
        } 
  
        // When no more elements are there to put in data[] 
        if (i >= n) 
        return; 
  
        // current is included, put next at next location
        data.add(index, players.get(i));
        //data[index] = arr[i]; 
        combinationUtil(players, n, r, index+1, data, i+1, teams); 
  
        // current is excluded, replace it with next (Note that  i+1 is passed, but index is not changed) 
        combinationUtil(players, n, r, index, data, i+1, teams); 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
     static void printCombination(ArrayList<Player> players, int n, int r, ArrayList<Team> teams) 
    { 
        // A temporary array to store all combination one by one 
    	ArrayList<Player> data = new ArrayList<>();
        //int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(players, n, r, 0, data, 0, teams); 
    } 
     
    public static void printTeam(ArrayList<Team> team, int index){
    	
    	int score = team.get(index).getPlayers().get(0).getSkill() 
    			+ team.get(index).getPlayers().get(1).getSkill()
    			+ team.get(index).getPlayers().get(2).getSkill()
    			+ team.get(index).getPlayers().get(3).getSkill();
    	
    	System.out.print("Team " + Integer.toString(index + 1) + " is " + team.get(index).getPlayers().get(0).getName()
    			+ " " + team.get(index).getPlayers().get(1).getName()
    			+ " " + team.get(index).getPlayers().get(2).getName()
    			+ " " + team.get(index).getPlayers().get(3).getName());
    	System.out.println(" with a team score of: " + score);
    	
    }
	
	
	

}

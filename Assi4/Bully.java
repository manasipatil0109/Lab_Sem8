//package bully;

public class Bully {
	static int num_proc = 7;
	static boolean[] state = new boolean[num_proc];
    static int coordinator = 0;

    public static void elect(int startid)
    {
    	int tmpcoord = startid;
    	int i=startid;
    	int j=i+1;
    	for ( i=startid; i<num_proc ; i++) {
    		for ( j = i+1; j<num_proc ; j++) {
    			if(state[i]==true) {
    				System.out.println("\nMessage sent from "+i+" to "+j);
    			}
			}
			for ( j = i+1; j<num_proc ; j++) {
				if(state[j]==true && state[i] == true) {
					System.out.println("\nOK sent from "+j+" to "+i);
					tmpcoord = j;
				}
			}
    	}
    	coordinator = tmpcoord;
    	System.out.println("\nCoordinator is "+coordinator);

    }

    public static void bringUp(int proc_id)
    {
    	state[proc_id]=true;
    	elect(proc_id);
    }

    public static void bringDown(int proc_id)
    {
    	state[proc_id]=false;
    }

	public static void main(String[] args) {
        for (int i = 0; i < Bully.num_proc; ++i) {
            Bully.state[i] = true;
        }
         Bully.coordinator = 6;
        System.out.println("7 active process are:");
        System.out.println("Process up  = p0 p1 p2 p3 p4 p5 p6");
        System.out.println("Process 6 is coordinator");
        Bully.bringDown(6);
        Bully.bringDown(5);
        Bully.elect(2);
	}
}

class TowerOfHanoi 
{ 
    // Java recursive function to solve tower of hanoi puzzle 
    static void toh(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        //aux_rod is the helping rod we can use to move the disks
        if (n == 1) 
        { 
            //System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
        } 
        else{
                toh(n-1, from_rod, aux_rod, to_rod); 
                //System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
                toh(n-1, aux_rod, to_rod, from_rod); 
        }
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
        int n = 100; // Number of disks 
        toh(n, 'A', 'C', 'B'); //A, B and C are the name of the rods
    } 
} 
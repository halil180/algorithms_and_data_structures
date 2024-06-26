package hanoi;



// T(1) = 1
// T(n)  = 2. T(n-1) + 1
// T(N) = (2 hoch 4) - 1
class Main {
    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    //  Driver method
    public static void main(String args[]) {

        towerOfHanoi(3, 'A', 'C', 'B');  // A, B and C are names of rods
    }
}

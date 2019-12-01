package main;

public class Main {
    public static void main (String args[]) {
        FileIO fileIO = new FileIO(args[0], args[1]);
        fileIO.ReadInput();
    }
}

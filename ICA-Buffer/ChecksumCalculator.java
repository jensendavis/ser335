public class ChecksumCalculator {

    private static native long calculateChecksum(String filename);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: Please provide a filename as an argument.");
            System.exit(1);
        }

        System.loadLibrary("main");
        long checksum = calculateChecksum(args[0]);
        
        if (checksum == 0) {
            System.err.println("Error: The filename is too long. Please use a shorter filename.");
            System.exit(1);
        }
        
        System.out.println("Got checksum from native method: " + checksum);
    }
}

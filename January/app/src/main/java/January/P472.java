package January;

public class P472 {
    
    public void printDescription() {
        System.out.println("Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.");
    }

    public static void main(String[] args) {
        P472 p = new P472();
        p.printDescription();

        char input[] = { '1', '1', '1' };
        int count = p.waysCount(input, input.length);
        System.out.println("The count is " + count);
    }

    public int decodingCount(char[] message, int n) {
        
        // if the length is 0 or 1, there is only one decoding
        if (n == 0 || n == 1) {
            return 1;
        }

        if (message[0] == '0') {
            return 0;
        }
        
        // init count at 0
        int count = 0;

        // if last digit is greater than 0, it adds to number
        if (message[n - 1] > '0') {
            count = decodingCount(message, n-1);
        }

        // if last two digits is smaller or equal to 26, then consider last two digits
        // and recurr
        if (message[n - 2] == '1' || (message[n - 2] == '2' && message[n - 1] < '7')) {
            count += decodingCount(message, n - 2);
        }

        return count;
    }

    public int waysCount(char[] message, int n) {
        return decodingCount(message, n);
    }
}

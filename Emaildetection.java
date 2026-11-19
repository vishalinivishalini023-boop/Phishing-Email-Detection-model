import java.util.Scanner;

public class Emaildetection{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter URL: ");
        String url = sc.nextLine().toLowerCase();

        int risk = 0;

        if (url.startsWith("https://")) {
            System.out.println("HTTPS Check: Secure");
        } else {
            System.out.println("HTTPS Check: Not Secure");
            risk += 15;
        }

       
        if (url.contains("login") || url.contains("password")
                || url.contains("verify") || url.contains("bank")) {
            System.out.println("Keyword Check: Suspicious Keyword Found");
            risk += 30;
        } else {
            System.out.println("Keyword Check: No Suspicious Keyword");
        }

      
        if (url.matches(".*\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.*")) {
            System.out.println("IP Check: IP Address Detected");
            risk += 30;
        } else {
            
            System.out.println("IP Check: No IP Address Found");
        }

    
        if (url.contains("bit.ly") || url.contains("tinyurl.com")
                || url.contains("t.co")) {
            System.out.println("Shortener Check: Shortened URL Detected");
            risk += 25;
        } else {
            System.out.println("Shortener Check: Not a Shortened URL");
        }

      
        System.out.println("\nRisk Score: " + risk);

        if (risk >= 50) {
            System.out.println("Risk Level: HIGH");
            System.out.println("Result: Suspicious URL Detected");
        } else if (risk >= 20) {
            System.out.println("Risk Level: MEDIUM");
            System.out.println("Result: URL Needs Verification");
        } else {
            System.out.println("Risk Level: LOW");
            System.out.println("Result: No Suspicious Signs Found");
        }

        sc.close();
    }
}
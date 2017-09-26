import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[]args) {
        // OUTPUTS THE TEXT IN USER-INPUTTED URL
        System.out.print("Type your url: ");
        Scanner urlgetter = new Scanner(System.in);
        String input = urlgetter.nextLine();
        String output = urlToString(input);
        System.out.println(output);

        // GETS WORD COUNT OF INPUTTED URL
        String[] newOutput = output.split(" ");
        int wordCount = newOutput.length;
        System.out.println("Word count of this url is: " + wordCount);

    }


/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

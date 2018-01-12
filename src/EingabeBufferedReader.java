import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EingabeBufferedReader {

    public String input(String ausgabe)
    {
        System.out.println(ausgabe);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }
}

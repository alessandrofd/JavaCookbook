package structure;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class PropsCompanies {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();

        // Get my data
        props.put("Adobe", "Moutain View, CA");
        props.put("IBM", "White Plains, NY");
        props.put("Learning Tree", "Los Angeles, CA");
        props.put("Microsoft", "Redmond, WA");
        props.put("Netscape", "Mountain View, CA");
        props.put("O'Reilly", "Sebastopol, CA");
        props.put("Sun", "Mountain View, CA");

        // Now load additional properties
        props.load(System.in);

        // List merged properties, using System.out
        props.list(System.out);
    }
}

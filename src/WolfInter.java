import java.net.MalformedURLException;
import java.net.URL;
import java.io.*; 
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class WolfInter
{
    public static String useFunc(String input)
    {
        System.out.println(input);
        String xmlFile = "";
        String output;
        try {
            URL url = new URL("http://api.wolframalpha.com/v2/query?input="+input+"&appid=8EXQE5-6LURH4LLPH");
            BufferedReader reponce = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            WolfHand hand = new WolfHand();
            reader.setContentHandler(hand);
            reader.parse(new InputSource(reponce));
            return hand.getAns();
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
        return "";
    }

}

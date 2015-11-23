import java.net.MalformedURLException;
import java.net.URL;
import java.io.*; 
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;
/**
 * Write a description of class WolfHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WolfHand extends DefaultHandler
{
    boolean inResults;
    boolean inPlainText;
    String ans;
    public void startDocument()
    {
        inResults = false;
        inPlainText = false;
        ans = "";
    }

    public void startElement(String uri, String localName,String qName,Attributes attributes)throws SAXException{
        if(localName.equals("pod"))
        {
            if(attributes.getValue("id").equals("Result")|| attributes.getValue("id").equals("IndefiniteIntegral") || attributes.getValue("id").equals("Input"))
            {
                inResults = true;
            }
            // From a stylistic standpoint, wouldn't it be easier to just say inResults = (attributes.getValue("id").equals("Result")|| attributes.getValue("id").equals("IndefiniteIntegral") || attributes.getValue("id").equals("Input"));
        }
        else if(localName.equals("plaintext") && inResults)
        {
            inPlainText = true;
        }
        //You can make the same change here
        else
        {
            //I may just be inexperienced with Java, but do we want there to be something in the else statement? If not, what purpose does it serve?
        }
    }
    public void endElement(String uri, String localName, String qName)throws SAXException
    {
        if(localName.equals("pod") && inResults)
        {
            inResults  = false;
        }
        //I suppose you can do the same thing I suggested above with a not... Ex. inResults = !(localName.equals("pod") && inResults);
        else if(localName.equals("plaintext") && inResults)
        {
            inPlainText = false;
        }
        //Once again, the change would work here as well.
        else
        {
            //I am still curious about the whole empty else statement. I've never seen this before. Haha.
        }
    }
    public void characters(char[] ch, int start, int length)throws SAXException
    {
        if(inPlainText)
        {
            ans += new String(ch, start, length);
        }
    }
    public String getAns()
    {
        return ans;
    }
}

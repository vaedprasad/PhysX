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
        }
        else if(localName.equals("plaintext") && inResults)
        {
            inPlainText = true;
        }
        else
        {

        }
    }
    public void endElement(String uri, String localName, String qName)throws SAXException
    {
        if(localName.equals("pod") && inResults)
        {
            inResults  = false;
        }
        else if(localName.equals("plaintext") && inResults)
        {
            inPlainText = false;
        }
        else
        {
            
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

import java.net.URLEncoder;
/**
 * Write a description of class PhyCalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhyCalc
{
    WolfInter Cal = new WolfInter();
    public String forceToAcc(String F, String m)
    {
        try{
            return Cal.useFunc(URLEncoder.encode(F +"/"+m, "UTF-8"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }

    public String impulseToVel(String I, String m)
    {
        try{
            return Cal.useFunc(URLEncoder.encode(I +"/"+m, "UTF-8"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }

    public String accToPos(String a)
    {
        try{
            return Cal.useFunc(URLEncoder.encode("integral " + Cal.useFunc(URLEncoder.encode("integral " + a, "UTF-8")), "UTF-8"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
}

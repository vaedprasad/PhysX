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

    public String accToPos(String a, String vel, String pos)
    {
        try{
            String v = Cal.useFunc(URLEncoder.encode("integral " + a, "UTF-8"));
            v = v.substring(0, v.length()-8) + vel;
            String x = Cal.useFunc(URLEncoder.encode("integral " + v, "UTF-8"));
            x = x.substring(0, x.length()-8) + pos;
            return x;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
}

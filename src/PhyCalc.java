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
        //System.out.print("\f");
        try{
            String v = Cal.useFunc(URLEncoder.encode("int " + a, "UTF-8"));
            v = v.substring(a.length() + 15, v.length()-9);
            if(!vel.equals("0"))
                v += "+" + vel;
            String x = Cal.useFunc(URLEncoder.encode("int " + v, "UTF-8"));
            x = x.substring(v.length() + 15, x.length()-9);
            if(!pos.equals("0"))
                x += "+" + pos;
            return x;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
}

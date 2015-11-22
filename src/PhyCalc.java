
/**
 * Write a description of class PhyCalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhyCalc
{
    WolfInter Cal = new WolfInter();
    public String forceToPos(String F, String m)
    {
        return Cal.useFunc("integral integral "+F+"/"+m);
    }
    public static double impulseToVel(double I, double m)
    {
        return I/m;
    }
    public static double der(double val1, double val2, double res)
    {
        return (val2 - val1)/res;
    }
    public static double integ(double val1, double val2, double res)
    {
        return (val2*res - val1*res);
    }
}

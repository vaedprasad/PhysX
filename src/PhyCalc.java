
/**
 * Write a description of class PhyCalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhyCalc
{
    public static double forceToAcc(double F, double m)
    {
        return F/m;
    }
    public static double impulseToVel(double I, double m)
    {
        return I/m;
    }
    public static double der(double val1, double val2, double res)
    {
        return (val2 - val1)/res;
    }
    
}

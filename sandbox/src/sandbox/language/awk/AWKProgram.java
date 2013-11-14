package sandbox.language.awk;


import org.modelcc.IModel;

public class AWKProgram implements IModel
{
    AWKRule[] rules;


    public AWKRule[] getRules()
    {
    	return rules;
    }
    
    public AWKRule getRule (int n)
    {
    	return rules[n];
    }
}

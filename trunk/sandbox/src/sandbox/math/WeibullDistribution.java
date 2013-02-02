package sandbox.math;

/**
 * Weibull distribution (generalization of the exponential distribution, useful in hazard, survival, or reliability studies)
 * http://en.wikipedia.org/wiki/Weibull_distribution
 * 
 * @author Fernando Berzal (berzal@acm.org)
 */
public class WeibullDistribution implements Distribution 
{
	private double alpha;
	private double beta;
	
	public WeibullDistribution (double alpha, double beta)
	{
		this.alpha = alpha;
		this.beta = beta;
	}
	
	@Override
	public double pdf (double x) 
	{
		if (x<0)
			return 0;
		else
			return (alpha/beta) * Math.pow(x/beta, alpha-1) * Math.exp ( -Math.pow(x/beta,alpha) );
	}

	@Override
	public double cdf (double x) 
	{
		if (x<0)
			return 0;
		else
			return 1 - Math.exp( -Math.pow(x/beta,alpha) );
	}

	@Override
	public double idf (double p) 
	{
		if (p==0)
			return 0;
		else if (p==1)
			return Double.POSITIVE_INFINITY;
		else
			return beta * Math.pow( -Math.log(1-p), 1/alpha );
	}
	
	@Override
	public double random() 
	{
		// TODO Random number generator
		return 0;
	}

}

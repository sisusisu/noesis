package sandbox.ai;

//Title:       Sudoku
//Version:     1.0
//Copyright:   2011
//Author:      Fernando Berzal Galiano
//E-mail:      berzal@acm.org

/**
 * Implementaci�n base para la resoluci�n de un Sudoku.
 * 
 * @author Fernando Berzal
 */

public abstract class Solver 
{
	protected Problem problem;
	
	
	/**
	 * Constructor
	 * @param problem CSP problem
	 */
	public Solver (Problem problem)
	{
		this.problem = problem;
	}
	
	
	public boolean check ()
	{
		return problem.check();
	}

	public boolean isSolved ()
	{
		return problem.isSolved();
	}

	
	/**
	 * Resoluci�n de problemas de satisfacci�n de restricciones
	 */
	public abstract void solve();
	
	
	/**
     * Representaci�n del problema como una cadena de caracteres
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		return problem.toString();
	}

}

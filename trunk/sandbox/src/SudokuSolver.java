//Title:       Sudoku
//Version:     0.1
//Copyright:   2011
//Author:      Fernando Berzal Galiano
//E-mail:      berzal@acm.org


/**
 * Implementaci�n base para la resoluci�n de un Sudoku.
 * 
 * @author Fernando Berzal
 */

public class SudokuSolver 
{
	sandbox.ai.Solver solver;
	
	/**
	 * Constructor
	 * @param template Cadena representando una plantilla de sudoku
	 */
	public SudokuSolver (String template)
	{
		solver = new sandbox.ai.BacktrackingSolver(new sandbox.ai.SudokuX(template));  	
	}
	
	
	/**
	 * Resoluci�n de sudokus
	 */
	public void solve()
	{
		solver.solve();
	}
	
	
	/**
     * Representaci�n del sudoku como una cadena de caracteres
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		return solver.toString();
	}

}
 
                
 

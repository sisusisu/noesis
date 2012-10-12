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

public class SudokuSolver extends sandbox.ai.BacktrackingSolver 
{
	
	/**
	 * Constructor
	 * @param template Cadena representando una plantilla de sudoku
	 */
	public SudokuSolver (String template)
	{
		super(new sandbox.ai.SudokuX(template));
	}
	
	
	/**
	 * Resoluci�n de sudokus
	 */
	public void solve()
	{
		super.solve();
	}
	
	
	/**
     * Representaci�n del sudoku como una cadena de caracteres
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		return super.toString();
	}

}

// Title:       Sudoku
// Version:     0.1
// Copyright:   2012
// Author:      Fernando Berzal Galiano
// E-mail:      berzal@acm.org

import sandbox.ai.*;

/**
 * Implementaci�n base para la resoluci�n de un Sudoku hexadecimal.
 * 
 * @author Fernando Berzal
 */

public class SudokuHex 
{
	
	BacktrackingSolver solver;
	
	/**
	 * Constructor
	 * @param template Cadena representando una plantilla de sudoku
	 */
	public SudokuHex (String template)
	{
		solver = new BacktrackingSolver (new sandbox.ai.SudokuHex(template));
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
 
                
 

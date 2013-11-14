package sandbox.language.bc;

import org.modelcc.*;

@Pattern(regExp="[a-zA-Z_��]([a-zA-Z_��]|[0-9])*")
public class Identifier extends Expression implements IModel
{

	@Value
	private String id;
	
	public String toString ()
	{
		return id;
	}
}

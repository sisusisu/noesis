package sandbox.mdsd.test;

import ikor.math.Decimal;

import sandbox.mdsd.Subject;

import sandbox.mdsd.data.DecimalModel;
import sandbox.mdsd.log.Log;

import sandbox.mdsd.ui.Application;
import sandbox.mdsd.ui.Editor;
import sandbox.mdsd.ui.Viewer;
import sandbox.mdsd.ui.UIModel;

public class MVCModel extends UIModel
{
	class MVCData extends Subject<Decimal>
	{
		Decimal number;
		
		public Decimal getNumber() 
		{
			return number;
		}

		public void setNumber(Decimal number) 
		{
			this.number = number;
			
			notifyObservers(number);
		}
		
		@Override
		public void update (Subject subject, Decimal object) 
		{
			Log.info("MVC - "+object+" @ "+subject);
			setNumber( object );		
		}
	}
	
	
	public MVCModel (Application app)
	{
		super(app, "Sinchronized editors & viewers...");
		
		MVCData data = new MVCData();
		
		DecimalModel decimalModel = new DecimalModel();
		decimalModel.setDecimalDigits(2);
		
		Viewer<Decimal> firstViewer = new Viewer<Decimal>("Decimal viewer 1", data, Decimal.class);
		add(firstViewer);

		Viewer<Decimal> secondViewer = new Viewer<Decimal>("Decimal viewer 2", data, Decimal.class);
		add(secondViewer);

		Viewer<Decimal> thirdViewer = new Viewer<Decimal>("Decimal viewer 3 [X.XX]", data, decimalModel);
		add(thirdViewer);

		Editor<Decimal> firstEditor = new Editor<Decimal>("Decimal editor 1", data, Decimal.class);
		add(firstEditor);

		Editor<Decimal> secondEditor = new Editor<Decimal>("Decimal editor 2", data, Decimal.class);
		add(secondEditor);

		Editor<Decimal> thirdEditor = new Editor<Decimal>("Decimal editor 3 [X.XX]", data, decimalModel);
		add(thirdEditor);		
		
		data.setNumber(new Decimal("123.45"));
		
	}
}
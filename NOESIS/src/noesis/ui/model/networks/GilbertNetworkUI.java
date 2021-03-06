package noesis.ui.model.networks;

import ikor.model.data.IntegerModel;
import ikor.model.data.RealModel;

import ikor.model.ui.Action;
import ikor.model.ui.Application;
import ikor.model.ui.Editor;
import ikor.model.ui.Option;

import noesis.AttributeNetwork;

import noesis.algorithms.visualization.RandomLayout;

import noesis.model.random.GilbertNetwork;


public class GilbertNetworkUI extends NewNetworkUI 
{
	Editor<Integer> nodeCountEditor;
	Editor<Double>  probabilityEditor;
	
	public GilbertNetworkUI (Application app) 
	{
		super(app, "New Gilbert random network...");
		
		setIcon( app.url("icon.gif") );
		
		IntegerModel nodeCountModel = new IntegerModel();
		nodeCountModel.setMinimumValue(0);
		nodeCountModel.setMaximumValue(1000);
		
		nodeCountEditor = new Editor<Integer>("Number of network nodes", nodeCountModel);
		nodeCountEditor.setIcon( app.url("icons/calculator.png") );
		nodeCountEditor.setData(100);
		add(nodeCountEditor);
		
		RealModel probabilityModel = new RealModel();
		probabilityModel.setMinimumValue( 0.0 );
		probabilityModel.setMaximumValue( 1.0 );
		
		probabilityEditor = new Editor<Double>("Link probability", probabilityModel);
		probabilityEditor.setIcon( app.url("icons/calculator.png") );
		probabilityEditor.setData( 0.1 );
		add(probabilityEditor);
		
		Option ok = new Option("Create");
		ok.setIcon( app.url("icon.gif") );
		ok.setAction( new ConnectedRandomNetworkAction(this) );
		add(ok);		
	}
	
	// Action
	
	public class ConnectedRandomNetworkAction extends Action 
	{
		private GilbertNetworkUI ui;

		public ConnectedRandomNetworkAction (GilbertNetworkUI ui)
		{
			this.ui = ui;
		}

		@Override
		public void run() 
		{
			int nodes = ui.nodeCountEditor.getData();
			double probability = ui.probabilityEditor.getData();
			
			GilbertNetwork random = new GilbertNetwork(nodes,probability);
			AttributeNetwork network = createAttributeNetwork(random, "Gilbert random network", new RandomLayout ());			
			
			ui.set("network", network);
			ui.exit();
		}	
	}	

}

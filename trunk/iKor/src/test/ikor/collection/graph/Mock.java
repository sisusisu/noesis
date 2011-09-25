package test.ikor.collection.graph;

import ikor.collection.graph.DynamicGraph;

public class Mock {
	
	public static DynamicGraph<String,Integer> roadmap ()
	{
		DynamicGraph<String,Integer> graph = new DynamicGraph<String,Integer>(false);

		graph.add("Granada");
		graph.add("Motril");
		graph.add("La Zubia");
		graph.add("C�jar");
		graph.add("Hu�tor Vega");
		graph.add("Castell de Ferro");
		graph.add("Almer�a");
		graph.add("Guadix");

		graph.add("Granada", "Motril", 70);
		graph.add("Granada", "La Zubia", 3);
		graph.add("Granada", "C�jar", 3);
		graph.add("Granada", "Hu�tor Vega", 2);
		graph.add("Hu�tor Vega", "C�jar", 1);
		graph.add("C�jar", "La Zubia", 1);
		graph.add("Motril", "Castell de Ferro", 20);
		graph.add("Castell de Ferro", "Almer�a", 94);
		graph.add("Guadix", "Almer�a", 106);
		graph.add("Granada", "Guadix", 55);

		return graph;
	}

	
	public static DynamicGraph<String,String> web ()
	{
		DynamicGraph<String,String> graph = new DynamicGraph<String,String>(true);

		graph.add("home");
		graph.add("C");
		graph.add("C#");
		graph.add("C++Builder");
		graph.add("Java");
		graph.add("DB");
		graph.add("Data Mining");
		graph.add("Internet");
		graph.add("ASP.NET");

		graph.add("home", "C", null);
		graph.add("home", "C#", null);
		graph.add("home", "C++Builder", null);
		graph.add("home", "Java", null);
		graph.add("home", "Internet", null);
		graph.add("home", "ASP.NET", null);
		graph.add("home", "DB", null);
		graph.add("home", "Data Mining", null);
		graph.add("C", "C#", null);
		graph.add("C", "C++Builder", null);
		graph.add("C", "Java", null);
		graph.add("C#", "ASP.NET", null);
		graph.add("Java", "C", null);
		graph.add("Java", "C#", null);
		graph.add("Java", "C++Builder", null);
		graph.add("DB", "Data Mining", null);
		graph.add("Internet", "DB", null);

		return graph;		
	}
	

}

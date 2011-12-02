package test.noesis.algorithms.traversal;

import noesis.Network;
import noesis.ArrayNetwork;

public class MockObjects {
	
	// Undirected graph
	
	public static Network<String,Integer> roadmap ()
	{
		Network<String,Integer> net = new ArrayNetwork<String,Integer>();

		net.add("Granada");
		net.add("Motril");
		net.add("La Zubia");
		net.add("C�jar");
		net.add("Hu�tor Vega");
		net.add("Castell de Ferro");
		net.add("Almer�a");
		net.add("Guadix");

		net.add2("Granada", "Motril", 70);
		net.add2("Granada", "La Zubia", 3);
		net.add2("Granada", "C�jar", 3);
		net.add2("Granada", "Hu�tor Vega", 2);
		net.add2("Hu�tor Vega", "C�jar", 1);
		net.add2("C�jar", "La Zubia", 1);
		net.add2("Motril", "Castell de Ferro", 20);
		net.add2("Castell de Ferro", "Almer�a", 94);
		net.add2("Guadix", "Almer�a", 106);
		net.add2("Granada", "Guadix", 55);

		return net;
	}
	
	
	public static MockVisitor<String> roadmapBFSVisitor (Network<String,Integer> roadmap)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();
		
		visitor.addVisit("Granada");
		visitor.addVisit("Motril");
		visitor.addVisit("La Zubia");
		visitor.addVisit("C�jar");
		visitor.addVisit("Hu�tor Vega");
		visitor.addVisit("Guadix");
		
		visitor.addVisit("Castell de Ferro");
		
		visitor.addVisit("Almer�a");
		
		return visitor;
	}

	
	public static MockVisitor<String> roadmapDFSVisitor (Network<String,Integer> roadmap)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();
		
		visitor.addVisit("Granada");
		visitor.addVisit("Motril");
		visitor.addVisit("Castell de Ferro");
		visitor.addVisit("Almer�a");
		visitor.addVisit("Guadix");
		
		visitor.addVisit("La Zubia");
		visitor.addVisit("C�jar");
		visitor.addVisit("Hu�tor Vega");		
		
		return visitor;
	}	

	
	public static MockVisitor<Integer> roadmapBFSLinkVisitor (Network<String,Integer> map)
	{
		MockVisitor<Integer> visitor = new MockVisitor<Integer>();
		
		visitor.addVisit(map.get("Granada", "Motril"));
		visitor.addVisit(map.get("Granada", "La Zubia"));
		visitor.addVisit(map.get("Granada", "C�jar"));
		visitor.addVisit(map.get("Granada", "Hu�tor Vega"));
		visitor.addVisit(map.get("Granada", "Guadix"));

		visitor.addVisit(map.get("Motril", "Granada"));
		visitor.addVisit(map.get("Motril", "Castell de Ferro"));

		visitor.addVisit(map.get("La Zubia", "Granada"));
		visitor.addVisit(map.get("La Zubia", "C�jar"));
		
		visitor.addVisit(map.get("C�jar", "Granada"));
		visitor.addVisit(map.get("C�jar", "Hu�tor Vega"));
		visitor.addVisit(map.get("C�jar", "La Zubia"));

		visitor.addVisit(map.get("Hu�tor Vega", "Granada"));
		visitor.addVisit(map.get("Hu�tor Vega", "C�jar"));

		visitor.addVisit(map.get("Guadix", "Almer�a"));
		visitor.addVisit(map.get("Guadix", "Granada"));
	
		visitor.addVisit(map.get("Castell de Ferro", "Motril"));
		visitor.addVisit(map.get("Castell de Ferro", "Almer�a"));

		visitor.addVisit(map.get("Almer�a", "Castell de Ferro"));
		visitor.addVisit(map.get("Almer�a", "Guadix"));

		return visitor;
	}

	
	public static MockVisitor<Integer> roadmapDFSLinkVisitor (Network<String,Integer> map)
	{
		MockVisitor<Integer> visitor = new MockVisitor<Integer>();
		
		visitor.addVisit(map.get("Granada", "Motril"));

		visitor.addVisit(map.get("Motril", "Granada"));
		visitor.addVisit(map.get("Motril", "Castell de Ferro"));
		
		visitor.addVisit(map.get("Castell de Ferro", "Motril"));
		visitor.addVisit(map.get("Castell de Ferro", "Almer�a"));

		visitor.addVisit(map.get("Almer�a", "Castell de Ferro"));
		visitor.addVisit(map.get("Almer�a", "Guadix"));

		visitor.addVisit(map.get("Guadix", "Almer�a"));
		visitor.addVisit(map.get("Guadix", "Granada"));
		
		visitor.addVisit(map.get("Granada", "La Zubia"));

		visitor.addVisit(map.get("La Zubia", "Granada"));
		visitor.addVisit(map.get("La Zubia", "C�jar"));
		
		visitor.addVisit(map.get("C�jar", "Granada"));
		visitor.addVisit(map.get("C�jar", "Hu�tor Vega"));

		visitor.addVisit(map.get("Hu�tor Vega", "Granada"));
		visitor.addVisit(map.get("Hu�tor Vega", "C�jar"));
		
		visitor.addVisit(map.get("C�jar", "La Zubia"));
		
		visitor.addVisit(map.get("Granada", "C�jar"));
		visitor.addVisit(map.get("Granada", "Hu�tor Vega"));
		visitor.addVisit(map.get("Granada", "Guadix"));

		return visitor;
	}	
	
	// Directed graph
	
	public static Network<String,String> web ()
	{
		Network<String,String> graph = new ArrayNetwork<String,String>();

		graph.add("home");
		graph.add("C");
		graph.add("C#");
		graph.add("C++Builder");
		graph.add("Java");
		graph.add("DB");
		graph.add("Data Mining");
		graph.add("Internet");
		graph.add("ASP.NET");

		graph.add("home", "C");
		graph.add("home", "C#");
		graph.add("home", "C++Builder");
		graph.add("home", "Java");
		graph.add("home", "Internet");
		graph.add("home", "ASP.NET");
		graph.add("home", "DB");
		graph.add("home", "Data Mining");
		graph.add("C", "C#");
		graph.add("C", "C++Builder");
		graph.add("C", "Java");
		graph.add("C#", "ASP.NET");
		graph.add("Java", "C");
		graph.add("Java", "C#");
		graph.add("Java", "C++Builder");
		graph.add("DB", "Data Mining");
		graph.add("Internet", "DB");

		return graph;		
	}

	public static MockVisitor<String> webBFSVisitor (Network<String,String> web)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();

		visitor.addVisit("home");

		visitor.addVisit("C");
		visitor.addVisit("C#");
		visitor.addVisit("C++Builder");
		visitor.addVisit("Java");
		visitor.addVisit("Internet");
		visitor.addVisit("ASP.NET");
		visitor.addVisit("DB");
		visitor.addVisit("Data Mining");		
		
		return visitor;
	}
	
	public static MockVisitor<String> webDFSVisitor (Network<String,String> web)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();
	
		visitor.addVisit("home");
		visitor.addVisit("C");
		visitor.addVisit("C#");
		visitor.addVisit("ASP.NET");
		
		// C
		visitor.addVisit("C++Builder");
		visitor.addVisit("Java");
		
		// home
		visitor.addVisit("Internet");
		visitor.addVisit("DB");
		visitor.addVisit("Data Mining");		
		
		return visitor;
	}
	
	
	public static MockVisitor<String> webBFSLinkVisitor (Network<String,String> web)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();
		
		visitor.addVisit(web.get("home", "C"));
		visitor.addVisit(web.get("home", "C#"));
		visitor.addVisit(web.get("home", "C++Builder"));
		visitor.addVisit(web.get("home", "Java"));
		visitor.addVisit(web.get("home", "Internet"));
		visitor.addVisit(web.get("home", "ASP.NET"));
		visitor.addVisit(web.get("home", "DB"));
		visitor.addVisit(web.get("home", "Data Mining"));
		visitor.addVisit(web.get("C", "C#"));
		visitor.addVisit(web.get("C", "C++Builder"));
		visitor.addVisit(web.get("C", "Java"));
		visitor.addVisit(web.get("C#", "ASP.NET"));
		visitor.addVisit(web.get("Java", "C"));
		visitor.addVisit(web.get("Java", "C#"));
		visitor.addVisit(web.get("Java", "C++Builder"));
		visitor.addVisit(web.get("Internet", "DB"));
		visitor.addVisit(web.get("DB", "Data Mining"));
		
		return visitor;
	}

	public static MockVisitor<String> webDFSLinkVisitor (Network<String,String> web)
	{
		MockVisitor<String> visitor = new MockVisitor<String>();
		
		visitor.addVisit(web.get("home", "C"));
		visitor.addVisit(web.get("C", "C#"));
		visitor.addVisit(web.get("C#", "ASP.NET"));

		visitor.addVisit(web.get("C", "C++Builder"));
		visitor.addVisit(web.get("C", "Java"));
		visitor.addVisit(web.get("Java", "C"));
		visitor.addVisit(web.get("Java", "C#"));
		visitor.addVisit(web.get("Java", "C++Builder"));
		
		visitor.addVisit(web.get("home", "C#"));
		visitor.addVisit(web.get("home", "C++Builder"));
		visitor.addVisit(web.get("home", "Java"));
		visitor.addVisit(web.get("home", "Internet"));

		visitor.addVisit(web.get("Internet", "DB"));
		visitor.addVisit(web.get("DB", "Data Mining"));
		
		visitor.addVisit(web.get("home", "ASP.NET"));
		visitor.addVisit(web.get("home", "DB"));
		visitor.addVisit(web.get("home", "Data Mining"));
		
		return visitor;
	}
	
}

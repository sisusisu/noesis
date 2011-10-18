package test.ikor.collection.graph;

import test.ikor.collection.MockVisitor;
import ikor.collection.graph.DynamicGraph;
import ikor.collection.graph.ExplicitGraph;
import ikor.collection.graph.Link;
import ikor.collection.graph.Node;

public class MockObjects {
	
	// Undirected graph
	
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
	
	
	public static MockVisitor<Node<String,Integer>> roadmapBFSVisitor (ExplicitGraph<String,Integer> roadmap)
	{
		MockVisitor<Node<String,Integer>> visitor = new MockVisitor<Node<String,Integer>>();
		
		visitor.addVisit(roadmap.getNode("Granada"));
		visitor.addVisit(roadmap.getNode("Motril"));
		visitor.addVisit(roadmap.getNode("La Zubia"));
		visitor.addVisit(roadmap.getNode("C�jar"));
		visitor.addVisit(roadmap.getNode("Hu�tor Vega"));
		visitor.addVisit(roadmap.getNode("Guadix"));
		
		visitor.addVisit(roadmap.getNode("Castell de Ferro"));
		
		visitor.addVisit(roadmap.getNode("Almer�a"));
		
		return visitor;
	}

	
	public static MockVisitor<Node<String,Integer>> roadmapDFSVisitor (ExplicitGraph<String,Integer> roadmap)
	{
		MockVisitor<Node<String,Integer>> visitor = new MockVisitor<Node<String,Integer>>();
		
		visitor.addVisit(roadmap.getNode("Granada"));
		visitor.addVisit(roadmap.getNode("Motril"));
		visitor.addVisit(roadmap.getNode("Castell de Ferro"));
		visitor.addVisit(roadmap.getNode("Almer�a"));
		visitor.addVisit(roadmap.getNode("Guadix"));
		
		visitor.addVisit(roadmap.getNode("La Zubia"));
		visitor.addVisit(roadmap.getNode("C�jar"));
		visitor.addVisit(roadmap.getNode("Hu�tor Vega"));		
		
		return visitor;
	}	

	
	public static MockVisitor<Link<String,Integer>> roadmapBFSLinkVisitor (ExplicitGraph<String,Integer> map)
	{
		MockVisitor<Link<String,Integer>> visitor = new MockVisitor<Link<String,Integer>>();
		
		visitor.addVisit(map.getLink("Granada", "Motril"));
		visitor.addVisit(map.getLink("Granada", "La Zubia"));
		visitor.addVisit(map.getLink("Granada", "C�jar"));
		visitor.addVisit(map.getLink("Granada", "Hu�tor Vega"));
		visitor.addVisit(map.getLink("Granada", "Guadix"));

		visitor.addVisit(map.getLink("Motril", "Granada"));
		visitor.addVisit(map.getLink("Motril", "Castell de Ferro"));

		visitor.addVisit(map.getLink("La Zubia", "Granada"));
		visitor.addVisit(map.getLink("La Zubia", "C�jar"));
		
		visitor.addVisit(map.getLink("C�jar", "Granada"));
		visitor.addVisit(map.getLink("C�jar", "Hu�tor Vega"));
		visitor.addVisit(map.getLink("C�jar", "La Zubia"));

		visitor.addVisit(map.getLink("Hu�tor Vega", "Granada"));
		visitor.addVisit(map.getLink("Hu�tor Vega", "C�jar"));

		visitor.addVisit(map.getLink("Guadix", "Almer�a"));
		visitor.addVisit(map.getLink("Guadix", "Granada"));
	
		visitor.addVisit(map.getLink("Castell de Ferro", "Motril"));
		visitor.addVisit(map.getLink("Castell de Ferro", "Almer�a"));

		visitor.addVisit(map.getLink("Almer�a", "Castell de Ferro"));
		visitor.addVisit(map.getLink("Almer�a", "Guadix"));

		return visitor;
	}

	
	public static MockVisitor<Link<String,Integer>> roadmapDFSLinkVisitor (ExplicitGraph<String,Integer> map)
	{
		MockVisitor<Link<String,Integer>> visitor = new MockVisitor<Link<String,Integer>>();
		
		visitor.addVisit(map.getLink("Granada", "Motril"));

		visitor.addVisit(map.getLink("Motril", "Granada"));
		visitor.addVisit(map.getLink("Motril", "Castell de Ferro"));
		
		visitor.addVisit(map.getLink("Castell de Ferro", "Motril"));
		visitor.addVisit(map.getLink("Castell de Ferro", "Almer�a"));

		visitor.addVisit(map.getLink("Almer�a", "Castell de Ferro"));
		visitor.addVisit(map.getLink("Almer�a", "Guadix"));

		visitor.addVisit(map.getLink("Guadix", "Almer�a"));
		visitor.addVisit(map.getLink("Guadix", "Granada"));
		
		visitor.addVisit(map.getLink("Granada", "La Zubia"));

		visitor.addVisit(map.getLink("La Zubia", "Granada"));
		visitor.addVisit(map.getLink("La Zubia", "C�jar"));
		
		visitor.addVisit(map.getLink("C�jar", "Granada"));
		visitor.addVisit(map.getLink("C�jar", "Hu�tor Vega"));

		visitor.addVisit(map.getLink("Hu�tor Vega", "Granada"));
		visitor.addVisit(map.getLink("Hu�tor Vega", "C�jar"));
		
		visitor.addVisit(map.getLink("C�jar", "La Zubia"));
		
		visitor.addVisit(map.getLink("Granada", "C�jar"));
		visitor.addVisit(map.getLink("Granada", "Hu�tor Vega"));
		visitor.addVisit(map.getLink("Granada", "Guadix"));

		return visitor;
	}	
	
	// Directed graph
	
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

	public static MockVisitor<Node<String,String>> webBFSVisitor (ExplicitGraph<String,String> web)
	{
		MockVisitor<Node<String,String>> visitor = new MockVisitor<Node<String,String>>();

		visitor.addVisit(web.getNode("home"));

		visitor.addVisit(web.getNode("C"));
		visitor.addVisit(web.getNode("C#"));
		visitor.addVisit(web.getNode("C++Builder"));
		visitor.addVisit(web.getNode("Java"));
		visitor.addVisit(web.getNode("Internet"));
		visitor.addVisit(web.getNode("ASP.NET"));
		visitor.addVisit(web.getNode("DB"));
		visitor.addVisit(web.getNode("Data Mining"));		
		
		return visitor;
	}
	
	public static MockVisitor<Node<String,String>> webDFSVisitor (ExplicitGraph<String,String> web)
	{
		MockVisitor<Node<String,String>> visitor = new MockVisitor<Node<String,String>>();
	
		visitor.addVisit(web.getNode("home"));
		visitor.addVisit(web.getNode("C"));
		visitor.addVisit(web.getNode("C#"));
		visitor.addVisit(web.getNode("ASP.NET"));
		
		// C
		visitor.addVisit(web.getNode("C++Builder"));
		visitor.addVisit(web.getNode("Java"));
		
		// home
		visitor.addVisit(web.getNode("Internet"));
		visitor.addVisit(web.getNode("DB"));
		visitor.addVisit(web.getNode("Data Mining"));		
		
		return visitor;
	}
	
	
	public static MockVisitor<Link<String,String>> webBFSLinkVisitor (ExplicitGraph<String,String> web)
	{
		MockVisitor<Link<String,String>> visitor = new MockVisitor<Link<String,String>>();
		
		visitor.addVisit(web.getLink("home", "C"));
		visitor.addVisit(web.getLink("home", "C#"));
		visitor.addVisit(web.getLink("home", "C++Builder"));
		visitor.addVisit(web.getLink("home", "Java"));
		visitor.addVisit(web.getLink("home", "Internet"));
		visitor.addVisit(web.getLink("home", "ASP.NET"));
		visitor.addVisit(web.getLink("home", "DB"));
		visitor.addVisit(web.getLink("home", "Data Mining"));
		visitor.addVisit(web.getLink("C", "C#"));
		visitor.addVisit(web.getLink("C", "C++Builder"));
		visitor.addVisit(web.getLink("C", "Java"));
		visitor.addVisit(web.getLink("C#", "ASP.NET"));
		visitor.addVisit(web.getLink("Java", "C"));
		visitor.addVisit(web.getLink("Java", "C#"));
		visitor.addVisit(web.getLink("Java", "C++Builder"));
		visitor.addVisit(web.getLink("Internet", "DB"));
		visitor.addVisit(web.getLink("DB", "Data Mining"));
		
		return visitor;
	}

	public static MockVisitor<Link<String,String>> webDFSLinkVisitor (ExplicitGraph<String,String> web)
	{
		MockVisitor<Link<String,String>> visitor = new MockVisitor<Link<String,String>>();
		
		visitor.addVisit(web.getLink("home", "C"));
		visitor.addVisit(web.getLink("C", "C#"));
		visitor.addVisit(web.getLink("C#", "ASP.NET"));

		visitor.addVisit(web.getLink("C", "C++Builder"));
		visitor.addVisit(web.getLink("C", "Java"));
		visitor.addVisit(web.getLink("Java", "C"));
		visitor.addVisit(web.getLink("Java", "C#"));
		visitor.addVisit(web.getLink("Java", "C++Builder"));
		
		visitor.addVisit(web.getLink("home", "C#"));
		visitor.addVisit(web.getLink("home", "C++Builder"));
		visitor.addVisit(web.getLink("home", "Java"));
		visitor.addVisit(web.getLink("home", "Internet"));

		visitor.addVisit(web.getLink("Internet", "DB"));
		visitor.addVisit(web.getLink("DB", "Data Mining"));
		
		visitor.addVisit(web.getLink("home", "ASP.NET"));
		visitor.addVisit(web.getLink("home", "DB"));
		visitor.addVisit(web.getLink("home", "Data Mining"));
		
		return visitor;
	}
	
}

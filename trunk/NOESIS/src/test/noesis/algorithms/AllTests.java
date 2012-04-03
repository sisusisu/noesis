package test.noesis.algorithms;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { test.noesis.algorithms.mst.MinimumSpanningTreeTest.class,
					   test.noesis.algorithms.paths.PathFinderTest.class,
					   test.noesis.algorithms.paths.AStarPathFinderTest.class,
					   test.noesis.algorithms.traversal.NetworkTraversalTest.class,
					   test.noesis.algorithms.traversal.TopologicalSortTest.class,
					   test.noesis.algorithms.traversal.ConnectedComponentsTest.class,
					   test.noesis.algorithms.traversal.StronglyConnectedComponentsTest.class})
public class AllTests {

}
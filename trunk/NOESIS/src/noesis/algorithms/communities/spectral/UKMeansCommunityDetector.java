package noesis.algorithms.communities.spectral;

// Title:       Spectral K-Means algorithm
// Version:     1.0
// Copyright:   2014
// Author:      Fco. Javier Gijon & Aaron Rosas
// E-mail:      fcojaviergijon@gmail.com & aarr90@gmail.com

import ikor.math.DenseMatrix;
import ikor.math.DenseVector;
import ikor.model.data.annotations.Description;
import ikor.model.data.annotations.Label;
import noesis.AttributeNetwork;

/**
 * Spectral K-Means algorithm
 *
 * @author Aaron Rosas (aarr90@gmail.com) & Fco. Javier Gijon (fcojaviergijon@gmail.com)
 */
@Label("UKMeans")
@Description("Spectral k-means community detection algorithm")
public class UKMeansCommunityDetector extends SpectralCommunityDetector 
{
    private int K;

    public UKMeansCommunityDetector(AttributeNetwork network) 
    {
    	this(network, (int) Math.sqrt(network.size()));
    }
    
    public UKMeansCommunityDetector(AttributeNetwork network, int clusters) 
    {
        super(network);
        K = clusters > 0 ? clusters : 1;
    }

    @Override
    public void compute() 
    {
        // Adjacency matrix
        DenseMatrix W = AdjacencyMatrix(an);
        // Diagonal degree matrix (Dii -> degree of node i)
        DenseMatrix D = DegreeMatrix(an);
        // Laplacian matrix no normalized
        DenseMatrix L = LaplacianMatrix(W, D, Normalized.NO);
        // Create matrix with k first Eigenvectors of Laplacian matrix --- 
        DenseMatrix E = EigenvectorsMatrix(L, K);

        // K-means algorithm 
        DenseVector CL = KMeans(E, K, 1e10);

        // Save results
        for (int i = 0; i < results.columns(); ++i) {
            results.set(0, i, CL.get(i));
        }
    }
}
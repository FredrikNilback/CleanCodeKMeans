#CleanCode - Assignment 3.

This is an assignment to practice clean code, the SOLID principles and Design Patterns, 
aswell as making our own algorithm from scratch. I chose to make a K-Means, and a DBSCAN clustering algorithm. 

**About K-Means:

*K-Means
K-Means is a clustering algorithm that works by letting the user define the number of groups they wish to divide their data set in to, the so called "K-value".
Depending on how many groups the user want, that same amount of "Centroids" are created.
The centroids' purposes are to keep track of where the "center of mass" of their current group is. 
At the beginning, each centroid gets a random location within the dataset. The datapoints are then assigned to the centroid that they are closest to.
After being assigned, the average position of each datapoint is calculated, and the centroids are moved there. 
This process is then repeated until each centroid has reached a stable position, or the program has reached it's max iterations (specified by the user in this case).

*DBSCAN
DBSCAN (Density-Based Spatial Clustering of Applications with Noise) is a clustering algorithm that does not initially know how many groups to divide the data in to.
It works by having the user input an "epsilon" value aswell as a "minimum data points" value. 
The Epsilon value determines the distance each datapoint is "allowed" to look within to find neighbors.
The minimum data points value determines how many datapoints must be found within the allowed range in order for that data point to be considered a "core data point".
Core datapoint are created at the start of the DBSCAN. Then these datapoints look for what other datapoints are within it's reach (decided by epsilon).
If a datapoint is within the core reach, it is added to that core's cluster. 
This process repeats for each datapoint that is now part of the new cluster until the clusters all have stopped growing. 
When they have stopped growing (meaning no new datapoints can be found within reach), the clustering stops.
This means not every datapoint is necessarily added to a cluster, and these are branded as outliers. 



**Desgin Patterns used:

*MVC (Model-View-Control)
The code is divided up in to 3 sections, each section has it's own distinct purpose. 

View is responsible for everything that is displayed to the user. 
It doesn't contain any logic, except for just checking that any pixel that it's ordered to draw, actually falls within the bounds of the JLabel.

Model houses everything that has to do with the actual logic. 
It contains the Clustering algorithms, and it keeps track of all the datapoints and centroids (when using K-Means).

Controller is reponsible for handeling user inputs, and translating those user inputs to the model.
It's also responsible for controlling what is painted in the View. It acts as a bridge between the View and the Model. 


*Strategy Pattern
In model there are 2 clustering algorithms, K-Means and DBSCAN.
They both work pretty differently, but with the same ultimate goal, to cluster the datapoints.
So to make it easier to control, aswell as making it easier to add new clustering algorithms in the future, they both implement IClustering.
The Interface IClustering has one method: run(), which runs the clustering algorithm. 
Depending on user inputs, a different Algorithm is created and "housed" within the IClustering. 

*Observer Pattern
The buttons have actionListeners, which change the way the View looks. 
They both change the label, and outputs the data in a manner that is very readable for a human.
When the clustering algorithm is done it changes the colors of all the data points, making it easy to understand and interperate the results.
And it also outputs the "raw" text, so that the user can see it in a more plain form. 

In short, the buttons update the View to display the changes the user and the model makes.

*Template Method Pattern
The Clustering algorithms, in addition to having a common Interface, they also share an Abstract Superclass called SuperCluster.
By extending this class it reinforces a certain template to be followed when making new Clustering Algorithms. 

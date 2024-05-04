# CleanCode - Assignment 3.

**This is an assignment to practice clean code, the SOLID principles and Design Patterns, 
aswell as making our own algorithm from scratch. I chose to make a K-Means, and a DBSCAN clustering algorithm.**

## Clustering Algorithms:

### K-Means
K-Means is a clustering algorithm that works by letting the user define the number of groups they wish to divide their data set in to, the so called "K-value".
Depending on how many groups the user want, that same amount of "Centroids" are created.
The centroids' purposes are to keep track of where the "center of mass" of their current group is. 
At the beginning, each centroid gets a random location within the dataset. The datapoints are then assigned to the centroid that they are closest to.
After being assigned, the average position of each datapoint is calculated, and the centroids are moved there. 
This process is then repeated until each centroid has reached a stable position, or the program has reached it's max iterations (specified by the user in this case).

The weakness of this clustering algorithm is that it can be heavily affected by outliers, as it always assigns datapoints to a cluster no matter what. 
This means that in datasets with a lot of outliers the clusters can be distorted.

### DBSCAN
DBSCAN (*'Density-Based Spatial Clustering of Applications with Noise'*) is a clustering algorithm that does not initially know how many groups to divide the data in to.
It works by having the user input an "epsilon" value aswell as a "minimum data points" value. 
The Epsilon value determines the distance each datapoint is "allowed" to look within to find neighbors.
The minimum data points value determines how many datapoints must be found within the allowed range in order for that data point to be considered a "core data point".
Core datapoint are created at the start of the DBSCAN. Then these datapoints look for what other datapoints are within it's reach (decided by epsilon).
If a datapoint is within the core reach, it is added to that core's cluster. 
This process repeats for each datapoint that is now part of the new cluster until the clusters all have stopped growing. 
When they have stopped growing (meaning no new datapoints can be found within reach), the clustering stops.
This means not every datapoint is necessarily added to a cluster, and these are branded as outliers. 

The weakness of this type of clustering is that in datasets with varying density it can be very hard to fine tune the two parameters to successfully cluster everything.
i.e If a dataset has 3 "true" clusters, where 2 of the 3 clusters have only 10 data points each, where as the 3rd has 50 datapoints, selecting a good minimum value and epsilon can be hard.
as if the epsilon is too low, and the minumum value is too low, what we might end up with is 2 correct small clusters, and the big cluster gets incorrectly split in to 2 or 3 small clusters.
On the flipside, if the minimum value is too high, we might en up with 0 core points in the small clusters, which will brand them as outliers. 



## Desgin Patterns used:

### MVC (Model-View-Control)

The code is divided up in to 3 sections, each section has it's own distinct purpose. 

View is responsible for everything that is displayed to the user. 
It doesn't contain any logic, except for just checking that any pixel that it's ordered to draw, actually falls within the bounds of the JLabel.

Model houses everything that has to do with the actual logic. 
It contains the Clustering algorithms, and it keeps track of all the datapoints and centroids (when using K-Means).

Controller is reponsible for handeling user inputs, and translating those user inputs to the model.
It's also responsible for controlling what is painted in the View. It acts as a bridge between the View and the Model. 

### Strategy Pattern

In model there are 2 clustering algorithms, K-Means and DBSCAN.
They both work pretty differently, but with the same ultimate goal, to cluster the datapoints.
So to make it easier to control, aswell as making it easier to add new clustering algorithms in the future, they both implement IClustering.
The Interface IClustering has one method: run(), which runs the clustering algorithm. 
Depending on user inputs, a different Algorithm is created and "housed" within the IClustering. 

### Observer Pattern

The buttons have actionListeners, which change the way the View looks. 
They both change the label, and outputs the data in a manner that is very readable for a human.
When the clustering algorithm is done it changes the colors of all the data points, making it easy to understand and interperate the results.
And it also outputs the "raw" text, so that the user can see it in a more plain form. 

In short, the buttons update the View to display the changes the user and the model makes.

### Template Method Pattern

The Clustering algorithms, in addition to having a common Interface, they also share an Abstract Superclass called SuperCluster.
By extending this class it reinforces a certain template to be followed when making new Clustering Algorithms. 

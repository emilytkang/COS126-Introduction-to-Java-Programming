Programming Assignment: Conditionals & Loops

/**********************************************************************
 *  What is the relationship between the number of steps n of the
 *  random walk and the mean squared distance? By relationship, we mean
 *  something like
 *                       mean squared distance = 126 n^9
 *
 *  Briefly justify your answer based on computational experiments.
 *  Describe the experiments and list several data points.
 *********************************************************************/

mean squared distance = n

computational experiments:

Set 1:
~/Downloads/loops> java RandomWalkers 10 100
mean square distance = 9.82

~/Downloads/loops> java RandomWalkers 100 100
mean square distance = 86.42

~/Downloads/loops> java RandomWalkers 1000 100
mean square distance = 788.58

~/Downloads/loops> Java RandomWalkers 10000 100
mean square distance = 11275.44

~/Downloads/loops> java RandomWalkers 100000 100
mean square distance = 99032.62


Set 2:
~/Downloads/loops> java RandomWalkers 100 10
mean square distance = 134.0

~/Downloads/loops> java RandomWalkers 100 100
mean square distance = 95.32

~/Downloads/loops> java RandomWalkers 100 1000
mean square distance = 102.87

~/Downloads/loops> java RandomWalkers 100 10000
mean square distance = 99.863

~/Downloads/loops> java RandomWalkers 100 100000
mean square distance = 99.81046


The first set of computational experiments keeps a fixed number of trials
(trials = 100) while changing number of steps (n). As n increases, the mean
square distance (msd) increases by the same factor. When n = 10, msd = 9.82.
When n = 100, msd = 86.42. According to these two points, when n increases by a
factor of 10, msd also increases by an approximate factor of 10. This suggests
that msd is directly proportional to n in the form n=k(msd) where k =1.

The second set of computational experiments keeps a fixed number of steps
 (n = 100) while changing the number of trials (trials). As trials increases,
 the msd does not change significantly. For example, when trials = 10, msd =
 134.0. When trials = 100000, msd = 99.81. msd does not change significantly
 despite the fact that trials increased between the two data points by a factor
 of 1000. This suggests that msd is solely proportional to n and is not impacted
 by the value of trials. This conclusion is in line with the equation determined
 by the first set of experiments. Thus, mean squared distance = n.
/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 1

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names. ("A Sunday lab TA" or
 *  "Office hours on Thursday" is OK if you don't know their name.)
 **********************************************************************/

Yes or no?

no



/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

no

/**********************************************************************
 *  List any other comments here.
 **********************************************************************/


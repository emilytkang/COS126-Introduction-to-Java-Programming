Programming Assignment: Traveling Salesperson Problem
 
/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/
 
Number of hours: 6
 
 
/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/
 
We looped through the list, checking the distance from the point we wanted to
insert to all the points already in the list, and kept a reference for the
shortest distance. Then, we added the node in after the point to which it
was closest.
 
/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/
 
We inserted the node between each pair of consecutive points and compared
the change in length that occurred when this node was added. We inserted the node
at the point where the length was least impacted.
 
/**********************************************************************
 *  Explain why it's better to use a circularly linked list instead   *
 *  of an array.                                                      *
 **********************************************************************/
 
An array has a fixed size, whereas a circularly linked list does not. This
is important, as we need to be able to add points to the tour.
 
/**********************************************************************
 *  Fill in the lengths computed by your heuristics.                  *
 **********************************************************************/
 
data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt        7389.9297             4887.2190
tsp1000.txt       27868.7106            17265.6282
usa13509.txt      77449.9794            45074.7769
 
/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow.       *
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/
 
Estimations:   We estimate that both heuristics will be quadratic 
 
n               nearest time           smallest time
------------------------------------------------------------
1000            0.213 seconds           1.214 seconds
2000            0.826 seconds           4.962 seconds
4000            3.259 seconds           19.468 seconds
8000            13.165 seconds          77.304 seconds
16000           55.39 seconds
32000           214.67 seconds
 
Estimations:    2.13E-7 * n^2           1.214E-6 * n^2
 
 
 
 
/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/
 
Yes or no? Yes, office hours Monday night
 
 
 
/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/
 
Yes or no? No
 
 
 
/**********************************************************************
 *  List any other comments here.
 **********************************************************************/
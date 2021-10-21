Final Programming Project: Atomic Nature of Matter

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:
10

/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/

Using the doubling method on the data below, we can see that the ratio
of the running times approaches 2. Given that the ratio of the running times is
equal to 2^b, then we know that 2 = 2^b. Therefore we can estimate b= 1.
Using b = 1, we can estimate a to be 7.25 * 10e-8.

[ 28.567/(1280*307200)= 7.26e-8 and 14.242/(640*307200) = 7.24e-8. ]

Thus the estimated running time in seconds for an input size n in BeadTracker,
where n is the product of the number of pixels per frame (640x480) and the
number of frames, is 7.25e-8n seconds.

Data:
Number of Pixels (n)        Seconds                 Tn/T(n/2)
10 * 307200                 0.381                   0.637/0.381 = 1.67
20 * 307200                 0.637                   1.164/0.637 = 1.83
40 * 307200                 1.164                   1.983/1.164 = 1.70
80 * 307200                 1.983                   3.791/1.983 = 1.91
160 * 307200                3.791                   7.238/3.791 = 1.91
320 * 307200                7.238                   14.242/7.238 = 1.96
640 * 307200                14.242                  28.5678/14.242 = 2.01
1280 * 307200               28.567

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?
Monday lab TA


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

No

/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/

Thank you for a great semester!

from __future__ import print_function


'''
find if there is a subarray with zero sum

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.

'''


def hasZero(arr):
	if len(arr) == 0:
		return False
	sum_ = 0
	cache = dict()
	cache.update({0:-1})	
	for i in range(0,len(arr)):
		sum_ += arr[i]
		if sum_ in cache:
			return True
		cache.update({sum_:i})	
	return False		



'''
find the length of the largest consecutive subsequence


Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence
of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
The subsequence 36, 35, 33, 34, 32 is the longest subsequence
of consecutive elements.
'''


def findLargestConsecutive(arr):
	
	if len(arr) == 0 or len(arr) == 1:
		return len(arr)

	cache = dict()
	
	for x in arr:
		cache.update({x:x})

	ans = 0	

	for x in range(len(arr)):

		if arr[x] - 1 not in cache:
			count = 1
			j = arr[x]
			while j+1 in cache:
				j += 1
				count += 1
			ans = max(ans, count)	
	return ans		




'''
Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array Note:
1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:
Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)

'''


def abcd(arr):
	if len(arr) < 4:
		return []

	cache = dict()	
	ans = []

	for i in range(len(arr)-1):
		for j in range(i+1,len(arr)):
			sum_ = arr[i]+arr[j]
			if sum_ not in cache:
				cache.update({sum_:[i,j]})
			else:
				d = cache[sum_]
				if d[0] < i and d[1] < i:
					ans.append([d[0],d[1],i,j])
	ans = sorted(ans, cmp=comp)
	print(ans)				
	return []

def comp(s1,s2):
	if (s1[0] < s2[0]) or (( s1[0] == s2[1]) and ( s1[1] < s2[1] )) or ((s1[0] == s2[0]) and (s1[1] == s2[1]) and (s1[2] < s2[2]))  or (s1[0] == s2[0] and (s1[1] == s2[1]) and (s1[2] == s2[2]) and (s1[3] < s2[3])):
		return 1
	else:
		return -1


'''
Largest Continuous Sequence Zero Sum
Find the largest continuous sequence in a array which sums to zero. Example:
Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}


edge-case: {1,0}

'''








'''
Parity Queries


'''




if __name__=='__main__':
	print(abcd([ 4, 1, 2, 2, 0, 1, 0, 4, 1, 0, 5, 4, 4 ]))



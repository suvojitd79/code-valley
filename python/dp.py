from __future__ import print_function
from collections import *


# Input: arr[] = {6, -3, -10, 0, 2}
# Output:   180  // The subarray is {6, -3, -10}

# Input: arr[] = {-1, -3, -10, 0, 60}
# Output:   60  // The subarray is {60}

# Input: arr[] = {-2, -3, 0, -2, -40}
# Output:   80  // The subarray is {-2, -40}


# case -1 > e will be a part of max...
# case - 2 > e will be a part of min...
# case - 3> e start over ....


def prodMax(arr):
	max_prev = arr[0]
	min_prev = arr[0]
	max_global = arr[0]
	max_current = arr[0]
	min_current = arr[0]

	for x in range(1,len(arr)):
		max_current = max(max_prev*arr[x],min_prev*arr[x],arr[x])
		min_current = min(max_prev*arr[x],min_prev*arr[x],arr[x])
		max_global = max(max_global, max_current)
		max_prev = max_current
		min_prev = min_current
	return max_global	


# Input 1:
#     A = [2, 1, 1]

# Output 1:
#     1

# Explanation 1:
#     The shortest way to reach index 2 is
#         Index 0 -> Index 2
#     that requires only 1 jump.

# Input 2:
#     A = [2,3,1,1,4]

# Output 2:
#     2

# Explanation 2:
#     The shortest way to reach index 4 is
#         Index 0 -> Index 1 -> Index 4
#     that requires 2 jumps.


def minJump(arr):
	cache = [-1 for x in range(len(arr))]
	cache[-1] = 0 # base case
	n = len(arr) - 1
	for x in range(1,len(arr)):
		if arr[n-x] == 0:
			cache[n-x] = -1
		else:
			m = float('inf')
			for y in range(1,arr[n-x]+1):
				i = n - x + y
				if i >= len(arr):
					break
				m = m if cache[i] == -1 else min(m,cache[i]) 	
			cache[n-x] = m + 1 	
	print(cache)		
	return cache[0]


def bitonic(arr):
	left = [1 for x in range(len(arr))]
	right = [1 for x in range(len(arr))]

	for x in range(1,len(arr)):
		for y in range(x):
			if arr[x] > arr[y]:
				left[x] = max(left[x], left[y]+1)
	
	for x in range(1, len(arr)):
		for y in range(x):
			if arr[-1-x] > arr[-1-y]:
				right[-1-x] = max(right[-1-x], right[-1-y]+1)
	m = left[0] + right[0] - 1
	for x in range(1,len(arr)):
		m = max(m,left[x]+right[x]-1)

	print(left,right)	
	return m	


# Input:  digits[] = "121"
# Output: 3
# // The possible decodings are "ABA", "AU", "LA"

# Input: digits[] = "1234"
# Output: 3
# // The possible decodings are "ABCD", "LCD", "AWD"




#count the no of ways to decode the string 
def countDecode(en):
	if len(en) == 0 or len(en) == 1:
		return 1
	
	if en[-1] == '0':
		return countDecode(en[:-1])

	count = 0

	if int(en[-1]) > 0:
		count = countDecode(en[:-1])

	if  int(en[-1]) < 7 and (int(en[-2]) == 1 or int(en[-2]) == 2):
		count += countDecode(en[:-2])

	return count	


# O(n) solution

def countDecodeDP(en):

	if len(en) > 0 and en[0] == '0':
		return 0

	if len(en) == 0 or len(en) == 1:
		return 1
	

	cache = [0 for x in range(len(en)+1)]
	cache[0] = 1
	cache[1] = 1
	for x in range(2,len(en)+1):
		cache[x] = 0
		if en[x-1] > '0':
			cache[x] = cache[x-1]
		if  (en[x-1] < '7' and en[x-2]== '2') or en[x-2] == '1':
			cache[x] += cache[x-2]	

	return cache[len(en)]	

'''
			
   (10 ^ sum)

	0-0-0-0
		 -1
		 -2
		 -3
		 -4
	


count the number of n digit numbers whose digit sum is equal to the givne value

Input:  n = 2, sum = 2
Output: 2
Explanation: Numbers are 11 and 20

Input:  n = 2, sum = 5
Output: 5
Explanation: Numbers are 14, 23, 32, 41 and 50

Input:  n = 3, sum = 6
Output: 21
'''





def countRecursiveNS(n,s):
	if n == 0:
		return 1 if s==0 else 0
	if s == 0:
		return 1
	count = 0
	for x in range(10):
		count += countRecursiveNS(n-1,s-x)	
	return count


def countRecursiveWrapperNS(n,s):
	if n == 0:
		return 1 if s==0 else 0
	if s == 0:
		return 1
	count = 0
	for x in range(1,10):
		count += countRecursiveNS(n-1,s-x)	
	return count

def countDpNS(n,s):
	pass


# Longest Arithmetic Progression 



'''
given a number N, find the count of bit string of length N such that there are no consecutive 1s

'''



'''
rod cutting problem

'''	

def rodcut(price,n):

	if n <= 0:
		return 0

	profit = float('-inf')

	for x in range(n):
		profit = max(profit, price[x] + rodcut(price,n-1-x))
	return profit	



def rodcutDP(price,n):
	cache = [0 for x in range(n+1)]
	for x in range(1,n+1):
		m = float('-inf')
		for y in range(x):
			m = max(m, price[y] + cache[x-1-y])
		cache[x] = m	
	return cache[n]		



def lcs(x1,x2):
	if len(x1) == 0 or len(x2) == 0:
		return 0
	elif x1[0] == x2[0]:
		return 1 + lcs(x1[1:],x2[1:])
	return max(lcs(x1[1:],x2),lcs(x1,x2[1:]))	


def lcsDP(x1,x2):
	if len(x1) == 0 or len(x2) == 0:
		return 0
	cache = [[0 for x in range(len(x1)+1)] for x in range(len(x2)+1)]
	for x in range(1,len(x2)+1):
		for y in range(1,len(x1)+1):
			if x1[y-1] == x2[x-1]:
				cache[x][y] = 1 + cache[x-1][y-1]
			else:
				cache[x][y] = max(cache[x-1][y], cache[x][y-1])
	return cache[len(x2)][len(x1)]				



'''
find the length of the longest palindromic substring 

input: 	forgeeksskeegfor
output: geeksskeeg

'''


def palin(arr):
	pass



# find the length of the longest palindromic subsequence

def palindromicSequence(s, start,end):
	
	# only 1 character left
	if start == end:
		return 1 

	# 2 characters left	
	if s[start] == s[end] and start + 1 == end:
		return 2
		
	if s[start] == s[end]:
		return 2 + palindromicSequence(s,start+1,end-1)

	return max(palindromicSequence(s,start+1,end),palindromicSequence(s,start,end-1))	


def palindromicSequenceDP(s):
	if len(s) == 0 or len(s) == 1:
		return len(s)
	cache = [[0 for x in range(len(s))] for x in range(len(s))]


	#	compute for length 1
	for x in range(len(s)):
		cache[x][x] = 1

	
	# length > 2

	for x in range(2, len(s)+1):
		for i in range(0,len(s)-x + 1):
			
			j = x + i - 1

			if s[i] == s[j] and x == 2:
				cache[i][j] = 2 

			if s[i] == s[j]:
				cache[i][j] = 2 + cache[i+1][j-1]
			else:
				cache[i][j] = max(cache[i+1][j], cache[i][j-1])	

	
	print(cache)			

	return cache[0][len(s)-1]		


def longestPalindrome(self, A):
	if len(A) == 0 or len(A) == 1:
		return A
	cache = [[False for x in range(len(A))] for x in range(len(A))]
	
	# keep track of the longest palindrome
	start = 0
	end = 0
	
	# length = 1
	for x in range(len(A)):
		cache[x][x] = True
	
	counter = True
	
	# length = 2
	for x in range(len(A)-1):
		if A[x] == A[x+1]:
			cache[x][x+1] = True
			if counter:
				start = x
				end = x + 1
				counter = False
	
	# length > 2
	
	for x in range(3, len(A)+1):
		counter = True
		for i in range(0, len(A)-x+1):
			j = x + i - 1

			if cache[i+1][j-1] and A[i] == A[j]:
				cache[i][j] = True
				if counter:
					start = i
					end = j
					counter = False
			else:
				cache[i][j] = False
	
	return A[start:end+1]


'''
find the nth fibonacci in lon(n) time

'''

def fibo(n):
	if n == 0:
		return 0
	A = [[1,1],[1,0]]	
	power(A, n-1)
	return A[0][0]

def mul(A,F):
	x = A[0][0] * F[0][0] + A[0][1] * F[1][0]
	y = A[0][0] * F[0][1] + A[0][1] * F[1][1]
	w = A[1][0] * F[0][0] + A[1][1] * F[1][0]
	z = A[1][0] * F[0][1] + A[1][1] * F[1][1]

	A[0][0] = x
	A[0][1] = y
	A[1][0] = w
	A[1][1] = z 


def power(A,n):
	if n == 0 or n == 1:
		return
	F = [[1,1],[1,0]]
	power(A,n//2)
	mul(A,A)
	if n % 2 != 0:
		mul(A,F)




def minPathSum(A):
	
	row = len(A)
	col = len(A[0])
	
	for x in range(1,len(A[0])):
		A[row-1][col-1-x] += A[row-1][col-x]
		
	for x in range(1, len(A)):
		A[row-1-x][len(A[row-1-x])-1] += A[row-x][len(A[row-1-x])-1]
			
	for x in range(1, len(A)):
		for y in range(1, len(A[x])):
			i = row -1 -x
			j = len(A[i]) - 1 - y
			A[i][j] = A[i][j] + min(A[i][j+1] , A[i+1][j])
	return A[0][0]        



'''

find the length of the longest AP

set[] = {1, 7, 10, 15, 27, 29}
output = 3
The longest arithmetic progression is {1, 15, 29}

set[] = {5, 10, 15, 20, 25, 30}
output = 6
The whole set is in AP

'''



def getAP(arr):
	cache = [dict() for x in range(len(arr))]
	for x in range(1,len(arr)):
		for y in range(x):
			if arr[x]-arr[y] in cache[y]:
				d = cache[y]
				cache[x].update({arr[x]-arr[y]:d[arr[x]-arr[y]]+1})
			else:
				cache[x].update({arr[x]-arr[y]:1})

	m = 1
	for x in cache:
		if len(x.values()) > 0:
			m = max(m, max(x.values())+1)
	return m	








'''


Regular Expression Match	
Edit Distance	
Regular Expression II	
Interleaving Strings	

'''



def wildCard1(s,p):
	if len(s) == 0 and len(p) == 0:
		return True
	if len(s) == 0 or len(p) == 0:
		return False
	if p[0] == '?' or s[0] == p[0]:
		return wildCard1(s[1:],p[1:])
	elif p[0] == '*':
		return wildCard1(s[1:],p) or wildCard1(s,p[1:])
	return False




def wildCard1DP(s,p):

	cache = [[False for x in range(len(p)+1)] for x in range(len(s)+1)]
	

	for j in range(1,len(p)+1):
		if p[j-1] == '*':
			cache[0][j] = cache[0][j-1]

	for x in range(1,len(s)+1):
		for y in range(1,len(p)+1):

			if p[y-1] == '?' or s[x-1] == p[y-1]:
				cache[x][y] = cache[x-1][y-1]
			elif p[y-1] == '*':
				cache[x][y] = cache[x-1][y] or cache[x][y-1]
			else:
				cache[x][y] = False


	return cache[len(s)][len(p)]			



'''
min operations to convert s1 to s2

'''

'''
def minDistance(s1,s2):
	if len(s1) == 0:
		return len(s2)
	if len(s2) == 0:
		return len(s1)
	cache = [[0 for x in range(len(s1)+1)] for x in range(len(s2)+1)]	

	for x in range(1,len(s1)+1):
		cache[0][x] = x

	for x in range(1, len(s2)+1):
		cache[x][0] = x
	
	for x in range(1, len(s2)+1):
		for y in range(1, len(s1)+1):
			if s1[y-1] == s2[x-1]:
				cache[x][y] = cache[x-1][y-1]
			else:
				cache[x][y] = 1 + min(cache[x-1][y],cache[x][y-1],cache[x-1][y-1])	
		
	return cache[len(s2)][len(s1)]			
'''



'''
regex matching

'''



'''

check if C is interleaved of A & B

'''



'''
Word Break	


Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".


'''


def wordBreak(s,d):

	if len(s) == 0:
		return True

	n = len(s)
	cache = [[False for x in range(n+1)] for x in range(n+1)]
	for x in range(1,n+1):
		if s[x-1] in d:
			cache[x][x] = True

	for l in range(2,n+1):
		for i in range(1, n-l+2):
			j = l + i - 1
			if s[i-1:j] in d:
				cache[i][j] = True 
			else:
				cache[i][j] = False
				for k in range(i,j):
					data = cache[i][k] and cache[k+1][j]
					if data:
						cache[i][j] = True
						break					
	return cache[1][n]					





'''
Matrix Chain Multiplication	

O(n^3)

'''

def chainMatrix(arr=[]):
	n = len(arr) 
	cache = [[0 for x in range(n)] for x in range(n)]

	for x in range(1,n):
		cache[x][x] = 0

	for l in range(2, n):
		for i in range(1, n-l+1):	
			j = l+i-1
			cache[i][j] = float('inf')
			for k in range(i,j):
				m = cache[i][k] + cache[k+1][j] + arr[i-1] * arr[k] * arr[j]
				cache[i][j] = min(cache[i][j], m)		
	return cache[1][n-1]	


'''
Box Stacking Problem	


'''








'''

Palindrome Partitioning II
Given a string A, partition A such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of A. 

'''


	
if __name__=='__main__':
	dic = ["mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"]
	
	print(wordBreak("ilikesamsung",dic))
	print(wordBreak("iiiiiiii",dic))
	print(wordBreak("",dic))
	print(wordBreak("ilikelikeimangoiii",dic))
	print(wordBreak("samsungandmango",dic))
	print(wordBreak("samsungandmangok",dic))


	print(wordBreak("myinterviewtrainer",["interview", "my", "trainer"]))

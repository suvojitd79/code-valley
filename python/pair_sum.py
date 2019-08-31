# Input 1:
#     A = [1, 1, 1, 2, 3]
#     B = 4
# Output 1:
#     3

# Input 2:
#     A = s
#     B = 5
# Output 2:
#     3
# import pytest

def countPair(A,B):
	count = 0 
	i = 0
	j = len(A) - 1
	while i < j:
		if A[i] + A[j] > B:
			j -= 1
		elif A[i] + A[j] < B:
			i += 1
		else:
			x = i
			y = j
			i += 1
			j -= 1
			while i<j and A[i] == A[x]:
				i += 1	
			while i<j and A[j] == A[y]:
				j -= 1	
			if A[x] == A[y] and i==j:
				a = y-x+1
				count += (a * (a - 1)) / 2 	
			else:
				count += (i-x) * (j-y)		
	return count
	
if __name__=='__main__':
	print(countPair([1, 1, 1, 2, 3], 4))
'''
Matrix Median

Input : 1 3 5
        2 6 9
        3 6 9
Output : 5


1 3 4
2 5 6
7 8 9

'''

from bisect import bisect_right as count_lower

def getMedian(matrix):
	
	row = len(matrix)
	col = len(matrix[0])
	
	max_ = float('-inf')
	min_ = float('inf')

	for r in matrix:
		max_ = max(max_,r[-1])
		min_ = min(min_,r[0])
 	
 	target = (row * col + 1)  // 2 
		
	while min_ < max_:
		mid = min_ + (max_-min_)//2 
		count = 0
		for r in matrix:
			count += count_lower(r, mid)
		if count < target:
			min_ = mid + 1
		else:
			max_ = mid 

	return min_		




'''

Find a peak element	
	
{5, 10, 20, 15} - 20
{5, 10,15, 20} - 20


'''



def findPeak(arr):
	return findPeakRecursive(arr,0,len(arr)-1)

def findPeakRecursive(arr,start,end):
	if start > end: 
		return float('inf') # exception
	mid = start + (end-start)//2	
	
	right = float('-inf')
	left = float('-inf')
	if mid + 1 < len(arr):
		right = arr[mid+1]
	if mid-1 > -1:
		left = arr[mid-1]
	
	ele = arr[mid]	

	if left <= ele >= right:
		return ele
		
	elif ele <= right:
		return findPeakRecursive(arr,mid+1,end)
	return findPeakRecursive(arr,start,mid-1)	






'''

Rotated Sorted Array Search

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3


'''

def findSortedRotated(arr,ele):
	return findSortedRotatedRecursive(arr,0,len(arr)-1,ele)


def findSortedRotatedRecursive(arr,start,end,ele):
	if start > end:
		return -1
	mid = start + (end-start)//2
	
	if arr[mid] == ele:
		return mid


	if arr[mid] >= arr[start]:
		if   arr[start] <= ele <= arr[mid]:
			return findSortedRotatedRecursive(arr,start,mid-1,ele)
		else:
			return findSortedRotatedRecursive(arr,mid+1,end,ele)
	else:
		if arr[mid] <= ele <= arr[end]:
			return findSortedRotatedRecursive(arr,mid+1,end,ele)
		else:
			return findSortedRotatedRecursive(arr,start,mid-1,ele)	



'''

Single Element in a Sorted Array	


1 1 2 2 3



Input:   arr[] = {1, 1, 3, 3, 4, 5, 5,7, 7, 8, 8}
Output:  4

Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output:  8

'''

def findSingle(arr):
	return findSingleRecursive(arr, 0, len(arr)-1)

def findSingleRecursive(arr,start,end):
	
	if start > end:
		return -1

	if start == end:
		return start
		
	mid = start + (end - start)//2
	
	if mid % 2 == 0:
		if arr[mid+1] == arr[mid]:
			return findSingleRecursive(arr, mid+2,end)
		else:
			return findSingleRecursive(arr, start, mid)	
	else:
		if arr[mid-1] == arr[mid]:
			return findSingleRecursive(arr, mid+1, end)
		else:
			return findSingleRecursive(arr, start, mid-1)	




if __name__=='__main__':
	print(findSingle([1, 1, 3, 3, 4, 5, 5,7, 7, 8, 8]))





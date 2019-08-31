			    	
# 		 	  1 
# 		 2		    3
#   	4	    5     6    7	 

from __future__ import print_function
from collections import deque
class Node():
	def __init__(self,val = 0):
		self.val = val
		self.left = None
		self.right = None

def postr(root=None):
	if root == None:
		return
	postr(root.left)
	postr(root.right)
	print(root.val, end=' ')	

def lcs(root,n1,n2):
	if root == n1 or root == n2 or root == None:
		return root
	left = lcs(root.left,n1,n2)
	right = lcs(root.right,n1,n2)	
	if left and right:
		return root
	elif left:
		return left
	else:
		return right 	

if __name__=='__main__':
	root = Node(1)
	root.left = Node(2)
	root.right = Node(3)
	root.right.right = Node(7)
	root.right.left = Node(6)
	root.left.right = Node(5)
	root.left.left = Node(4)

	print(lcs(root,root.left.right,root.left.left).val)



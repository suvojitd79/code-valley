# Input : 
# in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
# post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

# Output : Root of below tree
#           1
#        /     \
#      2        3
#    /    \   /   \
#   4     5   6    7
#     \
#       8

from __future__ import print_function
from collections import deque
class Node:
	def __init__(self,val):
		self.val = val
		self.left = self.right = None
n = 0				
def buildTree(inorder,postorder):
	post = dict()
	for index,val in enumerate(inorder):
		post.update({val:index})
	global n
	n = len(postorder) - 1
	return buildTreeRecursive(post,0,len(inorder)-1,postorder)	


def printTreeInorder(root):
	stack_ = deque()
	set_ = set()
	if root == None:
		return
	stack_.append(root)
	while stack_:
		r = stack_[-1]
		while r.left and r.left not in set_:
			r = r.left
			stack_.append(r)
		print(r.val)
		set_.add(r)
		if r.right:
			stack_.append(r.right)
		stack_.remove(r)


def isBalanced(root):
	if root == None:
		return 0,True
	left_,isLeftBal = isBalanced(root.left)	
	right_,isRightBal = isBalanced(root.right)
	return max(left_,right_) + 1, isLeftBal and isRightBal and abs(left_ - right_) < 2


def printVertical(root,distance_from_root,map_):
	if root == None:
		return
	printVertical(root.left,distance_from_root-1,map_)
	if distance_from_root in map_:
		ans = map_[distance_from_root]
		ans.append(root.val)
		map_[distance_from_root] = ans 
	else:
		map_[distance_from_root] = [root.val]
	printVertical(root.right,distance_from_root+1,map_)		



def printTreePost(root):
	pass


def buildTreeRecursive(inorder,start,end,postorder):
	
	if start > end:
		return None
	global n
	root = Node(postorder[n])
	n -= 1

	index = inorder[root.val]

	root.right = buildTreeRecursive(inorder,index+1,end,postorder)
	root.left = buildTreeRecursive(inorder,start,index-1,postorder)

	return root

if __name__=='__main__':
	r = buildTree([4, 8, 2, 5, 1, 6, 3, 7], [8, 4, 5, 2, 6, 7, 3, 1])
	map_ = dict()
	printVertical(r,0,map_)
	print(sorted(list(map_.keys())))

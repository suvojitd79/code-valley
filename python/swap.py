from __future__ import print_function

class Node:
	def __init__(self,val):
		self.val = val
		self.left = self.right = None
  #			 6 
  #       /  \ 
  #      10    2 
  #     / \   / \ 
  #    1   3 7  12 
  #    

  #		 10 and 2 are swapped 

  #   


# O(n) space
def findSwapedWithMemory(root):
	cache = []
	inorder(root, cache)
	ans = []
	for x in range(1,len(cache)):
		if cache[x] < cache[x-1]:
			if len(ans) == 0:
				ans.append(max(cache[x],cache[x-1]))
			else:
				ans.append(min(cache[x],cache[x-1]))	
	return ans

# O(1) space
def findSwapedWithoutMemory(root):
	ans = []
	l = root.left if root.left != None else float('-inf')  
 	r = root.right if root.right != None else float('inf')
 	if not l <= root.val <= r:
 		ans.append(root.val)
	findSwaped(root,float('-inf'),float('inf'),ans)
	return ans

def findSwaped(root,l,h,ans):
	if root == None:
		return 
	findSwaped(root.left,l,root.val,ans)
	if not l <= root.val <= h:
		ans.append(root.val)
	findSwaped(root.right,root.val,h,ans)	
				
def inorder(root,cache):
	if root == None:
		return
	inorder(root.left, cache)
	cache.append(root.val)
	inorder(root.right,cache)	

if __name__=='__main__':
	root = Node(6)
	root.right = Node(2)
	root.right.right = Node(12)
	root.right.left = Node(7)	
	root.left = Node(10)
	root.left.left = Node(1)
	root.left.right = Node(3)

	# root = Node(1)
	# root.left = Node(2)
	# root.right = Node(3)

	print(findSwapedWithoutMemory(root))



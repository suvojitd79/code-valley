class Node():
    def __init__(self,val):
        self.val = val
        self.left = self.right = None

n = 0

def solve(A, B, C):    
    in_ = dict()
    for i,v in enumerate(B):
        in_.update({v:i})
    global n
    n = len(A) - 1
    root = makeTree(in_,0, n, C)
    cache = []
    pre(root, cache)
    print(cache)
    return 1 if cache == A else 0

def pre(root, cache):
    if root == None:
        return
    cache.append(root.val)
    pre(root.left, cache)
    pre(root.right, cache)


def makeTree(in_,start,end,post_):
    if start > end:
        return None
    global n
    print(n)
    root = Node(post_[n])
    n -= 1
    if start == end:
        return root
    index = in_[root.val]
    root.right = makeTree(in_, index+1, end,post_)
    root.left = makeTree(in_, start, index -1, post_)
    return root


if __name__=='__main__':
    A = [1, 5, 4, 2, 3]
    B = [4, 2, 5, 1, 3]
    C = [4, 1, 2, 3, 5]
    print(solve(A,B,C))
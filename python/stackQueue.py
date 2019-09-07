from collections import deque
    
'''
    
    Sum of minimum and maximum elements of all subarrays of size k	

'''
def SolutionMinMaxK(self, A, B):
    n = len(A)
    Sum = 0
    G = deque()
    S = deque()
    
    for x in range(B):
        while len(S) > 0 and A[S[-1]] >= A[x]:
            S.pop()
        while len(G) > 0 and A[G[-1]] <= A[x]:
            G.pop()
        
        S.append(x)
        G.append(x)
    
    for x in range(B, n):
        
        Sum += A[S[0]] + A[G[0]] 
    
        while len(S) > 0  and S[0] <= x - B:
            S.popleft()
        while len(G) > 0  and G[0] <= x - B:
            G.popleft()
            
        while len(S) > 0 and A[S[-1]] >= A[x]:
            S.pop()
        while len(G) > 0 and A[G[-1]] <= A[x]:
            G.pop()
        
        S.append(x)
        G.append(x)
    
    Sum += A[S[0]] + A[G[0]] 
    return Sum % 1000000007
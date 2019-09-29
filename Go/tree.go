package main

type Node struct {
	val   int
	left  *Node
	right *Node
}

func makeNode(val int) *Node {

	node := &Node{}
	node.val = val
	node.left = nil
	node.right = nil
	return node
}

func main() {

}

func levelOddEven(root *Node, k int, sum_odd *int, sum_even *int) {

	if root == nil {
		return
	}

	if k%2 == 0 {
		*sum_even += root.val
	} else {
		*sum_odd += root.val
	}

	levelOddEven(root.left, k+1, sum_odd, sum_even)
	levelOddEven(root.right, k+1, sum_odd, sum_even)
}

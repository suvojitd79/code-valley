package main

import (

	"fmt"
	"time"
)


func main() {

	y := 0
	x := &y

	go p1(&y)
	go p2(&y) 

	for true{

		fmt.Println(*x)

	}

}


func p1(y *int){
	for i:=0;i<10;i++{
		time.Sleep(time.Second)
		*y = *y + 1
	}
}


func p2(y *int){
	for i:=0;i<10;i++{
	    time.Sleep(time.Second)
	 	*y = *y + 1
	}
}


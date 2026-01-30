import LinkedList.LinkedList

fun main() {
    val myList = LinkedList<Int>()  //0 1 2 3 13
    myList.add(0)
    myList.add(1)
    myList.add(2)
    myList.add(3)
    println("The size of the list is: ${myList.getSize()}")
    println("LinkedListToString: ${myList}")
 //   println("The index: 0 element of the list is: ${myList.get(0)}")
//    println("The index: 3 element of the list is: ${myList.get(3)}")


    myList.add(3, 13)
    println("The size of the list is: ${myList.getSize()}")
    println("The index: 2 element of the list is: ${myList.get(2)}")
    println("The index: 3 element of the list is: ${myList.get(3)}")
    println("The index: 4 element of the list is: ${myList.get(4)}")
    println("LinkedListToString: ${myList}")
}
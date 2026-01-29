import LinkedList.LinkedList

fun main() {
    val myList = LinkedList<Int>()
    myList.add(5)
    myList.add(6)
    myList.add(7)
    myList.add(9)
    println(myList.getSize())
    println(myList.get(0))
    println(myList.get(3))
}
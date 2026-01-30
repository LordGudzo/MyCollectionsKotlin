interface MyCollection<E>: Iterable<E> {
    fun isEmpty(): Boolean                       //+
    fun getSize(): Int
    fun contains(element: E): Boolean
    fun indexOf(element: E): Int
    fun lastIndexOf(element: E): Int
    fun clear()
    fun first(): E
    fun last(): E
    fun get(index: Int): E                      //+
    fun getOrNull(index: Int): E?               //+
    override fun toString(): String
    override fun iterator(): Iterator<E>   
}

interface MyMutableCollection<E>: MyCollection<E>  {
    fun add(element: E)                        //+
    fun add(index: Int, element: E)
    fun remove(index: Int)  //deletes elements by index
}

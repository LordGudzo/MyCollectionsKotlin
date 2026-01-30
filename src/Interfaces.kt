interface MyCollection<T>: Iterable<T> {
    val size: Int
    fun isEmpty(): Boolean
    fun contains(element: T): Boolean
    fun indexOf(element: T): Int
    fun lastIndexOf(element: T): Int
    fun clear()
    fun first(): T
    fun last(): T
    fun get(index: Int): T
    fun getOrNull(index: Int): T?
    override fun toString(): String
    override fun iterator(): Iterator<T>   
}

interface MyMutableCollection<T>: MyCollection<T>  {
    fun add(element: T)
    fun add(index: Int, element: T)  
    fun remove(index: Int)  //deletes elements by index
}

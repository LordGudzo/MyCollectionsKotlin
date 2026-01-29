package LinkedList

class LinkedList<E> () {
    //store information about root or first node in myLinkedList.
    private var _root: Node<E>? = null

    //store information about last node.
    private var _end: Node<E>? = null

    //store information about the size of myLinkedList.
    private var _size: Int = 0


    /**
     * If myLinkedList is empty first node adds to the root, else to the child of current node.
     *
     * @param value the value for adds.
     */
    fun add(value:E){
        val currentNode: Node<E> = Node(value)

        if (_size == 0){
            _root = currentNode
            _end = currentNode
        } else {
            _end?.setChild(currentNode)
            currentNode.setParent(_end)
            _end = currentNode
        }

        _size++
    }

    /**
     * Returns value from node with index.
     *
     * @param index of node.
     * @return value from node.
     */
    fun get(index: Int): E? {
        if (_size == 0) {
            throw java.lang.IndexOutOfBoundsException("Index: $index size: $_size")
        }
        checkIndex(index)
        val indexNode: Node<E> = getNodeWithIndex(index)!!
        return indexNode.value
    }

    fun getSize() = _size

    /**
     * If index will be more than size of myArrayList or less than zero - new IndexOutOfBoundsException.
     *
     * @param index index for operation with element.
     */
    private fun checkIndex(index: Int) {
        if (index > _size || index < 0) {
            throw IndexOutOfBoundsException("Index: $index size: $_size")
        }
    }

    /**
     * Search node with index.
     *
     * @param index index for search node.
     * @return node with this index.
     */
    private fun getNodeWithIndex(index: Int): Node<E>? {
        var current: Node<E>? = _root
        var count = 0
        while (count != index) {
            current = current?.getChild()
            count++
        }
        return current
    }

}

/**
 * Store information about value and it's relatives.
 *
 * @param <E> parameter for element.
 */
private class Node<E>(
    var value: E,
)
{
    //Stores information about node's child.
    var _child: Node<E>? = null

    //Stores information about node's parent.
    var _parent: Node<E>? = null

    //returns parent
    fun setParent(parent: Node<E>?) {
        _parent = parent
    }

    //return child
    fun setChild(child: Node<E>?) {
        _child = child
    }

    //returns value
    fun getParent(): Node<E>? {
        return _parent
    }

    fun getChild(): Node<E>? {
        return _child
    }
}


package LinkedList

import MyMutableCollection

class LinkedList<E> (): MyMutableCollection<E> {
    //store information about root or first node in myLinkedList.
    private var _root: Node<E>? = null

    //store information about last node.
    private var _end: Node<E>? = null

    //store information about the size of myLinkedList.
    private var _size: Int = 0


    /**
     * If myLinkedList is empty first node adds to the root, else creates as the child of last node.
     *
     * @param element the value for adds.
     */
    override fun add(element:E){
        val createdNode: Node<E> = Node(element)

        if (_size == 0){
            _root = createdNode
            _end = createdNode
        } else {
            _end?.setChild(createdNode)
            createdNode.setParent(_end)
            _end = createdNode
        }

        _size++
    }

    override fun add(index: Int, element: E) {
        val indexNode = getNodeWithIndex(index)
        val indexNodeChild:Node<E>? = indexNode?.getChild()
        val createdNode: Node<E> = Node(element)
        // MyLinkedList(0 1 2 3) ->(index: 2, element: 13) -> MyLinkedList(0 1 indexNode:2 createdNode:13 3)
        if(indexNodeChild != null) {  //check with 1 element
            indexNode.setChild(createdNode) //2 -> 13
            createdNode.setParent(indexNode)
            createdNode.setChild(indexNodeChild) //13 -> 3
            indexNodeChild.setParent(createdNode)
        } else {
            indexNode?.setChild(createdNode)
            createdNode.setParent(indexNode)
            _end = createdNode
        }
        _size++
    }

    override fun remove(index: Int) {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return _size == 0
    }

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: E): Int {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: E): Int {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun first(): E {
        TODO("Not yet implemented")
    }

    override fun last(): E {
        TODO("Not yet implemented")
    }

    /**
     * Returns value from node with index.
     *
     * @param index of node.
     * @return value from node.
     */
    override fun get(index: Int): E {
        if (_size == 0) {
            throw java.lang.IndexOutOfBoundsException("Index: $index size: $_size")
        }
        val indexNode: Node<E> = getNodeWithIndex(index)!!
        return indexNode.value
    }

    override fun getOrNull(index: Int): E? {
        if (_size == 0) {
            return null
        }
        checkIndex(index)
        val indexNode: Node<E> = getNodeWithIndex(index)!!
        return indexNode.value
    }

    override fun toString(): String {
        val result = StringBuilder("[")
        var currentNode: Node<E>? = _root
        while (currentNode?.getChild() != null) {
            result.append(currentNode.value)
            result.append(", ")
            currentNode = currentNode.getChild()
        }
        result.append(currentNode?.value)

        return "$result]"
    }

    override fun iterator(): Iterator<E> {
        TODO("Not yet implemented")
    }

    override fun getSize() = _size

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
        checkIndex(index)
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


//Class: CS 5040
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 5
//IDE Name: IntelliJ

import java.util.Collection;

public interface Tree_Ernst_Fanfan<E> extends Collection<E> {
    //Returns true if the element is in the tree
    public boolean search(E e);

    //Insert element e into the binary tree
    //return true if element is inserted successfully
    public boolean insert(E e);

    //Delete the specific element from the tree
    //Return true if the element is deleted successfully
    public boolean delete(E e);

    //Get the number  of elements in the tree
    public int getSize();

    //Inorder traversal from the root
    public default void inorder(){

    }

    //Postorder traversal from the root
    public default void postorder(){

    }

    //Preorder traversal from the root
    public default void preorder(){

    }

    @Override //Return true if the tree is empty
    public default boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public default boolean contains (Object e){
        return search((E) e);
    }

    @Override
    public default boolean add(E e){
        return insert(e);
    }

    @Override
    public default boolean remove(Object e){
        return delete((E) e);
    }

    @Override
    public default int size(){
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c){
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c){
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c){
        return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c){
        return false;
    }

    @Override
    public default Object[] toArray(){
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array){
        return null;
    }

}

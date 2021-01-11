package Cards;/*
Hvis man har brug for lidt oplæsning til templates så kig nedenstående link
reference brugt: https://www.geeksforgeeks.org/generics-in-java/
 */

import java.util.Objects;

public class DynamicArr<T> {
    public int size, current;
    private T[] arr;

    //constructor to initialise array of 1 element.
    public DynamicArr() {
        arr = (T[]) new Object[1];
        size = 1;
        current = 0;
    }

    // Function to add element to the back of the array
    // we add the size of the array      everytime it has reached the limit.
    public void add(T data) {
        if (size == current) {
            T[] newarr = (T[]) new Object[1 + size];

            //setting old array elements into new array
            for (int i = 0; i < size; i++) {
                newarr[i] = arr[i];
            }
            size++;
            arr = newarr;
        }
        //arr = new int[newarr.length];
        //arr = newarr;
        arr[current] = data;
        current++;
    }

    //returns whatever there's in the given index
    public T atIndex(int index) {
        if (index < current) {
            return arr[index];
        } else {
            return null;
        }
    }

    // add element into whatever index
    public void addAt(int index, T data) {
        if (index == size) {
            add(data);
        } else {
            arr[index] = data;
        }
    }

    //print the entire array
    public void print() {
        for (int i = 0; i < current; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(" ");
    }

    //decrease the array by x elements
    public void decrease(int itteration) {
        T[] newarr = (T[]) new Object[current];
        //deletes the whole array except index 0
        if (itteration > current) {
            current = 1;
        } else {
            current -= itteration;
        }
        //decreases the array by x elements.
        for (int i = 0; i < current; i++) {
            newarr[i] = arr[i];
        }
        size = current;
        arr = newarr;
    }

    public void removeAt(int index) {
        T[] newArr = (T[]) new Object[size-1];
        int newArrCounter = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if (i != index) {
                newArr[newArrCounter] = arr[i];
                newArrCounter++;
            }
        }
        this.arr = newArr;
        size--;
        current--;

    }

    public void lastItemToFront(){
        T temp = arr[size-1];
        for (int i = size-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

    }

    public void removeLast(){
        T[] temp = (T[]) new Object[arr.length-1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        size--;
    }

    public void addAtStart(T object){
        this.add(object);
        this.lastItemToFront();
    }

    public T getLast(){
        return this.atIndex(this.size-1);
    }

    public T[] getArr(){return arr;}
}

package edu.cuny.lehman.cmp326.sales;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ObjectArray {

    private final Object[] INITIAL_ARRAY_SIZE = new Object[10];
    private final Object[] ARRAY_EXPAND = new Object[20];
    private Object[] myObjects = INITIAL_ARRAY_SIZE;
    private int currentObject = 0;

    /**
     * Pre/postcondition: Default co7nstructor that creates myObjects with
     * INITIAL_ARRAY_SIZE entries, all initialized to null.
     */
    public ObjectArray() {
        for (int i = 0; i < myObjects.length; i++) {
            myObjects[i] = null;
        }
    }

    /**
     * Pre/postcondition: Constructor that creates myObjects with the specified
     * initalArraySize entries, all initialized to null.
     */
    public ObjectArray(int initialArraySize) {
        myObjects = new Object[initialArraySize];
        for (int i = 0; i < myObjects.length; i++) {
            myObjects[i] = null;
        }
    }

    /**
     * Precondition: Constructor that creates myObjects with the enough space to
     * hold the given objectArray array. Postcondition: currentObject is set.
     */
    public ObjectArray(Object[] objectArray) {
        myObjects = objectArray.clone();
        currentObject += objectArray.length;
    }

    /**
     * Precondition: Add object to myObjects and update currentObject.
     * Postcondition: If there is no room in myObjects, the array will have to
     * be resized by adding ARRAY_EXPAND entries.
     */
    public void addObject(Object object) {
        if (currentObject >= myObjects.length) {
            List list = new ArrayList(Arrays.asList(myObjects));
            list.addAll(Arrays.asList(ARRAY_EXPAND));
            myObjects = list.toArray();								// I MAKE A LIST TO ADD BOTH ARRAYS AND THEN I PUT IT BACK INTO AN ARRAY
            myObjects[currentObject] = object;						// SINCE ADDING AN ARRAY TO ANOTHER DOESNT WORK QUIET WELL FOR ME.
        } else {
            myObjects[currentObject] = object;
        }
        currentObject++;
    }

    /**
     * Precondition: Add the given objectArray to myObjects and update
     * currentObject. Postcondition: If there is not enough room in myObjects,
     * the array will have to be resized by adding the appropriate multiple of
     * ARRAY_EXPAND entries.
     */
    public void addObjects(Object[] objectArray) {
        currentObject += objectArray.length;
        if (currentObject > myObjects.length) {
            List list = new ArrayList(Arrays.asList(myObjects));
            list.addAll(Arrays.asList(ARRAY_EXPAND));
            myObjects = list.toArray();
        }
        for (int i = currentObject - objectArray.length, j = 0; j < objectArray.length; i++, j++) {
            myObjects[i] = objectArray[j];
        }

    }

    /**
     * Precondition: Delete the object at the given index. Postcondition:
     * Verifies that the given index exists in myObjects, compress myObjects and
     * updates currentObject.
     */
    public void deleteObject(int index) {
        if (index < 0) {
            System.out.print("invalid index: " + index); //SHOWS ABOVE 
        } else if (index > currentObject) {
            System.out.print("invalid index " + index);
        } else {
            Object[] otherArray = new Object[myObjects.length];
            for (int i = 0, j = 0; i < myObjects.length; i++, j++) {
                if (i != index) {
                    otherArray[j] = myObjects[i];
                } else {
                    otherArray[index] = null;
                }
            }
            myObjects = otherArray.clone();
            currentObject--;
        }
    }

    /**
     * Precondition: Delete the count objects starting at the given index.
     * Postcondition: Verifies that the given index exists in myObjects,
     * compress myObjects and updates currentObject, verifies that the given
     * index exists in myObjects and that there are count entries starting from
     * there.
     */
    public void deleteObjects(int index, int count) {
        if ((index < 0 || count < 0) || (index > myObjects.length || count > myObjects.length)) {
            System.out.print("invalid index or count: " + index + "," + count);
        } else {
            currentObject -= count;
            Object[] otherArray = new Object[currentObject];
            for (int i = 0, j = 0; i < otherArray.length; i++, j++) {
                if (i < index || i > index + (count - 1)) {
                    otherArray[j] = myObjects[i];
                }
            }
            myObjects = otherArray.clone();
        }
    }

    /**
     * Precondition: Compare two ObjectArray�s objects for equality.
     * Postcondition: They will be considered equal, if and only if both are the
     * same size, have the same number of objects and all their entries are
     * equal.
     */
    public boolean equals(ObjectArray other) {
        return (myObjects.length == (other.myObjects.length));
    }

    /**
     * Precondition: This method returns the object located at the given index.
     * Postcondition: This method must verify that the given index is before
     * currentObject and within the bounds of the size of myObjects. In case of
     * an error, this method should return null.
     */
    public Object getObjectAt(int index) {
        Object answer;
        if (index < 0) {
            answer = null;
        } else if (index > myObjects.length) {
            answer = null;
        } else {
            answer = myObjects[index];
        }
        return answer;
    }

    /**
     * Pre/postcondition: This method returns the currentObject.
     */
    public int getNumberOfObjects() {
        return currentObject;
    }

    /**
     * Pre/postcondition: This method returns the length of myObjects.
     */
    public int getObjectArrayLength() {
        return myObjects.length;
    }

    /**
     * Pre/postcondition: This method displays all information about myObjects
     * by using the toString() method of each object and displaying
     * currentObject.
     */
    public void showAll() {
        System.out.println("myObjects " + Arrays.toString(myObjects) + "currentObject " + currentObject);
    }
}

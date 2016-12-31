package edu.cuny.lehman.cmp326.sales;

public class ObjectArrayDriver {

    public static void main(String[] args) {
        // as part ofiu following tests, showAll() will be tested by default, so not writing that specific test

        // test the default constructor
        ObjectArray testArray = new ObjectArray();
        System.out.println("Default constructor.\nShould print an array of length 10, all nulls, with currentObject set to 0.");
        testArray.showAll();

        // test the constructor that takes an Object
        testArray = new ObjectArray(15);
        System.out.println("\nConstructor:Object.\nShould print an array of length 15, all nulls, with currentObject set to 0.");
        testArray.showAll();

        // test the constructor that takes Object[]
        String[] tempArray = new String[8];
        for (int i = 0; i < 8; i++) {
            tempArray[i] = Integer.toString(i + 1);
        }
        testArray = new ObjectArray(tempArray);
        System.out.println("\nConstructor:Object[].\nShould print an array of numbers 1 to 8, with currentObject set to 8.");
        testArray.showAll();

        // test addObject
        testArray.addObject("10");
        System.out.println("\naddObject.\nShould print an array of numbers 1 to 8 then 10 followed by 19 nulls.\n currentObject == 9.");
        testArray.showAll();
        testArray.addObject("12");
        System.out.println("\naddObject.\nShould print an array as above, but with an 12 followed by 18 nulls.\n currentObject == 10.");
        testArray.showAll();

        // test addObjects
        testArray.addObjects(tempArray);
        System.out.println("\naddObjects.\nShould print an array as above, but followed by 1--8, then 10 nulls.\n currentObject == 18.");
        testArray.showAll();
        testArray = new ObjectArray();
        testArray.addObjects(tempArray);
        testArray.addObjects(tempArray);
        System.out.println("\naddObjects.\nShould print an array 1--8, then 1--8, then 14 nulls.\n currentObject == 16.");
        testArray.showAll();

        // test deleteObject
        testArray.deleteObject(0);
        System.out.println("\ndeleteObject.\nSame as previous array, but with first element missing, filled with nulls.\n currentObject == 15.");
        testArray.showAll();
        testArray.deleteObject(100);
        System.out.println("\ndeleteObject.\nTried to delete nonexistant index. \nSame as previous array.\n currentObject == 15.");
        testArray.showAll();

        // test deleteObjects
        testArray.deleteObjects(0, 5);
        System.out.println("\ndeleteObjects.\nSame as previous array, but with first 5 elements missing, filled with nulls.\n currentObject == 10.");
        testArray.showAll();
        testArray.deleteObjects(0, 0);
        System.out.println("\ndeleteObjects.\nDeleted 0 elements. \nSame as previous array.\n currentObject == 10.");
        testArray.showAll();
        testArray.deleteObjects(100, 0);
        System.out.println("\ndeleteObjects.\nTried to delete nonexistant element. \nSame as previous array.\n currentObject == 10.");
        testArray.showAll();

        // test equals
        testArray = new ObjectArray();
        ObjectArray testArray2 = new ObjectArray(tempArray);
        System.out.println("\nequals(). \nShould print false.");
        System.out.println(testArray.equals(testArray2));
        testArray = new ObjectArray(tempArray);
        System.out.println("\nequals(). \nShould print true.");
        System.out.println(testArray.equals(testArray2));

        // test getObjectAt
        System.out.println("\ngetObjectAt(). \nShould print 5.");
        System.out.println(testArray.getObjectAt(4));
        System.out.println("\ngetIntAt(). \nShould print null.");
        System.out.println(testArray.getObjectAt(100));
        System.out.println("\ngetIntAt(). \nShould print null.");
        System.out.println(testArray.getObjectAt(-1));

    }

}

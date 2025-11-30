/**
 * This Program Demonstrates Different Data Types in Java
 * JavaDocs is Java’s built-in documentation system used to generate HTML documentation from comments written 
 * in the source code. By adding  * style comments above classes, methods, and fields, developers can create 
 * clear API references that explain usage, parameters, return types, and exceptions. 
 * JavaDocs helps teams maintain consistent, readable, and professional documentation directly alongside code.
 * 
 * @author Vidhya Divakar
 * @version 1.0
 * @since 2025-07-20
 */
/**
 * /**
 * Default constructor for DataTypes class.
 * Initializes a DataTypes object.
 * A constructor in Java is a special method used to create and initialize
 * objects of a class.
 */
package javafiles.datatypes;

public class DataTypes {

    public DataTypes() {
        // Can initialize default constructor
    }

    /**
     * Data Types in Java
     * 1. Primitive Data Types
     * Byte Data Type
     * Byte Limit is -128 to 127
     * getByteValue method returns a byte value
     * returns byte value
     * 
     * @return an byte value
     */
    public byte getByteValue() {
        byte cent = 100; // 1 byte
        return cent;
    }

    /**
     * Integer Data Type
     * int limit 10 digits from negative to positive
     * 
     * @return an integer value
     */
    public int getIntValue() {
        int digit = 5;// Integer
        return digit;
    }

    /**
     * Short Data Type
     * Short limit is -32,768 to 32,767
     * 
     * @param number displays short value provided by the caller
     * @return the same short value after assigning 5000 to it
     */
    public short getShortValue(short number) {
        return number;
    }

    public void getDataTypeLong() {
        /**
         * Long Data Type
         * void does not return any value; void is used for methods that do not return a
         * value
         * Since long is defined inside void, we print the long value directly as it
         * cannot be called outside this method
         * Long limit is -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
         */
        long bigNumber = 15000000000L;
        System.out.println("Long value: " + bigNumber);
    }

    /**
     * Float Data Type
     * 
     * @return float value
     *         Float limit is 6 to 7 decimal digits
     */
    public float getDatatypeFloat() {
        float dollarInr = 88.72f;
        return dollarInr;
    }

    /**
     * Double Data Type
     * 
     * @return a double value
     *         Double limit is 15 decimal digits
     */

    public double getDatatypeDouble() {
        double pi = 3.141592653589793; // Double precision floating point number
        return pi;
    }

    /**
     * Character Data Type
     * 
     * @return a char value
     *         Char limit is single 16-bit Unicode character
     */
    public char getDatatypeChar() {
        char favLetter = 'V'; // Character
        return favLetter;
    }

    /**
     * Boolean Data Type
     * 
     * @return a boolean value
     *         Boolean limit is true or false
     */
    public boolean getDatatypeBoolean() {
        boolean javaEasy = true; // Boolean
        return javaEasy;
    }

    /**
     * Main Method
     * 
     * @author Vidhya Divakar
     * @version 1.0
     */
    /**
     * In class DataTypes, the main method is the entry point of the program.
     * It creates an instance of the DataTypes class and calls various methods to
     * demonstrate different data types in Java.
     * Finally, it prints the values of these data types to the console.
     * objDataTypes is an instance of the DataTypes class used to access its
     * methods.
     * getIntValue, getByteValue, getShortValue, getDatatypeFloat,
     * getDatatypeDouble,
     * getDatatypeChar, and getDatatypeBoolean are methods that return values of
     * different data types.
     * getShortValue((short)0) means it is called with a short argument of 0.
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        DataTypes objDataTypes = new DataTypes();
        int digit = objDataTypes.getIntValue();
        byte cent = objDataTypes.getByteValue();
        short number = objDataTypes.getShortValue((short) 0);
        float dollarInr = objDataTypes.getDatatypeFloat();
        double pi = objDataTypes.getDatatypeDouble();
        char favLetter = objDataTypes.getDatatypeChar();
        boolean javaEasy = objDataTypes.getDatatypeBoolean();
        {
            System.out.println("Byte value: " + cent);
            System.out.println("Integer value: " + digit);
            System.out.println("Short value: " + number);
            System.out.println("Float value: " + dollarInr);
            System.out.println("Double value: " + pi);
            System.out.println("Character value: " + favLetter);
            System.out.println("Boolean value: " + javaEasy);

        }
    }
}

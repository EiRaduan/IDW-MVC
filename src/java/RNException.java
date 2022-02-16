/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

/**
 *
 * @author saimor
 */
public class RNException extends Exception{

    /**
     * Creates a new instance of <code>RNException</code> without detail
     * message.
     */
    public RNException() {
    }

    /**
     * Constructs an instance of <code>RNException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RNException(String msg) {
        super(msg);
    }
}

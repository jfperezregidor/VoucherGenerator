package main.exceptions;

/**
 * Algorithm Exception is a custom exception.
 * @author Jeronimo
 * @version 1.0
 */
public class AlgorithmException extends Exception {

	 private static final long serialVersionUID = 1L;
	 public AlgorithmException() {
	  super();
	 }
	 public AlgorithmException(String message) {
	  super(message);
	 }
	 public AlgorithmException(String message, Throwable cause) {
	  super(message, cause);
	 }
	 public AlgorithmException(Throwable cause) {
	  super(cause);
	 }

}
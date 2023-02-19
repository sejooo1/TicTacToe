package ba.unsa.etf.rpr.exceptions;

/**
 * Custom exception MojException.
 */
public class MojException extends Exception{

    /**
     * Instantiates a new Moj exception.
     *
     * @param msg    the msg
     * @param reason the reason
     */
    public MojException(String msg, Exception reason){
        super(msg, reason);
    }

    /**
     * Instantiates a new Moj exception.
     *
     * @param msg the msg
     */
    public MojException(String msg){
        super(msg);
    }
}

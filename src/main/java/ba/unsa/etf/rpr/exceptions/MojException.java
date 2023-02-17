package ba.unsa.etf.rpr.exceptions;

public class MojException extends Exception{

    public MojException(String msg, Exception reason){
        super(msg, reason);
    }

    public MojException(String msg){
        super(msg);
    }
}

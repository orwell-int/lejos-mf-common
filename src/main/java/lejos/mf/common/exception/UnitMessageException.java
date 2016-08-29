package lejos.mf.common.exception;

/**
 * Created by Michaël Ludmann on 31/07/16.
 */
public class UnitMessageException extends Exception {
    public UnitMessageException(String message) {
        super(message);
    }

    public UnitMessageException(String message, String rawUnitMessage) {
        super(message + "; Raw message is: " + rawUnitMessage);
    }
}

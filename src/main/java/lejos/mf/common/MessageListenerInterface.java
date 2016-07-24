package lejos.mf.common;

public interface MessageListenerInterface {
    /***
     * Will be called when there is a new message ready
     * @param message
     */
    void receivedNewMessage(UnitMessage message);
}

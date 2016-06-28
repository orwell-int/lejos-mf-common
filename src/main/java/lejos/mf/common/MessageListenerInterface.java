package lejos.mf.common;

public interface MessageListenerInterface {
    void receivedNewMessage(StreamUnitMessage msg); // Will be called when there is a
    // new message ready
}

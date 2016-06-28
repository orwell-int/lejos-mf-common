package lejos.mf.common;

/**
 * Created by Michaël Ludmann on 27/06/16.
 */
public interface IUnitMessage {
    UnitMessageType getMessageType();

    void setMessageType(UnitMessageType type);

    String getPayload();

    void setPayload(String m_payload);
}

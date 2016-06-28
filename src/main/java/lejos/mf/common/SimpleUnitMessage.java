package lejos.mf.common;

/**
 * Created by Michaël Ludmann on 27/06/16.
 */
public class SimpleUnitMessage implements IUnitMessage {
    private static final char UNIT_MESSAGE_SEPARATOR = ';';
    private UnitMessageType unitMessageType;
    private String payload;

    @Override
    public UnitMessageType getMessageType() {
        return unitMessageType;
    }

    @Override
    public void setMessageType(UnitMessageType type) {
        this.unitMessageType = type;
    }

    @Override
    public String getPayload() {
        return payload;
    }

    @Override
    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(unitMessageType);
        stringBuilder.append(UNIT_MESSAGE_SEPARATOR);
        stringBuilder.append(payload);
        return stringBuilder.toString();
    }
}

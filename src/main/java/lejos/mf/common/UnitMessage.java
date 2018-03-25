package lejos.mf.common;

public class UnitMessage {
    public static final char UNIT_MESSAGE_SEPARATOR = ';';
    protected UnitMessageType unitMessageType;
    protected String payload;

    public UnitMessage(UnitMessageType unitMessageType,
                       String payload) {
        this.unitMessageType = unitMessageType;
        this.payload = payload;
    }

    public UnitMessageType getMessageType() {
        return unitMessageType;
    }

    public void setMessageType(UnitMessageType type) {
        this.unitMessageType = type;
    }

    public String getPayload() {
        return payload;
    }

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

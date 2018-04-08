package lejos.mf.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UnitMessage {
    public static final byte UNIT_MESSAGE_SEPARATOR = ';';
    protected byte[] payload;
    UnitMessageType unitMessageType;

    public UnitMessage(UnitMessageType unitMessageType,
                       String payload) {
        this.unitMessageType = unitMessageType;
        this.payload = payload.getBytes();
    }

    public UnitMessage(UnitMessageType unitMessageType,
                       byte[] payload) {
        this.unitMessageType = unitMessageType;
        this.payload = payload;
    }

    public UnitMessageType getMessageType() {
        return unitMessageType;
    }

    public void setMessageType(UnitMessageType type) {
        this.unitMessageType = type;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return String.valueOf(unitMessageType) + UNIT_MESSAGE_SEPARATOR + new String(payload);
    }

    public byte[] toByteArray() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(unitMessageType.name().getBytes());
        outputStream.write(UNIT_MESSAGE_SEPARATOR);
        outputStream.write(payload);

        return outputStream.toByteArray();
    }
}

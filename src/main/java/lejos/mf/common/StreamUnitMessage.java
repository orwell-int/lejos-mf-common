package lejos.mf.common;

public class StreamUnitMessage implements IUnitMessage {
    private static final char UNIT_MESSAGE_SEPARATOR = ';';
    private static byte STX = 2;
    private static byte ETX = 3;

    private UnitMessageType unitMessageType;
    private String payload;

    public StreamUnitMessage(UnitMessageType msgType, String payload) {
        unitMessageType = msgType;
        this.payload = payload;
    }

    // MSG Example: <STX>0:somepayload<ETX>
    public byte[] getEncodedMessage() {
        byte[] result = new byte[4 + payload.length()];

        result[0] = STX; // Start of new frame
        result[1] = (byte) unitMessageType.ordinal();
        result[2] = UNIT_MESSAGE_SEPARATOR;

        for (int i = 0; i < payload.length(); i++) {
            result[i + 3] = (byte) payload.charAt(i);
        }

        result[3 + payload.length()] = ETX; // End of new frame

        return result;
    }

    public static StreamUnitMessage setEncodedMessage(byte[] msg) {

        UnitMessageType msgType = UnitMessageType.values()[msg[1]];

        byte[] payloadBytesOnly = new byte[msg.length - 4]; // 4 since this is
        // <STX>, MegType,
        // :, and ETX, that
        // we remove
        for (int i = 0; i < payloadBytesOnly.length; i++) {
            payloadBytesOnly[i] = msg[i + 3];
        }

        String payload = new String(payloadBytesOnly);

        return new StreamUnitMessage(msgType, payload);
    }

    @Override
    public UnitMessageType getMessageType() {
        return unitMessageType;
    }

    @Override
    public void setMessageType(UnitMessageType type) {
        unitMessageType = type;
    }

    @Override
    public String getPayload() {
        return payload;
    }

    @Override
    public void setPayload(String m_payload) {
        this.payload = m_payload;
    }
}

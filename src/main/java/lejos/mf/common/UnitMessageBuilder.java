package lejos.mf.common;

import lejos.mf.common.exception.UnitMessageException;

import java.util.Arrays;
import java.util.List;

public class UnitMessageBuilder {
    public static UnitMessage build(byte[] rawUnitMessage) throws UnitMessageException {
        if (rawUnitMessage == null) {
            return null;
        }
        final List<byte[]> unitMessageBytesList = Utils.split(UnitMessage.UNIT_MESSAGE_SEPARATOR, rawUnitMessage, 2);

        if (unitMessageBytesList.size() != 2) {
            throw new UnitMessageException(
                    "Size of decoded UnitMessage is not correct: " + unitMessageBytesList.size());
        }

        try {
            UnitMessageType unitMessageType = UnitMessageType.valueOf(new String(unitMessageBytesList.get(0)));
            return new UnitMessage(unitMessageType, unitMessageBytesList.get(1));
        } catch (IllegalArgumentException e) {
            throw new UnitMessageException(
                    "Bad type decoded in UnitMessage: " + Arrays.toString(unitMessageBytesList.get(0)));
        }
    }
}

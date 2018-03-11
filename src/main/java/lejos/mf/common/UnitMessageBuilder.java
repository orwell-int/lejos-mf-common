package lejos.mf.common;

import lejos.mf.common.exception.UnitMessageException;

/**
 * Created by Michaël Ludmann on 31/07/16.
 */
public class UnitMessageBuilder {
    public static UnitMessage build(String rawUnitMessage) throws UnitMessageException {
        if (rawUnitMessage == null) {
            return null;
        }
        String[] splitMessage = rawUnitMessage.split(Character.toString(UnitMessage.UNIT_MESSAGE_SEPARATOR), 2);

        if (splitMessage.length != 2) {
            throw new UnitMessageException("Split raw string does not have 2 parts, but has " + splitMessage.length,
                                           rawUnitMessage);
        }

        try {
            UnitMessageType unitMessageType = UnitMessageType.valueOf(splitMessage[0]);
            return new UnitMessage(unitMessageType, splitMessage[1]);
        } catch (IllegalArgumentException e) {
            throw new UnitMessageException("UnitMessageType failed to be parsed", rawUnitMessage);
        }
    }
}

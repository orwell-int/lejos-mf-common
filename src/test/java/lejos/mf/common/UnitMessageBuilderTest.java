package lejos.mf.common;

import lejos.mf.common.exception.UnitMessageException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Michaël Ludmann on 31/07/16.
 */
@RunWith(JUnit4.class)
public class UnitMessageBuilderTest {

    @Test
    public void testBuildSuccess() throws Exception {
        String rawMessage = "Command;move 50.0 50.5";
        UnitMessage unitMessage = UnitMessageBuilder.build(rawMessage);
        assertEquals(UnitMessageType.Command, unitMessage.getMessageType());
        assertEquals("move 50.0 50.5", unitMessage.getPayload());
    }

    @Test(expected=UnitMessageException.class)
    public void testBuildFail_Exception_NoSeparator() throws Exception {
        String rawMessage = "Command";
        UnitMessageBuilder.build(rawMessage);
    }

    @Test(expected=UnitMessageException.class)
    public void testBuildFail_Exception_BadType() throws Exception {
        String rawMessage = "BadType;move 50.0 50.5";
        UnitMessageBuilder.build(rawMessage);
    }

    @Test
    public void testBuildFail_NullMessage() throws Exception {
        String rawMessage = null;
        UnitMessage unitMessage = UnitMessageBuilder.build(rawMessage);
        assertNull(unitMessage);
    }
}

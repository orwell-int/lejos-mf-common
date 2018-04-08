package lejos.mf.common;

import lejos.mf.common.exception.UnitMessageException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class UnitMessageBuilderTest {

    @Test
    public void testBuildSuccess() throws Exception {
        String rawMessage = "Command;move 50.0 50.5";
        UnitMessage unitMessage = UnitMessageBuilder.build(rawMessage.getBytes());
        assertEquals(UnitMessageType.Command, unitMessage.getMessageType());
        assertEquals("move 50.0 50.5", new String(unitMessage.getPayload()));
    }

    @Test(expected=UnitMessageException.class)
    public void testBuildFail_Exception_NoSeparator() throws Exception {
        String rawMessage = "Command";
        UnitMessageBuilder.build(rawMessage.getBytes());
    }

    @Test(expected=UnitMessageException.class)
    public void testBuildFail_Exception_BadType() throws Exception {
        String rawMessage = "BadType;move 50.0 50.5";
        UnitMessageBuilder.build(rawMessage.getBytes());
    }

    @Test
    public void testBuildFail_NullMessage() throws Exception {
        UnitMessage unitMessage = UnitMessageBuilder.build(null);
        assertNull(unitMessage);
    }
}

package lejos.mf.common;

import static lejos.mf.common.constants.UdpProxyFinderStrings.DiscoverProxyRobotsRequest;

public class DiscoverProxyRobotsMessage {
    private final static String header = DiscoverProxyRobotsRequest;
    private final static String splitCharacter = " ";
    private final String robotName;

    public DiscoverProxyRobotsMessage(String robotName) {
        this.robotName = robotName;
    }

    public static DiscoverProxyRobotsMessage build(byte[] bytes) {
        String[] message = new String(bytes).trim().split(splitCharacter);
        if (isDiscoveryRobotRequest(message)) {
            return new DiscoverProxyRobotsMessage(message[1]);
        }

        return null;
    }

    private static boolean isDiscoveryRobotRequest(String[] message) {
        return message.length == 2 && message[0].equals(DiscoverProxyRobotsRequest);
    }

    public String GetRobotname() {
        return robotName;
    }
}

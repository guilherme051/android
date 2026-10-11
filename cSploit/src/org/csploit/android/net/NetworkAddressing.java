package org.csploit.android.net;

/** IPv4 mask arithmetic in the little-endian format used by DhcpInfo. */
public final class NetworkAddressing {
  private NetworkAddressing() { }

  public static int maskFromPrefix(int prefix) {
    if (prefix < 1 || prefix > 32)
      throw new IllegalArgumentException("Unknown or unsupported IPv4 prefix: " + prefix);
    int networkOrder = (int) (0xffffffffL << (32 - prefix));
    return Integer.reverseBytes(networkOrder);
  }

  public static boolean isValidMask(int mask) {
    long value = Integer.reverseBytes(mask) & 0xffffffffL;
    long hosts = (~value) & 0xffffffffL;
    return value != 0 && (hosts & (hosts + 1)) == 0;
  }

  public static int selectMask(Integer interfacePrefix, int dhcpMask) {
    if (interfacePrefix != null)
      return maskFromPrefix(interfacePrefix.intValue());
    if (!isValidMask(dhcpMask))
      throw new IllegalArgumentException("IPv4 subnet mask unavailable; refusing a /0 network.");
    return dhcpMask;
  }

  public static boolean isBroadcast(int address, int local, int mask) {
    if (address == -1)
      return true;
    int hosts = ~mask;
    // /31 point-to-point networks and /32 host routes have no directed broadcast.
    return Integer.bitCount(hosts) > 1 && address == ((local & mask) | hosts);
  }

  public static boolean isBroadcastMac(byte[] mac) {
    if (mac == null || mac.length != 6)
      return false;
    for (byte octet : mac)
      if ((octet & 0xff) != 0xff)
        return false;
    return true;
  }
}

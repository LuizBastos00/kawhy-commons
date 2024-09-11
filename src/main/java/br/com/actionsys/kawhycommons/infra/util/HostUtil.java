package br.com.actionsys.kawhycommons.infra.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;

public class HostUtil {

  public static String getHost() {
    try {
      return StringUtils.left(InetAddress.getLocalHost().getHostName(), 10);
    } catch (UnknownHostException e) {
      return "";
    }
  }
}

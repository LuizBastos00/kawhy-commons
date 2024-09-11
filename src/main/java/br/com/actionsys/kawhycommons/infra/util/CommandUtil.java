package br.com.actionsys.kawhycommons.infra.util;

public class CommandUtil {

    public static String run(String command) {
        try {
            String cmds[] = {"cmd", "/c", command};
            ProcessBuilder pb = new ProcessBuilder(cmds);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            String result = new String(process.getInputStream().readAllBytes());
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void openLink(String linkUrl) throws Exception {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start " + linkUrl);
        } catch (Exception e) {
            throw new Exception("Erro ao abrir link: " + linkUrl + ". \n" + e);
        }
    }
}

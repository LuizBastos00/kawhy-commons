package br.com.actionsys.kawhycommons.infra.util;

import br.com.actionsys.kawhycommons.Constants;
import br.com.actionsys.kawhycommons.infra.exception.IgnoreFileException;
import br.com.actionsys.kawhycommons.infra.exception.OtherFileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class FilesUtil {

    public static void write(String path, List<String> lines) throws IOException {
        write(Paths.get(path), lines);
    }

    public static void write(Path path, List<String> lines) throws IOException {
        Files.createDirectories(path.getParent());
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    }

    public static void write(String path, String content) {
        write(Paths.get(path), content);
    }

    public static void write(Path path, String content) {
        write(path, content.getBytes());
    }

    public static void add(Path path, byte[] content) {
        write(path, content, StandardOpenOption.APPEND);
    }

    public static void write(Path path, byte[] content) {
        write(path, content, StandardOpenOption.CREATE);
    }

    public static void write(Path path, byte[] content, StandardOpenOption standardOpenOption) {
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, content, standardOpenOption);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void move(File origin, String to) {
        try {
            Files.move(Paths.get(origin.getAbsolutePath()), Paths.get(to), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao mover arquivo. De : " + origin.getAbsolutePath() + " para : " + to);
        }
    }

    public static void isXmlFile(File file) throws Exception {
        if (file.isDirectory()) {
            throw new IgnoreFileException("Diretório encontrado, era esperado um arquivo xml, o diretório será ignorado.  " + file.getAbsolutePath());//"MA-E02"
        } else if (file.length() <= 0) {
            throw new Exception("Arquivo está vazio.");
        } else if (!file.getAbsolutePath().toLowerCase().endsWith(Constants.XML_EXTENSION)) {
            throw new OtherFileException("Extensão do arquivo inválida : " + file.getAbsolutePath());
        }
    }

    public static void createDirectoryIfNotNull(String dirPath) {
        if (dirPath != null) {
            FilesUtil.createDirectory(dirPath);
        }
    }

    public static void createDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public static String readToString(File file) throws Exception {
        return new String(readToBytes(file));
    }

    public static byte[] readToBytes(File file) throws Exception {
        try {
            return Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException e) {
            throw new IgnoreFileException("Arquivo ainda não está pronto para leitura : " + file.getAbsolutePath());
        } catch (IOException ioException) {
            throw new Exception(ioException);
        }
    }

    public static byte[] readToBytes(String fileUrl) throws Exception {
        File file = new File(fileUrl);
        return readToBytes(file);
    }

    public static List<String> readLines(Path file) {
        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stream<String> readLines(Resource resource) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.lines();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recebe um Path contendo um diretorio e retorna as linhas de todos os arquivos
     */
    public static List<String> readLinesFromDirectory(Path directory) {

        if (!Files.isDirectory(directory)) {
            throw new RuntimeException("Parametro recebido não e um diretorio");
        }

        List<String> lines = new ArrayList<>();

        try (Stream<Path> files = Files.list(directory)) {
            files.forEach(file -> lines.addAll(readLines(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public static void atomicWrite(ByteArrayOutputStream out, String fileTempStr, String fileWorkStr) throws Exception {
        File fi = new File(fileTempStr);
        if (fi.exists()) {
            fi.delete();
            log.info("Arquivo já existia e foi removido : " + fileTempStr);
        }

        File fileTemp = new File(fileTempStr);
        try (FileOutputStream fileTempO = new FileOutputStream(fileTemp)) {
            fileTempO.write(out.toByteArray());
        } catch (Exception e) {
            throw new Exception("Erro ao escrever anexo da memória ram para o disco, nome do arquivo : " + fileTempStr, e);
        }

        File fileWork = new File(fileWorkStr);
        if (fileWork.exists()) {
            log.warn("Arquivo já existe na pasta work, ele será sobreescrito. : " + fileWorkStr);
        }
        fileTemp.renameTo(fileWork);
    }

    public static void deleteFile(String fileUrl) throws IOException {

        Files.deleteIfExists(Path.of(fileUrl));
    }

    public static void deleteDir(String dirUrl) throws IOException {

        try (Stream<Path> paths = Files.walk(Path.of(dirUrl))) {
            paths.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    public static void copyDirectory(Path sourcePath, String destDir) throws IOException {

        log.info("Copiando diretorios {} para {}", sourcePath, destDir);

        try (Stream<Path> paths = Files.walk(sourcePath)) {

            for (Path source : paths.toList()) {

                Path destination = Paths.get(destDir, source.toString().substring(sourcePath.toString().length()));

                //TODO DEVE SUBSTITUIR ARQUIVOS EXISTENTES?
                if (!Files.exists(destination) || !Files.isDirectory(destination)) {
                    Files.createDirectories(Path.of(destDir));
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    public static Path convertUriToPath(URI uri, String relativePath) throws IOException {
        if (uri.getScheme().contains("jar")) {
            try {
                return FileSystems.newFileSystem(uri, Collections.emptyMap()).getPath(relativePath);
            } catch (FileSystemAlreadyExistsException e) {
                return FileSystems.getFileSystem(uri).getPath(relativePath);
            }
        } else {
            return Path.of(uri);
        }
    }

}

package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.Scaffolded;
import net.xdexamples.ExampleUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

@Scaffolded
public class FilesExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {

            Files instance = ExampleUtils.makeInstance(Files.class);

            Path path = null;
            OpenOption openOptions = null;
            InputStream inputStream = Files.newInputStream(path, openOptions);

            OutputStream outputStream = Files.newOutputStream(path, openOptions);

            Set<? extends OpenOption> optionSet = null;
            FileAttribute<?> attributes = null;
            SeekableByteChannel seekableByteChannel = Files.newByteChannel(path, optionSet, attributes);
            SeekableByteChannel seekableByteChannel1 = Files.newByteChannel(path, openOptions);

            String glob = null;
            DirectoryStream.Filter<? super Path> filter = null;
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            DirectoryStream<Path> paths1 = Files.newDirectoryStream(path, glob);
            DirectoryStream<Path> paths2 = Files.newDirectoryStream(path, filter);

            Path file = Files.createFile(path, attributes);

            Path directory = Files.createDirectory(path, attributes);

            Path directories = Files.createDirectories(path, attributes);

            String prefix = null;
            String suffix = null;
            Path tempFile = Files.createTempFile(path, prefix, suffix, attributes);
            Path tempFile1 = Files.createTempFile(prefix, suffix, attributes);

            Path tempDirectory = Files.createTempDirectory(path, prefix, attributes);
            Path tempDirectory1 = Files.createTempDirectory(prefix, attributes);

            Path symbolicLink = Files.createSymbolicLink(path, path, attributes);

            Path link = Files.createLink(path, path);

            Files.delete(path);

            boolean b = Files.deleteIfExists(path);

            CopyOption copyOptions = null;
            Path copy = Files.copy(path, path, copyOptions);
            long copy1 = Files.copy(inputStream, path, copyOptions);
            long copy2 = Files.copy(path, outputStream);

            Path move = Files.move(path, path, copyOptions);

            Path path1 = Files.readSymbolicLink(path);

            FileStore fileStore = Files.getFileStore(path);

            boolean sameFile = Files.isSameFile(path, path);

            long mismatch = Files.mismatch(path, path);

            boolean hidden = Files.isHidden(path);

            String s = Files.probeContentType(path);

            Class<DummyFileAttributeView> type = null;
            LinkOption linkOptions = null;
            DummyFileAttributeView fileAttributeView = Files.getFileAttributeView(path, type, linkOptions);

            Class<DummyBasicFileAttributes> tt = null;
            DummyBasicFileAttributes dummyBasicFileAttributes = Files.readAttributes(path, tt, linkOptions);
            String attrib = null;
            Map<String, Object> stringObjectMap = Files.readAttributes(path, attrib, linkOptions);

            Object object = null;
            Path path2 = Files.setAttribute(path, attrib, object, linkOptions);

            Object attribute = Files.getAttribute(path, attrib, linkOptions);

            Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, linkOptions);

            Set<PosixFilePermission> permissions = null;
            Path path3 = Files.setPosixFilePermissions(path, permissions);

            UserPrincipal owner = Files.getOwner(path, linkOptions);
            Path path4 = Files.setOwner(path, owner);

            boolean symbolicLink1 = Files.isSymbolicLink(path);
            boolean directory1 = Files.isDirectory(path, linkOptions);
            boolean regularFile = Files.isRegularFile(path, linkOptions);

            FileTime lastModifiedTime = Files.getLastModifiedTime(path, linkOptions);
            Path path5 = Files.setLastModifiedTime(path, lastModifiedTime);

            long size = Files.size(path);

            boolean exists = Files.exists(path, linkOptions);

            boolean b1 = Files.notExists(path, linkOptions);

            boolean readable = Files.isReadable(path);

            boolean writable = Files.isWritable(path);

            boolean executable = Files.isExecutable(path);

            Set<FileVisitOption> fileVisitOptions = null;
            int maxDepth = 0;
            FileVisitor<? super Path> visitor = null;
            Path path6 = Files.walkFileTree(path, fileVisitOptions, maxDepth, visitor);
            Path path7 = Files.walkFileTree(path, visitor);

            Charset charset = null;
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            BufferedReader bufferedReader1 = instance.newBufferedReader(path, charset);

            BufferedWriter bufferedWriter = Files.newBufferedWriter(path, openOptions);
            BufferedWriter bufferedWriter1 = Files.newBufferedWriter(path, charset, openOptions);

            byte[] bytes = Files.readAllBytes(path);

            String s1 = Files.readString(path);
            String s2 = Files.readString(path, charset);

            List<String> strings = Files.readAllLines(path);
            List<String> strings1 = Files.readAllLines(path, charset);

            Path write = Files.write(path, bytes, openOptions);
            Iterable<? extends CharSequence> lines = null;
            Path write1 = Files.write(path, lines, charset, openOptions);
            Path write2 = Files.write(path, lines, openOptions);

            CharSequence charSequence = null;
            Path path8 = Files.writeString(path, charSequence, openOptions);
            Path path9 = Files.writeString(path, charSequence, charset, openOptions);

            Stream<Path> list = Files.list(path);

            FileVisitOption fileVisitOption = null;
            Stream<Path> walk = Files.walk(path, fileVisitOption);
            Stream<Path> walk1 = Files.walk(path, maxDepth, fileVisitOption);

            BiPredicate<Path, BasicFileAttributes> matcher = null;
            Stream<Path> pathStream = Files.find(path, maxDepth, matcher, fileVisitOption);

            Stream<String> lines1 = Files.lines(path);
            Stream<String> lines2 = Files.lines(path, charset);

        }
    }

    public interface DummyFileAttributeView extends FileAttributeView {

    }

    public interface DummyBasicFileAttributes extends BasicFileAttributes {
    }
}

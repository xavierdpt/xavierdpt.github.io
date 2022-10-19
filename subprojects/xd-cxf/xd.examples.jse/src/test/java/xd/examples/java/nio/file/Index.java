package xd.examples.java.nio.file;

import xdtest.ExampleIndex;

import java.nio.file.AccessDeniedException;
import java.nio.file.AccessMode;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.ClosedDirectoryStreamException;
import java.nio.file.ClosedFileSystemException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;
import java.nio.file.NotDirectoryException;
import java.nio.file.NotLinkException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.ProviderMismatchException;
import java.nio.file.ProviderNotFoundException;
import java.nio.file.ReadOnlyFileSystemException;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;

@ExampleIndex({

        AccessDeniedException.class,

        AccessMode.class,
        AccessModeExample.class,

        AtomicMoveNotSupportedException.class,

        ClosedDirectoryStreamException.class,

        ClosedFileSystemException.class,

        ClosedWatchServiceException.class,

        CopyOption.class,
        CopyOptionExample.class,

        DirectoryIteratorException.class,

        DirectoryNotEmptyException.class,

        DirectoryStream.class,
        DirectoryStreamExample.class,

        FileAlreadyExistsException.class,

        Files.class,
        FilesExample.class,

        FileStore.class,
        FileStoreExample.class,

        FileSystem.class,
        FileSystemExample.class,

        FileSystemAlreadyExistsException.class,

        FileSystemException.class,

        FileSystemLoopException.class,

        FileSystemNotFoundException.class,

        FileSystems.class,
        FileSystemsExample.class,

        FileVisitOption.class,

        FileVisitor.class,

        FileVisitResult.class,

        InvalidPathException.class,

        LinkOption.class,

        LinkPermission.class,

        NoSuchFieldException.class,

        NotDirectoryException.class,

        NotLinkException.class,

        OpenOption.class,

        Path.class,
        PathExample.class,

        PathMatcher.class,

        Paths.class,
        PathsExample.class,

        ProviderMismatchException.class,

        ProviderNotFoundException.class,

        ReadOnlyFileSystemException.class,

        SecureDirectoryStream.class,

        SimpleFileVisitor.class,

        StandardCopyOption.class,

        StandardOpenOption.class,

        StandardWatchEventKinds.class,

        Watchable.class,

        WatchEvent.class,

        WatchKey.class,

        WatchService.class
})
public class Index {
}

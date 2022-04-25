package com.wygplay.file;

import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author wyg
 * @date 2022/1/3 14:46
 */
public class TestFiles {
    @Test
    public void testWalkFileTree() throws Exception {
        Path path = Paths.get("D:\\my-doc\\my-note\\编程\\JVM");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

                    System.out.println(file.getFileName());
                    System.out.println(file.getNameCount());

                return FileVisitResult.CONTINUE;
            }
        });
    }
}

package edu.algs.chap1p3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.43  Listing files. A folder is a list of files and folders. Write a program that takes the name
 * of a folder as a command-line argument and prints out all of the files contained in that folder,
 * with the contents of each folder recursively listed (indented) under that folder’s name. Hint : Use a queue, and see java.io.File.
 */
class FileLister {

    private static final String INDENT = "\t";
    private static final String PREFIX = "'---";

    String printFiles(String directory) {
        List<DirDescription> files = listFiles(directory, 0);
        StringBuilder sb = new StringBuilder();
        for (DirDescription file : files) {
            String deepIndent = new String(new char[file.deep]).replace("\0", INDENT);
            sb.append(deepIndent)
                    .append(PREFIX)
                    .append(file.name)
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * Prepares list of files in the given directory to be printed
     */
    private List<DirDescription> listFiles(String directory, int deep) {
        File dir = new File(directory);
        List<DirDescription> result = new ArrayList<>();
        result.add(new DirDescription(dir.getName(), deep));
        if (dir.isDirectory()) {
            //noinspection ConstantConditions
            for (String subDir : dir.list()) {
                result.addAll(listFiles(directory + "/" + subDir, deep + 1));
            }
        }
        return result;
    }

    private class DirDescription {
        String name;
        int deep;

        DirDescription(String name, int deep) {
            this.name = name;
            this.deep = deep;
        }

    }

}

package edu.algs.chap1p3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileListerTest {

    private FileLister sut = new FileLister();

    @Test
    public void shouldPrintFiles() throws Exception {
        String expected = "'---testDir\n" +
                "\t'---dirA\n" +
                "\t'---dirB\n" +
                "\t\t'---dirX\n" +
                "\t\t\t'---fileW.txt\n" +
                "\t\t\t'---fileW.zip\n" +
                "\t\t'---file123.txt\n" +
                "\t'---dirC\n" +
                "\t\t'---file123.txt\n" +
                "\t\t'---fileX.txt\n" +
                "\t\t'---fileY.txt\n" +
                "\t'---fileX.txt\n";
        String result = sut.printFiles("src/test/resources/edu/algs/chap1p3/testDir");
        assertThat(result).isEqualTo(expected);
    }

}
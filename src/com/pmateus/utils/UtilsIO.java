package com.pmateus.utils;

import static com.pmateus.utils.Settings.FILE_LINE_BREAKER;
import static com.pmateus.utils.Settings.WRITE_PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Paulo Mateus
 */
public class UtilsIO {

    /**
     * Ler arquivo
     *
     * @param arquivo path
     * @return conteúdo lido em string[] separado por '\r\n'
     */
    public static String[] readFile(String arquivo) {
        String[] linhas = null;
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            byte[] a = new byte[fin.available()];
            fin.read(a);
            fin.close();
            linhas = new String(a).split(FILE_LINE_BREAKER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    /**
     * Ler arquivo
     *
     * @param file file to read
     * @return conteúdo lido em string[] separado por '\r\n'
     */
    public static String[] readFile(File file) {
        String[] linhas = null;
        try {
            FileInputStream fin = new FileInputStream(file);
            byte[] a = new byte[fin.available()];
            fin.read(a);
            fin.close();
            linhas = new String(a).split(FILE_LINE_BREAKER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    /**
     * Escrever em arquivo
     *
     * @param fileName fileName
     * @param content conteúdo
     * @param isAppend adicionar ou substituir conteúdo
     * @return
     */
    public static boolean writeFile(String fileName, String content, boolean isAppend) {
        File directory = new File(WRITE_PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }

        FileOutputStream fop = null;
        File file;
        boolean flag = false;
        try {
            file = new File(WRITE_PATH + File.separator + fileName);
            fop = new FileOutputStream(file, isAppend);
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * Pegar caminho absoluto de todos os arquivos
     *
     * @param pattern regex patthen of files to get
     * @param folder initial folder
     * @param used
     * @param neew
     */
    public static void getFileNames(final String pattern, final File folder, List<File> used, List<File> neew) {
        for (File f : folder.listFiles()) {
            if (f.isDirectory()) {
                getFileNames(pattern, f, used, neew);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    if (!used.contains(f)) {
                        used.add(f);
                        neew.add(f);
                    }
                }
            }
        }
    }
}

package com.ed.filehandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlainHandler {

    public void fileWriter(String StringPath, String[] content) throws IOException {
        Path path = Paths.get(StringPath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(String line : content) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriter(String StringPath, ArrayList<String> content) {
        Path path = Paths.get(StringPath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(String line : content) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriterNewLine(String StringPath, ArrayList<String> content) {
        Path path = Paths.get(StringPath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(String line : content) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriterNewLineUTF(String stringPath, ArrayList<String> content) {
        try {
            //OutputStreamWriter writer = new OutputStreamWriter((new FileOutputStream(stringPath)), StandardCharsets.UTF_8);
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(stringPath), "UTF-8"));
            //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(stringPath), StandardCharsets.UTF_8));
            for(String line : content) {
                writer.write(line);
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hideFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String stringPath) throws IOException {
        //Path path = Paths.get(stringPath);
        File file = new File(stringPath);
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        output.write("");
    }

    public ArrayList<String> fileLoader(String stringPath) {
        ArrayList<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader(stringPath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                data.add(line);
            }
            fr.close();
            br.close();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<String> fileLoaderUTF(String stringPath) {
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(stringPath));
            String line;
            while((line = in.readLine()) != null) {
                String utfString = new String(line.getBytes(), "UTF-8");
                data.add(utfString);
            }
            in.close();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean fileExist(String path) {
        File file = new File(path);
        if(file.exists()) {
            return true;
        }
        return false;
    }

    public void deleteFile(String fileName){
        File f = new File(fileName);
        if(f.exists()){
            f.delete();
            System.out.println("file deleted");
        }
    }

    public void createDir(String name) {
        File dir = new File(name);
        dir.mkdir();
    }

    public void createDirs(String name) {
        File dir = new File(name);
        dir.mkdirs();
    }

}

package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream outputStream;

    public QuestionFileOutputStream(AmigoOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Вы действительно хотите закрыть поток? Д/Н");
            String answer = br.readLine();
            if (answer.equals("Д")) outputStream.close();
        }
    }
}


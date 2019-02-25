package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader ir = null;
        try {
            switch (type) {
                case JPG:
                    ir = new JpgReader();
                    break;
                case BMP:
                    ir = new BmpReader();
                    break;
                case PNG:
                    ir = new PngReader();
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return ir;
    }
}

package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        String fileName = getFileName();
        int maxId = 0;
        ArrayList<Item> allItems = new ArrayList<>();                   // for short time
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                Item item = stringToItem(br.readLine());
                if (item.getId().intValue() > maxId) maxId = item.getId().intValue();
                allItems.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Item.setItemCounter(maxId);
// /Users/mhlv/Documents/test3 copy
//        String[] param = new String[] {"-c","productName", "123.00", "23"};
//        String[] param = new String[] {"-u", "19847", "ШКУРА", "ДУРА", "15.15", "500"};
//        args = param;
        if (args.length > 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                Iterator<Item> iterator = allItems.iterator();
                Item item = null;
                switch (args[0]) {
                    case "-c": {
                        item = create(args);
                        allItems.add(item);
                        bw.write("\n");
                        bw.write(itemToString(item));
                    }
                    break;
                    case "-u": {
                        while (iterator.hasNext()) {
                            item = iterator.next();
                            if (item.getId().equals(new BigInteger(args[1]))) {
                                update(item, args);
                            }
                            bw.write(itemToString(item));
                            if (iterator.hasNext()) bw.write("\n");

                        }
                    }
                    break;
                    case "-d": {
                        while (iterator.hasNext()) {
                            item = iterator.next();
                            if (item.getId().equals(new BigInteger(args[1]))) {
                                iterator.remove();
                            } else {
                                bw.write(itemToString(item));
                                bw.write("\n");
                            }
                        }
                    }
                    break;
                }
            } catch (IOException e) { e.printStackTrace();}

        }

        for (Item allItem : allItems) {
            System.out.println(allItem.getProductName());
        }

    }

    public static Item create(String[] param) { //change arguments
        int i = 1;
        String productName = param[i];
        double price = Double.parseDouble(param[i + 1]);
        int quantity = Integer.parseInt(param[i + 2]);

        return new Item(productName, price, quantity);
    }

    public static void update(Item item, String[] args){
        StringBuffer sb = new StringBuffer();
        for(int i= 2; i <= args.length - 3; i++) {
            sb.append(args[i].trim());
            if ((i <= args.length - 3)) sb.append(" ");
        }
        item.setProductName(sb.toString());
        item.setPrice(Double.parseDouble(args[args.length - 2].trim()));
        item.setQuantity(Integer.parseInt(args[args.length - 1].trim()));
    }

    public static Item stringToItem(String string) { //change arguments

        string = addSpace(string, 50);
        BigInteger id = new BigInteger(string.substring(0, 8).trim());
        String productName = string.substring(8, 38).trim();
        double price = Double.parseDouble(string.substring(38, 46).trim());
        int quantity = Integer.parseInt(string.substring(46, 50).trim());
        return new Item(id,productName, price, quantity);

    }

    public static String itemToString(Item item) {
        BigInteger id = item.getId();
        String productName = item.getProductName();
        double price = item.getPrice();
        int quantity = item.getQuantity();

        StringBuffer sb = new StringBuffer();

        String idString = addSpace("" + id, 8);
        String productNameString = addSpace(productName, 30);
        String priceString = addSpace(String.format("%.2f", price), 8);
        String quantityString = addSpace("" + quantity, 4);

        sb.append(idString).append(productNameString).append(priceString).append(quantityString);
        return sb.toString();

    }

    public static String addSpace(String string, int reqLen) {
        StringBuffer sb = new StringBuffer(string);
        while (sb.length() < reqLen) sb.append(" ");
        return sb.toString();
    }

    private static String getFileName() {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {

        }
        return fileName;
//        return "/Users/mhlv/Documents/test3 copy";
    }

}

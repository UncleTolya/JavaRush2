package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
//    public static volatile ArrayList<Item> allItems = new ArrayList<>(); //back
//    public static String[] param;                                         //back

    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {

        }
        int maxId = 0;
        ArrayList<Item> allItems = new ArrayList<>();                   // for short time
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                Item item = stringToItem(br.readLine());
                if (item.getId() > maxId) maxId = item.getId();
                allItems.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Item.setItemCounter(maxId);

//        param = args;                                                      //back
//        String[] param = new String[] {"-c","productName", "123.00", "23"};
        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allItems) {
                        Item item = create(args);
                        allItems.add(item);
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                            bw.write("\n");
                            bw.write(itemToString(item));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
            }
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

    public static Item stringToItem(String string) { //change arguments

        string = addSpace(string, 50);
        int id = Integer.parseInt(string.substring(0, 8).trim());
        String productName = string.substring(8, 38).trim();
        double price = Double.parseDouble(string.substring(38, 46).trim());
        int quantity = Integer.parseInt(string.substring(46, 50).trim());
        return new Item(id,productName, price, quantity);

    }

    public static String itemToString(Item item) {
        int id = item.getId();
        String productName = item.getProductName();
        double price = item.getPrice();
        int quantity = item.getQuantity();

        StringBuffer sb = new StringBuffer();

        String idString = addSpace("" + id, 8);
        String productNameString = addSpace(productName, 30);
        String priceString = addSpace("" + price, 8);
        String quantityString = addSpace("" + quantity, 4);

        sb.append(idString).append(productNameString).append(priceString).append(quantityString);
        return sb.toString();

    }

    public static String addSpace(String string, int reqLen) {
        StringBuffer sb = new StringBuffer(string);
        while (sb.length() < reqLen) sb.append(" ");
        return sb.toString();
    }
}

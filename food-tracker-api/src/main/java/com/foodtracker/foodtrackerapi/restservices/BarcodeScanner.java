package com.foodtracker.foodtrackerapi.restservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class BarcodeScanner {

    private static String API_KEY = " ";

    public static String getBarcodeData(int barcode) throws IOException {
        URL url = new URL("https://api.barcodelookup.com/v3/products?barcode=" + barcode + "&formatted=y&key=" + API_KEY);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String str = "";
        String data = "";
        while (null != (str= br.readLine())) {
            data+=str;
        }
        return data;
    }
}

package com.yhfund.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author : zp
 *         Date: 2019/4/21 13:20
 *         Description:
 */
public class Constans {

    public static String FOLDER_IMAGE01;
    public static String FOLDER_IMAGE02;
    public static String FOLDER_IMAGE4M;
    public static String FOLDER_IMAGE5M;

    static {
        Properties pro = new Properties();
        InputStream  in = Constans.class.getResourceAsStream("/imgUrl.properties");

        try {
            pro.load(new InputStreamReader(in, "UTF-8"));

            FOLDER_IMAGE01 = pro.getProperty("imgUrl01");
            FOLDER_IMAGE02 = pro.getProperty("imgUrl02");
            FOLDER_IMAGE4M = pro.getProperty("imgUrl4M");
            FOLDER_IMAGE5M = pro.getProperty("imgUrl5M");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

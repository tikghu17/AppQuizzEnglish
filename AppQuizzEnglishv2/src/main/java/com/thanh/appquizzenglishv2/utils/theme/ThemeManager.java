/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thanh.appquizzenglishv2.utils.theme;

import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemeManager {

    private static AbstractFactory theme = new DefaultFactory();

    public static void setTheme(AbstractFactory atheme) {
        theme = atheme;
    }

    public static void applyTheme(Scene scene) {

        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(theme.getType());

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thanh.appquizzenglishv2.utils.theme;

import com.thanh.appquizzenglishv2.App;

/**
 *
 * @author admin
 */
public class DefaultFactory implements AbstractFactory{
     @Override
    public String getType() {
        return App.class.getResource("Style.css").toExternalForm();
    }
}

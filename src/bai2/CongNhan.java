/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author DELL
 */
public class CongNhan extends CanBo {
 
    public int level;

    public CongNhan(String name, int age, String sex, String address, int level) {
        super(name, age, sex, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

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
public class KySu extends CanBo {

    public String major;

    public KySu(String name, int age, String sex, String address,String major) {
        super(name, age, sex, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}

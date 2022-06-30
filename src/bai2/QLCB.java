/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class QLCB {
    private ArrayList<CanBo> list = new ArrayList<>();
    
    public void add() {
        int age = 0;
        int level;
        String name, sex, address, major, job;
        Scanner sc = new Scanner(System.in);
        int select = 0;
        boolean isValid = false;

        System.out.println("--- THEM CAN BO ---");
        System.out.println("1. Cong nhan");
        System.out.println("2. Ky su    ");
        System.out.println("3. Nhan vien");
        System.out.print("Vui long nhap lua chon: ");

        do {
            try {
                isValid = true;
                select = sc.nextInt();
                if (select <= 0 || select >= 4) {
                    System.out.println("Lua chon cua ban khong hop le!");
                    isValid = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Lua chon cua ban khong hop le!");
                isValid = false;
            }
            sc.nextLine();
        } while (isValid == false);
        isValid = false;
        do {

            isValid = true;
            System.out.print("Nhap ho va ten: ");
            name = sc.nextLine().trim();
            if (name.equals("")) {
                System.out.println("Ho va ten khong duoc bo trong!");
                isValid = false;
            }

        } while (isValid == false);
        isValid = false;
        do {
            try {
                isValid = true;
                System.out.print("Nhap tuoi: ");
                age = sc.nextInt();
                if (age <= 0 || age >= 125) {
                    System.out.println("gia tri nhap chua hop le!");
                    isValid = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("gia tri nhap chua hop le!");
                isValid = false;
            }
            sc.nextLine();
        } while (isValid == false);
        isValid = false;
        do {
            isValid = true;
            System.out.print("Nhap gioi tinh: ");
            sex = sc.nextLine().trim();
            if (!(sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("Other"))) {
                System.out.println("Gioi tinh phai la (male/female/other)");
                isValid = false;
            }
        } while (isValid == false);
        isValid = false;
        do {
            isValid = true;
            System.out.print("Nhap dia chi: ");
            address = sc.nextLine().trim();
            if (address.equals("")) {
                System.out.print("Dia chi khong duoc bo trong!");
                isValid = false;
            }
        } while (isValid == false);
        isValid = false;
        do {
            isValid = true;
            if (select == 1) {
                level = -1;
                do {
                    try {
                        System.out.print("Nhap bac: ");
                        level = sc.nextInt();
                        CongNhan congNhan = new CongNhan(name, age, sex, address, level);
                       list.add(congNhan);
                    } catch (InputMismatchException e) {
                        System.out.println("bac phai tu 1 den 10!");
                    }
                    sc.nextLine();
                } while (level <= 0 || level >= 10);
            } else if (select == 2) {
                System.out.print("Nhap nghanh dao tao: ");
                major = sc.nextLine().trim();
                
                if(major.equals("")){
                    System.out.println("nghanh dao tao khong duoc bo trong!");
                isValid = false;
                }
                KySu kySu = new KySu(name, age, sex, address,major);
                list.add(kySu);
            } else {
                System.out.print("Nhap cong viec: ");
                job = sc.nextLine().trim();
                if(job.equals("")){
                    System.out.println("Cong viec khong duoc bo trong");
                    isValid = false;
                }
                NhanVien nhanVien = new NhanVien(name, age, sex, address, job);
                list.add(nhanVien);
            }

        } while (isValid == false);
        

    }

    public void searchByName(){
        Scanner sc = new Scanner(System.in);
        String userInput;
        System.out.print("Vui long nhap ten can bo ban muon tim: ");
        userInput = sc.nextLine();
        ArrayList newList = new ArrayList<>();
        for(CanBo canBo : this.list){
            if(canBo.getName().equalsIgnoreCase(userInput)){
                newList.add(canBo);
            }
        }
        if(newList.size() > 0){
            show(newList);
        }else{
            System.out.println("tim kiem khong hop le!");
            System.out.println("danh sach can bo hien tai");
            show(list);
        }
    }    
    public void show(ArrayList<CanBo> newList){
        System.out.println("Name                     ||  age ||  sex  ||     address          ||");
        for(CanBo canBo : newList){
            System.out.printf("%-24s || %-4d || %-5s || %-20s ||\n", canBo.getName(),canBo.getAge(),canBo.getSex(),canBo.getAddress());
        }
    }
    
    public void showListbeing(){
        show(list);
    }
    
    public void menu(){
    
        
        
//        b.add();
//        b.searchByName();
//        b.showListbeing();
        boolean isValid = false;
        do {        
            try {
                isValid = true;
                int selectF; 
                Scanner sc = new Scanner(System.in);
                System.out.println("----- MENU -----");
                System.out.println("1. Them can bo");
                System.out.println("2. Tim can bo");
                System.out.println("3. Hien thi danh sach can bo");
                System.out.println("4. Thoat");
                System.out.print("    Nhap lua chon cua ban: ");
                selectF = sc.nextInt();
                
                if(selectF == 1){
                    add();
                    isValid = false;
                } else if(selectF == 2){
                    searchByName();
                    isValid = false;
                    sc.nextLine();
                } else if(selectF == 3 ){
                    showListbeing();
                    isValid = false;
                } else {
                    break;
                }
                
                
            } catch (InputMismatchException e) {
            }
            
        } while (isValid == false);

          
    }
        
    
    
    
    
}

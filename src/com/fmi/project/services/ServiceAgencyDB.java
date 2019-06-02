package com.fmi.project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ServiceAgencyDB extends  ConnectionDB{
    private static ServiceAgencyDB ourInstance = new ServiceAgencyDB();

    private ServiceAgencyDB() {
    }

    public static ServiceAgencyDB getInstance() {
        return ourInstance;
    }

    public void insertAgencyDB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT number of bookings : ");
        String nob = br.readLine();
        System.out.println("INSERT company name : ");
        String comp = br.readLine();
        Boolean second;
        Integer first, fourth;
        String third, fifth;

        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = comp;

        try {
            Statement statement = ServiceAgencyDB.getInstance().getConnection().createStatement();
            statement.execute
                    ("insert into agency(, price_paid, first_time_customer, " +
                            "email_list_subscription, no_of_bookings, company_name) " +
                            "values ("+first+", '"+second+"', '"+third+"','"+fourth+"', '"+fifth+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAgencyDB(Integer pr, boolean ftc, String el, Integer nob, String cn) throws IOException {

        try {
            Statement statement = ServiceAgencyDB.getInstance().getConnection().createStatement();
            statement.execute("insert into agency(price_paid, first_time_customer, email_list_subscription, " +
                                "no_of_bookings, company_name)" +
                                "values ("+pr+", '"+ftc+"', '"+el+"', '"+nob+"', '"+cn+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readAgencyBD() throws SQLException {
        ResultSet resultSet = ServiceAgencyDB.getInstance().getStatement()
                .executeQuery(" select * from agency");


        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getInt(1)
                    + ", price paid=" + resultSet.getString(2)
                    + ", first time customer=" + resultSet.getString(3)
                    + ", email list subscription=" + resultSet.getString(4)
                    + ", no of bookings" + resultSet.getString(5)
                    + ", company name=" + resultSet.getString(6))
                    ;
        }
    }

    public void updateAgencyBDById(Integer id) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Id = ?");
//        String id = br.readLine();
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT number of bookings : ");
        String nob = br.readLine();
        System.out.println("INSERT company name : ");
        String comp = br.readLine();
        Integer id1;
        Boolean second;
        Integer first, fourth;
        String third, fifth;

       // id1 = Integer.parseInt(id);
        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = comp;

        String sql = "update agency set price_paid = ?, first_time_customer = ?, email_list_subscription = ?," +
                "no_of_bookings = ?, company_name = ?" +
                " where id="+id;
        try {
            PreparedStatement pst = ServiceAgencyDB.getInstance().getConnection().prepareStatement(sql);
            // parameter index marcheaza datele aflate dupa set
            //, nu coloanele din tabel
            pst.setInt(1, first);
            pst.setBoolean(2, second);
            pst.setString(3, third);
            pst.setInt(4,fourth);
            pst.setString(5, fifth);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAgencyBDByid(Integer id) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("DELETE agency client with id = ");
//        String id = br.readLine();
//        Integer id2 = Integer.parseInt(id);

        String sql = "delete from agency where id=?";
        try {
            PreparedStatement pst = ServiceAgencyDB.getInstance().getConnection().prepareStatement(sql);

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
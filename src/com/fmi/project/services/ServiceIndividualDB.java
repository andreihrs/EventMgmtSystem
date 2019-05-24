package com.fmi.project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ServiceIndividualDB extends  ConnectionDB{
    private static ServiceIndividualDB ourInstance = new ServiceIndividualDB();

    private ServiceIndividualDB() {
    }

    public static ServiceIndividualDB getInstance() {
        return ourInstance;
    }

    public void insertIndividualDB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT previous checkins : ");
        String nob = br.readLine();
        System.out.println("INSERT coupons used : ");
        String comp = br.readLine();
        System.out.println("INSERT rewards claimed : ");
        String rwd = br.readLine();
        Boolean second;
        Integer first, fourth, fifth, sixth;
        String third;

        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = Integer.parseInt(comp);
        sixth = Integer.parseInt(rwd);

        try {
            Statement statement = ServiceIndividualDB.getInstance().getConnection().createStatement();
            statement.execute
                    ("insert into individual(, price_paid, first_time_customer, " +
                            "email_list_subscription, previous_checkins, coupons_used, rewards_claimed) " +
                            "values ("+first+", '"+second+"', '"+third+"','"+fourth+"', '"+fifth+"', '"+sixth+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readIndividualBD() throws SQLException {
        ResultSet resultSet = ServiceIndividualDB.getInstance().getStatement()
                .executeQuery(" select * from individual");


        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getInt(1)
                    + ", price paid=" + resultSet.getString(2)
                    + ", first time customer=" + resultSet.getString(3)
                    + ", email list subscription=" + resultSet.getString(4)
                    + ", previous checkins" + resultSet.getString(5)
                    + ", coupons used=" + resultSet.getString(6)
                    + ", rewards claimed = " + resultSet.getString(7))
            ;
        }
    }

    public void updateIndividualBDById() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Id = ?");
        String id = br.readLine();
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT previous checkins : ");
        String nob = br.readLine();
        System.out.println("INSERT coupons used : ");
        String comp = br.readLine();
        System.out.println("INSERT rewards claimed : ");
        String rwd = br.readLine();
        Integer id1;
        Boolean second;
        Integer first, fourth, fifth, sixth;
        String third;

        id1 = Integer.parseInt(id);
        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = Integer.parseInt(comp);
        sixth = Integer.parseInt(rwd);

        String sql = "update individual set price_paid = ?, first_time_customer = ?, email_list_subscription = ?," +
                "no_of_bookings = ?, company_name = ?" +
                " where id="+id1;
        try {
            PreparedStatement pst = ServiceIndividualDB.getInstance().getConnection().prepareStatement(sql);
            // parameter index marcheaza datele aflate dupa set
            //, nu coloanele din tabel
            pst.setInt(1, first);
            pst.setBoolean(2, second);
            pst.setString(3, third);
            pst.setInt(4,fourth);
            pst.setInt(5, fifth);
            pst.setInt(6, sixth);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteIndividualBDByid() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("DELETE individual client with id = ");
        String id = br.readLine();
        Integer id2 = Integer.parseInt(id);

        String sql = "delete from individual where id=?";
        try {
            PreparedStatement pst = ServiceIndividualDB.getInstance().getConnection().prepareStatement(sql);

            pst.setInt(1, id2);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
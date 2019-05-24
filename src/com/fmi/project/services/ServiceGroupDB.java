package com.fmi.project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ServiceGroupDB extends  ConnectionDB{
    private static ServiceGroupDB ourInstance = new ServiceGroupDB();

    private ServiceGroupDB() {
    }

    public static ServiceGroupDB getInstance() {
        return ourInstance;
    }

    public void insertGroupDB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT number of people : ");
        String nob = br.readLine();
        System.out.println("INSERT elligible for reward : ");
        String rwd = br.readLine();
        Boolean second, fifth;
        Integer first, fourth;
        String third;

        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = Boolean.parseBoolean(rwd);

        try {
            Statement statement = ServiceGroupDB.getInstance().getConnection().createStatement();
            statement.execute
                    ("insert into proiectpao.group(, price_paid, first_time_customer, " +
                            "email_list_subscription, no_of_people, elligible_for_reward) " +
                            "values ("+first+", '"+second+"', '"+third+"','"+fourth+"', '"+fifth+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readGroupBD() throws SQLException {
        ResultSet resultSet = ServiceGroupDB.getInstance().getStatement()
                .executeQuery(" select * from proiectpao.group");


        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getInt(1)
                    + ", price paid=" + resultSet.getString(2)
                    + ", first time customer=" + resultSet.getString(3)
                    + ", email list subscription=" + resultSet.getString(4)
                    + ", no of people" + resultSet.getString(5)
                    + ", eligible for reward=" + resultSet.getString(6))
            ;
        }
    }

    public void updateGroupBDById() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Id = ?");
        String id = br.readLine();
        System.out.println("INSERT price paid : ");
        String price = br.readLine();
        System.out.println("INSERT if first time customer : ");
        String fc = br.readLine();
        System.out.println("INSERT email list subscriber : ");
        String el = br.readLine();
        System.out.println("INSERT number of people : ");
        String nob = br.readLine();
        System.out.println("INSERT eligibile for reward : ");
        String comp = br.readLine();
        Integer id1;
        Boolean second, fifth;
        Integer first, fourth;
        String third;

        id1 = Integer.parseInt(id);
        first = Integer.parseInt(price);
        third = el;
        second = Boolean.parseBoolean(fc);
        fourth = Integer.parseInt(nob);
        fifth = Boolean.parseBoolean(comp);

        String sql = "update proiectpao.group set price_paid = ?, first_time_customer = ?, email_list_subscription = ?," +
                "no_of_people = ?, elligible_for_reward = ?" +
                " where id="+id1;
        try {
            PreparedStatement pst = ServiceGroupDB.getInstance().getConnection().prepareStatement(sql);
            // parameter index marcheaza datele aflate dupa set
            //, nu coloanele din tabel
            pst.setInt(1, first);
            pst.setBoolean(2, second);
            pst.setString(3, third);
            pst.setInt(4,fourth);
            pst.setBoolean(5, fifth);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteGroupBDByid() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("DELETE proiectpao.group client with id = ");
        String id = br.readLine();
        Integer id2 = Integer.parseInt(id);

        String sql = "delete from proiectpao.group where id=?";
        try {
            PreparedStatement pst = ServiceGroupDB.getInstance().getConnection().prepareStatement(sql);

            pst.setInt(1, id2);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
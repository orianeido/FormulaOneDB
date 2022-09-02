package com.example.formulaone.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnect {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/formulaone";

    private static DBConnect dbConnection = null;

    private DBConnect() {
        connect();
    }

    public static DBConnect getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnect();
        }
        return dbConnection;
    }


    public void getInfo() {

    }

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "Oriane3184$");
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void disconnect() {

    }

    public static ObservableList<Driver> getDriversData() {
        Connection conn = connect();
        ObservableList<Driver> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM drivers d JOIN country c " +
                    "ON d.CountryID = c.CountryID");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Driver(rs.getString("DriverName"), rs.getString("Country"), Integer.parseInt(rs.getString("RaceEntries")),
                        Integer.parseInt(rs.getString("RaceStarts")), Integer.parseInt(rs.getString("PolePositions")), Integer.parseInt(rs.getString("RaceWins")),
                        Integer.parseInt(rs.getString("Podiums")), Integer.parseInt(rs.getString("FastestLaps")), Double.parseDouble(rs.getString("Points"))));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static Driver getDriverData(String text) {
        Connection conn = connect();
        Driver driver = null;
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM drivers d JOIN country c " +
                    "ON d.CountryID = c.CountryID " +
                    "WHERE d.DriverName = " + text);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                driver = new Driver(rs.getString("DriverName"), rs.getString("Country"), Integer.parseInt(rs.getString("RaceEntries")),
                        Integer.parseInt(rs.getString("RaceStarts")), Integer.parseInt(rs.getString("PolePositions")), Integer.parseInt(rs.getString("RaceWins")),
                        Integer.parseInt(rs.getString("Podiums")), Integer.parseInt(rs.getString("FastestLaps")), Double.parseDouble(rs.getString("Points")));
            }
        } catch (Exception ignored) {
        }
        return driver;
    }

    public static ObservableList<Season> getDriverSeasonsData(String text) {
        Connection conn = connect();
        ObservableList<Season> list = FXCollections.observableArrayList();
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT s.season, ds.points FROM driversstandings ds JOIN seasons s " +
                    "ON s.SeasonRefID = ds.seasonID " +
                    "WHERE ds.DriverID = (SELECT DriverID FROM drivers " +
                    "WHERE DriverName = " + text + ")");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Season(rs.getString("Season"), Double.parseDouble(rs.getString("Points"))));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static int deleteDriver(String text) {
        Connection conn = connect();
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("DELETE FROM drivers WHERE DriverName = " + text);
            ps.executeUpdate();
            return 1;
        } catch (Exception ignored) {
        }
        return 0;
    }

    public static int addDriver(String query, String name, String country, int raceEntries, int raceStarts, int pole, int win, int podiums, int points, int fl) {

        int countryID = getCountryID(country);
        int driverID = getMaxDriverID();
        Connection conn = connect();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, driverID);
            ps.setInt(3, countryID);
            ps.setInt(4, raceEntries);
            ps.setInt(5, raceStarts);
            ps.setInt(6, pole);
            ps.setInt(7, win);
            ps.setInt(8, podiums);
            ps.setInt(9, fl);
            ps.setInt(10, points);
            ps.executeUpdate();
            return 1;
        } catch (Exception ignored) {
        }
        return 0;
    }

    public static ObservableList<Constructor> getConstructorsData() {
        Connection conn = connect();
        ObservableList<Constructor> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM constructors c1 JOIN country c2 " +
                    "ON c1.CountryID = c2.CountryID");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Constructor(rs.getString("Constructor"), rs.getString("Country"), Integer.parseInt(rs.getString("RacesEntered")),
                        Integer.parseInt(rs.getString("RacesStarted")), Integer.parseInt(rs.getString("Drivers")), Integer.parseInt(rs.getString("TotalEntries")),
                        Integer.parseInt(rs.getString("Wins")), Integer.parseInt(rs.getString("Points")), Integer.parseInt(rs.getString("Poles")),
                        Integer.parseInt(rs.getString("FL")), Integer.parseInt(rs.getString("Podiums")), Integer.parseInt(rs.getString("WCC")), Integer.parseInt(rs.getString("WDC"))));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static Constructor getConstructorData(String text) {
        Connection conn = connect();
        Constructor constructor = null;
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM constructors c1 JOIN country c2 " +
                    "ON c1.CountryID = c2.CountryID " +
                    "WHERE c1.Constructor = " + text);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                constructor = new Constructor(rs.getString("Constructor"), rs.getString("Country"), Integer.parseInt(rs.getString("RacesEntered")),
                        Integer.parseInt(rs.getString("RacesStarted")), Integer.parseInt(rs.getString("Drivers")), Integer.parseInt(rs.getString("TotalEntries")),
                        Integer.parseInt(rs.getString("Wins")), Integer.parseInt(rs.getString("Points")), Integer.parseInt(rs.getString("Poles")),
                        Integer.parseInt(rs.getString("FL")), Integer.parseInt(rs.getString("Podiums")), Integer.parseInt(rs.getString("WCC")), Integer.parseInt(rs.getString("WDC")));
            }
        } catch (Exception ignored) {
        }
        return constructor;
    }

    public static ObservableList<Season> getConstructorSeasonsData(String text) {
        Connection conn = connect();
        ObservableList<Season> list = FXCollections.observableArrayList();
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT s.season, cs.points FROM constructorstandings cs JOIN seasons s " +
                    "ON s.SeasonRefID = cs.seasonID " +
                    "WHERE cs.ConstructorID = (SELECT ConstructorID FROM constructors " +
                    "WHERE Constructor = " + text + ")");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Season(rs.getString("Season"), Double.parseDouble(rs.getString("Points"))));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static int deleteConstructor(String text) {
        Connection conn = connect();
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("DELETE FROM constructors WHERE Constructor = " + text);
            ResultSet rs = ps.executeQuery();
            return 1;
        } catch (Exception ignored) {
        }
        return 0;
    }

    public static ObservableList<GrandPrix> getGrandPrixsData() {
        Connection conn = connect();
        ObservableList<GrandPrix> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circuits c JOIN circuittype ct " +
                    "ON c.TypeRefID = ct.TypeRefID JOIN circuitdirections cd " +
                    "ON c.DirectionRefID = cd.DirectionRefID");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new GrandPrix(rs.getString("GrandPrix"), rs.getString("Circuit"), rs.getString("CircuitType"),
                        rs.getString("Direction"), Double.parseDouble(rs.getString("LastLengthUsed")), Integer.parseInt(rs.getString("GrandPrixHeld"))));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static GrandPrix getGrandPrixData(String text) {
        Connection conn = connect();
        GrandPrix grandPrix = null;
        text = "'%" + text + "%'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circuits c JOIN circuittype ct " +
                    "ON c.TypeRefID = ct.TypeRefID JOIN circuitdirections cd " +
                    "ON c.DirectionRefID = cd.DirectionRefID JOIN circuitimages ci " +
                    "ON ci.CircuitID = c.CircuitID" +
                    "WHERE c.Circuit LIKE (" + text + ")");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                grandPrix = new GrandPrix(rs.getString("GrandPrix"), rs.getString("Circuit"), rs.getString("CircuitType"),
                        rs.getString("Direction"), Double.parseDouble(rs.getString("LastLengthUsed")), Integer.parseInt(rs.getString("GrandPrixHeld")),
                        rs.getString("ImageURL"));
            }
        } catch (Exception ignored) {
        }
        return grandPrix;
    }

    public static int deleteGrandPrix(String text) {
        Connection conn = connect();
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("DELETE FROM circuits WHERE Circuit LIKE (" + text + ")");
            ResultSet rs = ps.executeQuery();
            return 1;
        } catch (Exception ignored) {
        }
        return 0;
    }

    private static int getCountryID(String text) {
        Connection conn = connect();
        int countryID = 0;
        text = "'" + text + "'";
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT c.CountryID FROM country c " +
                    "WHERE c.Country = " + text);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                countryID = rs.getInt("CountryID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryID;
    }
    private static int getMaxDriverID() {
        Connection conn = connect();
        int driverID = 0;
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(d.DriverID) FROM drivers d");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                driverID = rs.getInt("MAX(d.DriverID)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        driverID = driverID + 1;
        return driverID;
    }
}

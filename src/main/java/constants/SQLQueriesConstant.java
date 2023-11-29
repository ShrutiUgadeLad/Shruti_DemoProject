package constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.DatabaseConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class SQLQueriesConstant {
    private static final Logger LOGGER = LogManager.getLogger(SQLQueriesConstant.class);

    public static final String query1 = "";

    public static final String query2 = "";



    public static boolean getDataFromTable(String query) {
        LOGGER.info(" Query to be executed is "+ query);
        try {
            DatabaseConnect.initializeImsConnection();
            PreparedStatement prepStmt = DatabaseConnect.getPreparedStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            boolean val = rs.next();
            return val;
        }
        catch (SQLException e) {
            LOGGER.error(e.getMessage());
            fail("Error executing sql query" + query);
        }
        finally {
            DatabaseConnect.closeDBConnection();
        }
        return false;
    }

    public static List<String> getRawColumnListFromTable(String query, String columnName) {
        LOGGER.info(" Query to be executed is "+ query);
        List<String> list = new ArrayList<String>();
        try {
            DatabaseConnect.initializeImsConnection();
            PreparedStatement prepStmt = DatabaseConnect.getPreparedStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(columnName));
            }
        }
        catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        finally {
            DatabaseConnect.closeDBConnection();
        }
        return list;
    }
}
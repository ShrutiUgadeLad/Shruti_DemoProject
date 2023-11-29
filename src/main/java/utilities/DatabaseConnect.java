package utilities;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnect
{
    private static final String SYBASE_DATABASE_DRIVER = "com.sybase.jdbc4.jdbc.SybDriver";
    static Statement statement;
    private static final String SQL_DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static Connection connection;
    private static final Logger LOGGER = LogManager.getLogger(DatabaseConnect.class);

    private static String getDatabaseDriver() {
        String databaseType = ConfigFileReader.getPropertyValue("databaseType");
        return databaseType.equalsIgnoreCase("sql") ? SQL_DATABASE_DRIVER : SYBASE_DATABASE_DRIVER;
    }

    private static String getDatabaseHost() {
        return ConfigFileReader.getPropertyValue("databaseHost");
    }

    private static String getDatabaseName() {
        return ConfigFileReader.getPropertyValue("databaseName");
    }

    private static String getDatabaseConnectionString() {
        return ConfigFileReader.getPropertyValue("databaseType").equalsIgnoreCase("sql")
                ? "jdbc:sqlserver://"+getDatabaseHost()+":1433;databaseName="+getDatabaseName()
                : "jdbc:sybase:Tds:" + getDatabaseHost() + ":20000/" + getDatabaseName();
    }

    private static void initializeDatabaseConnection(String username, String password) {
        String dbDriver = getDatabaseDriver();
        try {
            if (connection == null) {
                Class.forName(dbDriver).getDeclaredConstructor().newInstance();
                String dbUrl = getDatabaseConnectionString();
                String databaseUsername = ConfigFileReader.getPropertyValue(username);
                String databasePassword = ConfigFileReader.getPropertyValue(password);
                connection = DriverManager.getConnection(dbUrl, databaseUsername, databasePassword);
            }
        }
        catch (InstantiationException | IllegalAccessException
               | ClassNotFoundException | SQLException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error(e.getMessage());
            fail("Error getting SQL DB connection");
        }
    }


    public static void initializeImsConnection() {
        initializeDatabaseConnection("imsUsername", "imsPassword");
    }

    public static Connection getDbConnection() {
        if (connection == null) {
            initializeDatabaseConnection("imsUsername", "imsPassword");
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String query) {
        PreparedStatement prepStmt = null;
        DatabaseConnect.initializeImsConnection();
        try {
            prepStmt = connection.prepareStatement(query);
        }
        catch (SQLException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            fail("Error creating prepared statement");
        }
        assertNotNull("Prepared statement is null", prepStmt);
        return prepStmt;
    }

    public static void closeDBConnection() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }
        }
        catch (SQLException e) {
            LOGGER.info(e.getMessage());
            fail("Error closing DB connection");
        }
    }
}

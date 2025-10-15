package DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public void createConnection(String urlService) {
        try {
            Properties properties = loadProperties();
            String url = properties.getProperty("url") + urlService;
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(String urlService) {
        try {
            if (connection == null || connection.isClosed()) {
                createConnection(urlService);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при подключении к БД", e);
        }
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream("jdbc_connect_properties.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл Properties не найден в classpath");
            }
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки файла properties", e);
        }
    }
}

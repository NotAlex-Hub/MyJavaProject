package DBUtils.getDataFromDB;

import DBUtils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class GetDataFromDBPetService {
    private static final String URL_PET_DB = "petsUrlDB";

    public HashMap<String, Object> getDataFromPet(int petId) {
        HashMap<String, Object> petData = new HashMap<>();
        try (Connection connection = DBConnection.getInstance().getConnection(URL_PET_DB);
             PreparedStatement petDetailsQuery = connection.prepareStatement(
                     "SELECT id, category, name, photoUrls, tags, status" +
                             " FROM Pet WHERE ?"
             )) {
            petDetailsQuery.setInt(1, petId);

            try (ResultSet resultSetPet = petDetailsQuery.executeQuery()) {
                if (resultSetPet.next()) {
                    petData.put("id", resultSetPet.getInt("id"));
                    petData.put("category", resultSetPet.getObject("category"));
                    petData.put("name", resultSetPet.getString("name"));
                    petData.put("photoUrls", resultSetPet.getArray("photoUrls"));
                    petData.put("tags", resultSetPet.getArray("tags"));
                    petData.put("status", resultSetPet.getString("status"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petData;
    }
}

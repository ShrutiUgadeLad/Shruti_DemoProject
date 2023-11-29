package utilities;

import com.google.gson.Gson;
import dataModel.LoginDataModel;

import java.io.FileReader;
import java.util.Arrays;

public class JsonReader {
    public LoginDataModel getDataForSwagLabs(String userType) {

        try {
            return Arrays
                    .asList(new Gson().fromJson(new FileReader(
                                    System.getProperty("user.dir")
                                            + "/src/test/resources/testdata/algorithm.json"),
                            LoginDataModel[].class))
                    .stream().filter(userData -> userData.getUserType().equals(userType)).findFirst().get();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
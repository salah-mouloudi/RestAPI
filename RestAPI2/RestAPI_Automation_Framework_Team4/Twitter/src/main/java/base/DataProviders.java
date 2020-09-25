package base;

import databases.ConnectToSqlDB;
import io.restassured.response.ValidatableResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DataReaderTeam4;

import java.io.IOException;
import java.util.ArrayList;

public class DataProviders extends ConnectToSqlDB {
    @DataProvider(name = "Twitter usernames")
    public static Object[][] readSQL() throws Exception {
        ArrayList<String> lst = (ArrayList<String>) readDataBase("Twitter", "usernames");
        return lst.stream()
                .map(student -> new Object[] { student })
                .toArray(Object[][]::new);
}

}

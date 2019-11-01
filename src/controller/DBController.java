package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBController {

    //Creates a new DB
    public void createNewDB(String DBName) throws IOException {
        File myFile = new File(DBName + ".dat");
        myFile.createNewFile();
    }

    //Gets the data from the DB
    public List readDB(String DBName) {
        List list = new ArrayList();
        list = SerializeDB.readSerializedObject(DBName + ".dat");
        return list;
    }

    //Updates the data with a given list
    public void updateDataDB(List list, String DBName) {
        SerializeDB.writeSerializedObject(DBName + ".dat", list);
    }
}




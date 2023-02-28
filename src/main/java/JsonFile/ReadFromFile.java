package JsonFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class ReadFromFile {
    public String readFile(String attribute) throws IOException{
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+"/readData/Read.json");
        Object obj = jsonParser.parse(reader);
        JsonObject jsonObject = (JsonObject) obj;
        String value = jsonObject.get(attribute).getAsString();
        return value;
    }

}

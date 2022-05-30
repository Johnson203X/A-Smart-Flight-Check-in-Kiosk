package ebu.groupone.iteration.BackEnd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class of handling the IO of JSON format Data, the middle level
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class JsonIO {

    /**
     * Reading from storage file by calling FileIO Methods with returning input String
     * @param filePath The location while file should be read from
     * @param fileClass The fileClass for JSON ParseObject to initialize
     * @return ArrayList
     */
    public ArrayList<Object> ReadIn(String filePath, Class fileClass) {
        ArrayList<Object> array = new ArrayList<Object>();
        try {
            String buffer = FileIO.read(filePath);
            JSONArray jsonArray = JSON.parseArray(buffer);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String jsonString = jsonObject.toJSONString();
                Object fileObject = JSON.parseObject(jsonString, fileClass);
                array.add(fileObject);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Writing to storage file by calling FileIO Methods with output arraylist
     * @param filePath The location while file should be written to
     * @param array Output data in the format of arraylist
     */
    public void WriteOut(String filePath, ArrayList<Object> array) {
        JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(array));
        String output = JSON.toJSONString(jsonArray);
        try {
            FileIO.write(filePath, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

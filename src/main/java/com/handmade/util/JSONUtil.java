package com.handmade.util;

/**
 * Created by Matt on 2/6/18.
 */


        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.StringReader;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.Set;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.google.gson.JsonElement;
        import com.google.gson.JsonObject;
        import com.google.gson.JsonParser;
        import com.google.gson.internal.bind.SqlDateTypeAdapter;

public class JSONUtil
{

    JsonParser parser =null;


    public JSONUtil() {
        parser = new JsonParser();
    }
    /* This method returns all the keys at the root level
     * @param - Input JSON File name
     * @Output - Array list of Keys at the root level
     */
    public ArrayList<String> getKeysAtRootLevel(String JSONFile){
        ArrayList<String> keys=new ArrayList<String>();
        try {
            JsonObject jsonObject = (JsonObject)parser.parse(new FileReader(new File(JSONFile)));
            keys = getKeys(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return keys;
    }

    /* This method returns all the keys at a given Element level
     * @param - Input JSON File name
     * @param - Path - Path of the element. eg. Root.Elem1.Elem2
     * @Output - Array list of Keys at the Element level
     */
    public ArrayList<String> getKeys(String JSONFile,String path){
        ArrayList<String> keys=new ArrayList<String>();
        try {
            JsonObject jsonObject = (JsonObject)parser.parse(new FileReader(new File(JSONFile)));
            String[] seg = path.split("\\.");
            for (String element : seg) {
                if (jsonObject != null) {
                    JsonElement jsonElement = jsonObject.get(element);
                    if (jsonElement!=null && jsonElement.isJsonObject())
                        jsonObject = jsonElement.getAsJsonObject();
                }
            }
            if(jsonObject!=null)
                keys = getKeys(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keys;
    }

    private ArrayList<String> getKeys(JsonObject jsonObject){
        ArrayList<String> keys=new ArrayList<String>();

        Set<Entry<String,JsonElement>> entrySet = jsonObject.entrySet();
        Iterator<Entry<String, JsonElement>> entriesIterator = entrySet.iterator();
        while(entriesIterator.hasNext())
        {
            Entry<String, JsonElement> entry = entriesIterator.next();
            keys.add(entry.getKey());
        }

        return keys;
    }

    // JSON to Java Object Conversion method.
    public static String getJSONFromJavaObject(Object obj){
        try {
            String strJSON = new Gson().toJson(obj);
            return strJSON;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    // JSON to Java Object Conversion method.
    public static Object getJavaObjectFromJSON(InputStream jsonFileInputStream,String className){
        try {
            if(jsonFileInputStream!=null){
                Object obj = new Gson().fromJson( new InputStreamReader(jsonFileInputStream), Class.forName(className));
                return obj;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // JSON to Java Object Conversion method.
    public static Object getJavaObjectFromJSON(String JSONFile,String className){
        FileReader jsonReader = null;
        try {
            File jsonFile=new File(JSONFile);
            if(jsonFile.exists()){
                jsonReader = new FileReader(jsonFile);
                Object obj = new Gson().fromJson( jsonReader, Class.forName(className));

                jsonReader.close();
                return obj;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(jsonReader!=null)
                    jsonReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // JSON to Java Object Conversion method.
    public static Object getJavaObjectFromJSONString(String JSONStr,String className){
        try {
            if(JSONStr.length()>0){
                Object obj = new Gson().fromJson( new StringReader(JSONStr), Class.forName(className));
                return obj;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // JSON to Java Object Conversion method With Date Format
    public static Object getJavaObjectFromJSONWithISODateFormat(String JSONStr,String className){
        try {
            if(JSONStr.length()>0){
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
                        .create();
                Object obj = gson.fromJson( new StringReader(JSONStr), Class.forName(className));
                return obj;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    // JSON to Java Object Conversion method.
    public static Object getJavaObjectFromJSONStringSQLTypes(String JSONStr,String className){

        try {
            File jsonFile=new File(JSONStr);
            if(jsonFile.exists()){

                SqlDateTypeAdapter sqlAdapter = new SqlDateTypeAdapter();
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(java.util.Date.class, sqlAdapter )
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Object obj = new Gson().fromJson( new FileReader(jsonFile), Class.forName(className));
                return obj;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // Function to return as raw json object
    public static JsonObject getRawJSONObect(String JSONFile) {
        FileReader jsonReader = null;
        try {
            File jsonFile=new File(JSONFile);
            if(jsonFile.exists()){
                jsonReader = new FileReader(jsonFile);
                JsonObject jsonObject = (JsonObject) new Gson().fromJson( jsonReader, JsonElement.class);

                jsonReader.close();
                return jsonObject;
            }else
                return null;
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(jsonReader!=null)
                    jsonReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getJSONStringFromMap(Map<?,?> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    public static String getJSONStringFromObject(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }


    public static void main(String[] args){

        JSONUtil util=new JSONUtil();
        String test = "c:\\data\\test.json";


        //SpecCategoriesContainer s = (SpecCategoriesContainer)util.getJavaObjectFromJSON("conf"+File.separator+"SpecCategories.json", SpecCategoriesContainer.class.getName());
        //PrologMappingsContainer s = (PrologMappingsContainer)util.getJavaObjectFromJSON("conf"+File.separator+"PrologMappings.json", PrologMappingsContainer.class.getName());
        //	SubmittalHeadingsContainer s = (SubmittalHeadingsContainer)util.getJavaObjectFromJSON("conf"+File.separator+"Submittals.json", SubmittalHeadingsContainer.class.getName());
        //  ArrayList<SubmittalHeading> list = ( ArrayList<SubmittalHeading>)s.getSubmittalHeadings();
        ////System.out.println(list.get(0));
        // util.getValue("conf"+File.separator+"SpecCategoriesDesc.json","spec_categories.name.searchKeys");
    }
}



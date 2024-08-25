package Base;


import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;

import java.io.FileReader;
import java.io.IOException;

public class ConfigData {
    public static String URL = "http://localhost/ibook/?mod=users&action=login";


    public static TestObject[] readTestObjectsFromJson(String filepath) {
        try {
            //Read file JSON
            FileReader reader = new FileReader(filepath);
            //Parse JSON string
            Gson gson = new Gson();
            TypeToken<TestObject[]> token = new TypeToken<TestObject[]>() {};
            TestObject[] testObjects = gson.fromJson(reader, token.getType());
            reader.close();
            return testObjects;
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return new TestObject[0];
        }
    }

    public static class TestObject {
        public String username,password,confirmPassword,accountId,phone,fullName,birthDate,email,passport,group,address,idUnitType,parentId,groupId;
        public String position;
        public String users;
        public String title;
        public String code;
        public String content;
        public String contentReport,contentFeedback;
        public String objectTypes;
        public String objectType;
        public String contentNote;
        public String description;
        public int totalTurn;
        public String question,choice1;
        public String codeNumber;
        public String documentTypeId,organizationId;
        public String groupIds,typeSurvey,surveyId;
        public String roles, accountGroupComponent;
        public String documentType;
        public String timelineType;
        public String examinationType;
        public String groupType;
        public String hosting;
        public String categories, brief, otherFiles, newsRelated, seoTitle, seoKeywords, seoDescription, rewriteURL;
        public String videoLink;
        public String sortOrder, expiredTime, author, pseudonym, source, tag;
        public int durationMin;
        public String site;
        public String message;
        public String radioValue, checkboxValue;
        public CharSequence seoKeyword;
    }
}

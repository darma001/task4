import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import java.io.File;
import java.io.IOException;

public class RecommendationEngine {
    public static void main(String[] args) {
        try {
            File file = new File("user_ratings.csv");
            DataModel model = new FileDataModel(file);
            
            // Check if data model was successfully loaded
            System.out.println("Data model loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

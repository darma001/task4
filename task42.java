import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.UserSimilarity;
import org.apache.mahout.cf.taste.model.UserNeighborhood;

import java.util.List;

public class RecommendationEngine {
    public static void main(String[] args) {
        try {
            // Load data model
            File file = new File("user_ratings.csv");
            DataModel model = new FileDataModel(file);

            // Create similarity measure (Pearson Correlation)
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Create user neighborhood (N nearest neighbors)
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);

            // Create recommender
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Recommend items for user with ID 1
            List<RecommendedItem> recommendations = recommender.recommend(1, 2); // 2 items recommended for user 1

            // Print recommended items
            for (RecommendedItem recommendation : recommendations) {
                System.out.println("Recommended Item ID: " + recommendation.getItemID() + " with Value: " + recommendation.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

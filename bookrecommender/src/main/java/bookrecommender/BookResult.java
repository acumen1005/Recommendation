package bookrecommender;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class BookResult {

	final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;
    final static String SERVICE_NAME = "localhost";
    final static String DATABASE_NAME = "br";
    final static String DATABASE_TABLE_NAME = "reader";
    final static String DATABASE_USER = "root";
    final static String DATABASE_PWD = "67313688";
    
    public static void runBookResult(String filePath) throws TasteException, IOException, SQLException {
//    	String file = "douban-rating-300.txt";
    	String file = filePath;
        DataModel dataModel = RecommendFactory.buildDataModel(file);
//    	DataModel dataModel = RecommendFactory.buildDataModelFromDatabase(SERVICE_NAME, DATABASE_NAME, DATABASE_PWD, DATABASE_TABLE_NAME);
        RecommenderBuilder rb1 = BookEvaluator.userEuclidean(dataModel);
        RecommenderBuilder rb2 = BookEvaluator.itemEuclidean(dataModel);
        RecommenderBuilder rb3 = BookEvaluator.userEuclideanNoPref(dataModel);
        RecommenderBuilder rb4 = BookEvaluator.itemEuclideanNoPref(dataModel);
        
        RecommendFactory.connectDatabase();
        RecommendFactory.deleteAllrecords();
        
        LongPrimitiveIterator iter = dataModel.getUserIDs();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            System.out.print("userEuclidean       =>");
            result(uid, rb1, dataModel,0);
            System.out.print("itemEuclidean       =>");
            result(uid, rb2, dataModel,1);
            System.out.print("userEuclideanNoPref =>");
            result(uid, rb3, dataModel,2);
            System.out.print("itemEuclideanNoPref =>");
            result(uid, rb4, dataModel,3);
        }
    }

    public static void result(long uid, RecommenderBuilder recommenderBuilder, DataModel dataModel,int type) throws TasteException, SQLException {
        List<RecommendedItem> list = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
        RecommendFactory.showItemsWithSQL(uid, list, false,type);
    }
    
    public static void main(String[] args) throws TasteException, IOException, SQLException {
//        String file = "datafile/book/rating.csv";
    	
    	runBookResult("douban-rating-300.txt");
    }

   
}

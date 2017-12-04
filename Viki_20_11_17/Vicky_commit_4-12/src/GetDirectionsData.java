import android.os.AsyncTask;
/**
 *
 * @author vicky
 */
public class GetDirectionsData extends AsyncTask<Object,String,String>{
    
    GoogleMap mMap;
    String url;
    String googleDirectionsData;
    
    @Override
    protected String doInBackground(Object ... objects)
    {
        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];
        
        DownloadUrl downloadUrl = new DownloadUrl();
        try{
            googleDirectionData = downloadUrl.readUrl(url);
        }catch(IOException e){
            e.printStackTrace();
        }
        return googleDirectionData;
    }
    @Override
    protected void onPostExecute(String s){
        HashMap<String,String> directionsList = null;
        DataParser parser = new DataParser();
        directionsList = parser.parseDirections(s);  
        
              
    }
    
    
    
}

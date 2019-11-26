import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Example1
{
    public static final String API_ENDPOINT = "https://app.zenter.ng/Api/V2ea1";

    public static void main(String[] args) {
        try {
            HttpClient   httpClient    = HttpClientBuilder.create().build();
            HttpPost     post          = new HttpPost(API_ENDPOINT);
            StringEntity postingString = new StringEntity("{\"query\":\"query{  version}\"}");
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse  response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println("Response: "+ responseString);
        }catch (Exception ex){
        }
    }
}

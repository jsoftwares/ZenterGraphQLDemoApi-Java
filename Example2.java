

public class Example2
{
    public static final String API_ENDPOINT = "https://app.zenter.ng/Api/V2ea1";

    public static final String API_USER = "484_test@useTestCredential.com";
    public static final String API_PASSPHRASE = "a774b3a81c25ca5d80d0ecdcContactUs";


    public static void main(String[] args) {
        GraphqlClient client = new GraphqlClient(API_ENDPOINT);
        String token = client.GetLoginToken(API_USER, API_PASSPHRASE);

        client.changeUrl(API_ENDPOINT+"?token="+token);

        if (!client.IsLoggedIn())
        {
            System.out.println("Was not able to log in!");
            System.exit(1);
        }

        int TemplateId = 20;
        Job job = client.CreateEmailJob("Test","My subject", TemplateId);

        System.out.println(job.id);
        System.out.println("Success!");
    }
}

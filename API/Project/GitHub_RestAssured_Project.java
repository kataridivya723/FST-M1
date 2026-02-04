package Activities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;
 
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class GitHub_RestAssured_Project {
 
    RequestSpecification requestSpec;
    int sshId;
    String accessToken = "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";
 
 
    @BeforeClass
    public void setUp() {
 
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + accessToken)
                .addHeader("Accept", "application/vnd.github+json")
                .build();
    }
    @Test(priority = 1)
    public void addSSHKey() {
 
        String payload = """
            {
              "title" : "TestAPIKeyy",
              "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICzPdtNgoegIUaNcLekgqlx6KM8DOkN9xwxDty6surUY azuread\\\\kataridivya@DESKTOP-1KMTGOT"
              		+ ""
            }
            """; 
        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys")
                    .body(payload)
                .when()
                    .post();
 
        Assert.assertEquals(response.statusCode(), 201);
 
        sshId = response.jsonPath().getInt("id");
        System.out.println("Created SSH Key ID: " + sshId);
    }
 
    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {
 
        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys/{keyId}")
                    .pathParam("keyId", sshId)
                .when()
                    .get();
 
        Reporter.log(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
    }
 
    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {
 
        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys/{keyId}")
                    .pathParam("keyId", sshId)
                .when()
                    .delete();
 
        Assert.assertEquals(response.statusCode(), 204);
        System.out.println("SSH Key deleted successfully");
    }
}
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    //set up global variables
    //1.headers
    Map<String, String> headers = new HashMap<>();
    //2.resource path
    String path = "/api/users";

    /**
     *  POST request - host : https://localhost:8585/api/users
     * {
     *     "id": 23,
     *     "firstName": "asha",
     *     "lastName": "thomas",
     *     "email": "asha@example.com"
     * }
     *
     * respone :
     *  status code of 201
     *  {
     *         "id": 23,
     *        "firstName": "asha",
     *         "lastName": "thomas",
     *           "email": "asha@example.com"
     *
     *  }
     *
     */

    //Make the contract
    @Pact(consumer = "testUserConsumer", provider = "testUserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        //builder : builds the contract file from the perspective of the provider
        //Dsl : domain specific language

        //set the header
        headers.put("Content-Type", "application/json");

        //set the request and response body
        //here this api the req and resp is having same body
        //class which builds the json body for the interactions.
        //property name and property datatype needs to be defined
        DslPart requestResponseBody = new PactDslJsonBody().
                numberType("id", 1242).
                stringType("firstName", "asha").
                stringType("lastName", "thomas").
                stringType("email", "asha@example.com");



            //in pact the interaction betewen the consumer and provider is the 1 fragment
            //multiple pact annotation functions can be created in this file and each pact annotation is 1 interaction which is 1 fragmant
        //fragment is given
        //creating user request --> is 1 state
        return builder.given("creating user request").
                        uponReceiving("upon receiving  the request for creating the user").
                        method("POST").
                        headers(headers).
                        path(path).
                        body(requestResponseBody).
                willRespondWith().
                //actual server respond with 201 and a body with id, firstname, lastname and email
                        status(201).
                        body(requestResponseBody).
                toPact();
    }

    //Test with provider mock
    //contract test is a junit test --> important
    //give a new port other than 8585
    //the annotation @PactTestFor makes the mock server
    @Test
    @PactTestFor(providerName = "testUserProvider", port = "8282")
    public void consumerTest() {

        //Request body
        Map<String, Object> reqTest = new HashMap<>();
        reqTest.put("id", 1242);
        reqTest.put("firstName", "asha");
        reqTest.put("lastName", "thomas");
        reqTest.put("email", "asha@example.com");

        //send the post request
        given().
                baseUri("http://localhost:8282").
                headers(headers).
                body(reqTest).
        when().
                post(path).
        then().
                statusCode(201);

    }


}

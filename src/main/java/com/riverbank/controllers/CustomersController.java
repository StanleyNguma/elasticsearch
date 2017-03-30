package com.riverbank.controllers;

/**
 * <p>
 * Created by @StanleyNguma on 29-Mar-17.
 */
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riverbank.data.Customers;
import com.riverbank.services.CustomersRepository;

import java.io.IOException;
import java.net.InetAddress;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/users") // This means URL's start with /api (after Application path)
public class CustomersController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CustomersRepository customersRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Customers customers = new Customers();
        customers.setFirstName(name);
        customers.setEmail(email);
        customersRepository.save( customers );
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody String getAllCustomers() throws IOException {
        // This returns a JSON or XML with the users

        try{
            // initialize the elastic search
            Client client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

            Iterable<Customers> customers_data = customersRepository.findAll();

            for(Customers customers: customers_data){

                XContentBuilder builder = jsonBuilder()
                        .startObject()
                        .field("firstName", customers.getFirstName())
                        .field("middleName", customers.getMiddleName())
                        .field("lastName", customers.getLastName())
                        .field("email", customers.getEmail())
                        .field("phone", customers.getPhone())
                        .field("idNumber", customers.getIdnumber())
                        .field("username", customers.getUsername())
                        .field("password", customers.getPassword())
                        .field("status", customers.getStatus())
                        .field("countyID", customers.getCountyID())
                        .endObject();

                // convert the builder into json
                //  String json = builder.string();

                IndexResponse response = client.prepareIndex("customer_data", "customer", Integer.toString( customers.getId() ))
                        .setSource( builder )
                        .get();


            }
            // close the elastic search client
            client.close();

        }
        catch ( Exception ex){

            ex.printStackTrace();
        }
        return "processed all";
    }
}
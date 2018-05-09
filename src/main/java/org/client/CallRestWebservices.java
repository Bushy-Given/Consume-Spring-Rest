package org.client;

import org.consume.rest.org.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestWebservices implements CommandLineRunner{

    private static  void getPerson(){
        String getURL = "http://localhost:8080/api/person/1";
        RestTemplate restTemplate = new RestTemplate();
        Person persons = restTemplate.getForObject(getURL,Person.class);

        System.out.println("The person of id="+ persons.getId()+" is :" + persons.getFirstName());
    }
    private  static void postPerson(){
        String postURL = "http://localhost:8080/api/person";

        RestTemplate restTemplate = new RestTemplate();

        Person createPerson =new Person("Tommy","Netsh");
        ResponseEntity<Person> postResponse = restTemplate.postForEntity(postURL,createPerson,Person.class);

        System.out.println("Response for Post Request :" + postResponse.getBody());
    }

    private static void putPerson(){
        String putURL = "http://localhost:8080/api/person/1";

        RestTemplate restTemplate = new RestTemplate();

        Person putPerson = new Person();
        putPerson.setId(1L);
        putPerson.setFirstName("Bushy");
        putPerson.setLastName("Netshidaulu");
        restTemplate.put(putURL,putPerson);
    }

    private static void deletePerson(){
        String deleteURL = "http://localhost:8080/api/person/3";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(deleteURL);
    }
    @Override
    public void run(String... args) throws Exception {
        //getPerson();
       postPerson();
        //putPerson();
        //deletePerson();
    }
}

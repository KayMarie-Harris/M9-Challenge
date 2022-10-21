package com.company.customerapi.repository;

import com.company.customerapi.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest
{
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception
    {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldCreateNewCustomerRecordsAndFindAll()
    {
        // creating customers
        Customer customer = new Customer();
        customer.setFirst_name("Rebecca");
        customer.setLast_name("Clarke");
        customer.setEmail("beccaclark@email.com");
        customer.setCompany("company");
        customer.setPhone("(123).456.7890");
        customer.setAddress_1("1234 Random Ln");
        customer.setAddress_2("");
        customer.setCity("Austin");
        customer.setState("TX");
        customer.setPostal_code("12345");
        customer.setCountry("United States");
        customer = customerRepository.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirst_name("Lorenz");
        customer1.setLast_name("Joyous");
        customer1.setEmail("LJoy@email.com");
        customer1.setCompany("company2");
        customer1.setPhone("(111).222.333");
        customer1.setAddress_1("5678 Random St");
        customer1.setAddress_2("Apt. 805");
        customer1.setCity("Austin");
        customer1.setState("TX");
        customer1.setPostal_code("12333");
        customer1.setCountry("United States");
        customer1 = customerRepository.save(customer1);


        Customer customer2 = new Customer();
        customer2.setFirst_name("Annie");
        customer2.setLast_name("Lillian");
        customer2.setEmail("annie@email.com");
        customer2.setCompany("company");
        customer2.setPhone("(112).233.4455");
        customer2.setAddress_1("7654 unknown Dr");
        customer2.setAddress_2("");
        customer2.setCity("San Antonio");
        customer2.setState("TX");
        customer2.setPostal_code("54321");
        customer2.setCountry("United States");
        customer2 = customerRepository.save(customer2);

        List<Customer> custList = customerRepository.findAll();
        assertEquals(custList.size(), 3);
    }

    @Test
    public void shouldUpdateExistingCustomerRecord()
    {
        // setup: need to first create customer
        Customer customer = new Customer();
        customer.setFirst_name("Rebecca");
        customer.setLast_name("Clarke");
        customer.setEmail("beccaclark@email.com");
        customer.setCompany("company");
        customer.setPhone("(123).456.7890");
        customer.setAddress_1("1234 Random Ln");
        customer.setAddress_2("");
        customer.setCity("Austin");
        customer.setState("TX");
        customer.setPostal_code("12345");
        customer.setCountry("United States");
        customer = customerRepository.save(customer);

        // Updating Customer
        customer.setAddress_1("NewAddres 1234");
        customer.setAddress_2("Unit 123");
        customer.setPostal_code("26375");

        customerRepository.save(customer);

        Optional<Customer> cust = customerRepository.findById(customer.getCustomer_id());
        assertEquals(cust.get(),customer);
    }

    @Test
    public void shouldDeleteExistingCustomerRecord()
    {
        // setup: need to first create customer
        Customer customer = new Customer();
        customer.setFirst_name("Rebecca");
        customer.setLast_name("Clarke");
        customer.setEmail("beccaclark@email.com");
        customer.setCompany("company");
        customer.setPhone("(123).456.7890");
        customer.setAddress_1("1234 Random Ln");
        customer.setAddress_2("");
        customer.setCity("Austin");
        customer.setState("TX");
        customer.setPostal_code("12345");
        customer.setCountry("United States");
        customer = customerRepository.save(customer);

        // retrieving customer and asserting it exists
        Optional<Customer> cust = customerRepository.findById(customer.getCustomer_id());
        assertEquals(cust.get(),customer);

        // Deleting customer
        customerRepository.deleteById(customer.getCustomer_id());
        cust = customerRepository.findById(customer.getCustomer_id());

        assertFalse(cust.isPresent());
    }

//    Find a customer record by id.
    @Test
    public void shouldFindCustomerById()
    {
        // setup: need to first create customers
        Customer customer = new Customer();
        customer.setFirst_name("Rebecca");
        customer.setLast_name("Clarke");
        customer.setEmail("beccaclark@email.com");
        customer.setCompany("company");
        customer.setPhone("(123).456.7890");
        customer.setAddress_1("1234 Random Ln");
        customer.setAddress_2("");
        customer.setCity("Austin");
        customer.setState("TX");
        customer.setPostal_code("12345");
        customer.setCountry("United States");
        customer = customerRepository.save(customer);

        Optional<Customer> cust = customerRepository.findById(customer.getCustomer_id());
        assertEquals(cust.get(),customer);
    }

    @Test
    public void shouldFIndCustomerByState()
    {
        // setup: need to first create customers
        Customer customer = new Customer();
        customer.setFirst_name("Rebecca");
        customer.setLast_name("Clarke");
        customer.setEmail("beccaclark@email.com");
        customer.setCompany("company");
        customer.setPhone("(123).456.7890");
        customer.setAddress_1("1234 Random Ln");
        customer.setAddress_2("");
        customer.setCity("Anchorage");
        customer.setState("AK");
        customer.setPostal_code("12345");
        customer.setCountry("United States");
        customer = customerRepository.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirst_name("Lorenz");
        customer1.setLast_name("Joyous");
        customer1.setEmail("LJoy@email.com");
        customer1.setCompany("company2");
        customer1.setPhone("(111).222.333");
        customer1.setAddress_1("5678 Random St");
        customer1.setAddress_2("Apt. 805");
        customer1.setCity("Austin");
        customer1.setState("TX");
        customer1.setPostal_code("12333");
        customer1.setCountry("United States");
        customer1 = customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirst_name("Annie");
        customer2.setLast_name("Lillian");
        customer2.setEmail("annie@email.com");
        customer2.setCompany("company");
        customer2.setPhone("(112).233.4455");
        customer2.setAddress_1("7654 unknown Dr");
        customer2.setAddress_2("");
        customer2.setCity("San Antonio");
        customer2.setState("TX");
        customer2.setPostal_code("54321");
        customer2.setCountry("United States");
        customer2 = customerRepository.save(customer2);

        List<Customer> custByStateTxList = customerRepository.findByState("TX");
        List<Customer> custByStateAkList = customerRepository.findByState("AK");

        assertEquals(custByStateTxList.size(),2);
        assertEquals(custByStateAkList.size(),1);

    }
}
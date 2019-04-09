import org.junit.Before;
import org.junit.Test;
import xml.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.fest.assertions.api.Assertions.assertThat;

public class PersonInfoTypeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee();
        employee.setName("str1234");
        employee.setAddress(new Employee.Address());
    }

    @Test
    public void shouldCreateObjectFromXmlWithUnmarshlling() throws JAXBException {
        File file = new File("src/test/resources/xml/test.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Employee employeeForTest = (Employee) unmarshaller.unmarshal(file);

        assertThat(employee.getName()).isEqualTo(employeeForTest.getName());
    }
}

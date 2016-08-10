package test.address.model;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @author ymc 
 * @version ����ʱ�䣺2016��2��1�� ����9:24:05 
 *
 */
@XmlRootElement(name = "persons")
public class PersonListWrapper {
	    private List<Person> persons;

	    @XmlElement(name = "person")
	    public List<Person> getPersons() {
	        return persons;
	    }

	    public void setPersons(List<Person> persons) {
	        this.persons = persons;
	    }

}

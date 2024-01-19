public abstract class AddressPrototype implements Cloneable {
    private String street, number, district, city;

    public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void printAddress() {
        System.out.println("Street: " + street);
        System.out.println("Number: " + number);
        System.out.println("District: " + district);
        System.out.println("City: " + city);
        System.out.println("hashCode: " + hashCode());
    }
}


class CompanyAddress extends AddressPrototype {
    private String company;

    public CompanyAddress(String street, String number, String district, String city, String company) {
    	setStreet(street);
    	setNumber(number);
    	setDistrict(district);
        setCity(city);
        this.company = company;
    }

	public String getCompany() {
		return company;
	}
}

class PersonAddress extends AddressPrototype {
    private String firstName, lastName;

    public PersonAddress(String street, String number, String district, String city, String firstName, String lastName) {
    	setStreet(street);
    	setNumber(number);
    	setDistrict(district);
        setCity(city);
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}


////////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		CompanyAddress companyAddress = new CompanyAddress("Tech St.", "42", "Silicon Valley", "Tech City", "TechCo");

        // Print CompanyAddress details
        System.out.println("Company Address:");
        companyAddress.printAddress();
        System.out.println("Company: " + companyAddress.getCompany());
        System.out.println();

        // Create a PersonAddress instance
        PersonAddress personAddress = new PersonAddress("Main St.", "123", "Downtown", "Metroville", "John", "Doe");

        // Print PersonAddress details
        System.out.println("Person Address:");
        personAddress.printAddress();
        System.out.println("First Name: " + personAddress.getFirstName());
        System.out.println("Last Name: " + personAddress.getLastName());
	}

}
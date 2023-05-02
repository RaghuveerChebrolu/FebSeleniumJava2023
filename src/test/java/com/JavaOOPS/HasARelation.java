package com.JavaOOPS;

class Address1 {
	String city, state, country;

	public Address1(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

}

public class HasARelation {
	int id;
	String name;
	Address1 address;

	public HasARelation(int id, String name, Address1 address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	void display() {
		System.out.println(id + " " + name);
		System.out.println(address.city + " " + address.state + " " + address.country);
	}

	public static void main(String[] args) {
		Address1 address1 = new Address1("gzb", "UP", "india");
		Address1 address2 = new Address1("Hyderabad", "Telanaga", "india");

		HasARelation e = new HasARelation(111, "varun", address1);
		HasARelation e2 = new HasARelation(112, "arun", address2);

		e.display();
		e2.display();

	}
}


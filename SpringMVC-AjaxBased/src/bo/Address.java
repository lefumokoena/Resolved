package bo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {

	@NotEmpty
	String addressLine1;
	String addressLine2;
	
	@NotEmpty
	String city;
	long pincode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", pincode=" + pincode
				+ "]";
	}

}

package pl.jkanclerz.sales;

public class AcceptOfferRequest {
    String email;
    String fname;
    String lname;

    public String getEmail() {
        return email;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public AcceptOfferRequest setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public AcceptOfferRequest setLname(String lname) {
        this.lname = lname;
        return this;
    }
}

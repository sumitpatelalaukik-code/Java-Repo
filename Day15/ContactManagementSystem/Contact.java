class Contact{
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber=number;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    } 

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "Contact [Name=" + name
                + ", Phone=" + phoneNumber
                + ", Email=" + email + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Contact)) return false;
        Contact contact = (Contact)obj;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode(){
        return phoneNumber.hashCode();
    }
}
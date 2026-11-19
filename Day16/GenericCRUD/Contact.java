class Contact{
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
}
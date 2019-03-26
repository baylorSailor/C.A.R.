public class User {
    private String name;
    private String username;
    private String email;
    private String creditType;
    private String creditCard;

    public User(String name, String username, String email, String creditType, String creditCard) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.creditType = creditType;
        this.creditCard = creditCard;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}

package Entity;

public class User {
    private int id;
    private String username;
    private String nationalCode;
    private String birthday;
    private String password;

    public User(){

    }

    public User(int id, String username, String nationalCode, String birthday, String password) {
        this.id = id;
        this.username = username;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        if (nationalCode.length()<11)
        this.nationalCode = nationalCode;
        else
            System.out.println("  error || enter correct national code");
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package Entity;

public class User {

    private long id;
    private String  userName;
    private String  nationalCode;
    private String  birthDay;
    private String password;


    public User (){

    }

    public User(long id,String userName,String nationalCode ,String birthDay , String password) {
        this.id = id;
        this.nationalCode = nationalCode;
        this.birthDay = birthDay;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

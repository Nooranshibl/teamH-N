public class User
{
    private String email;
    private String passWord;
    private String name;
    private int phoneNum;

    public User() {}
    public  User(String e, String pw, String n, int p) {
        email=e;
        passWord=pw;
        name=n;
        phoneNum=p;
    }
    public String getEmail() {return email;}
    public void setEmail(String e) {email=e;}
    public String getPassWord() {return passWord;}
    public void setPassWord(String pw) {passWord=pw;}
    public String getName() { return name; }
    public void setName(String n) {name=n;}
    public int getPhoneNum() {return phoneNum;}
    public void setPhoneNum(int p) {phoneNum=p;}
}

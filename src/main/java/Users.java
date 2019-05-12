public class Users {
    private String name;
    private String surName;
    private String nickName;
    private String email;
    private String password;

   private int borrowedNumberOfBooks;



    public Users(String name, String surName, String nickName, String email, String password) {
        this.name = name;
        this.surName = surName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

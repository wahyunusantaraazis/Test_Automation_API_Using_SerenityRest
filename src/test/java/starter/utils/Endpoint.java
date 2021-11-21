package starter.utils;

public class Endpoint {
    public String BASE_URL = "https://demoqa.com";
    public String LOGIN = BASE_URL+"/Account/v1/Login";
    public String REGISTER = BASE_URL+"/Account/v1/User";
    public String GENERATETOKEN = BASE_URL+"/Account/v1/GenerateToken";
    public String AUTHORIZED = BASE_URL+"/Account/v1/Authorized";
    public String GETUSERID = BASE_URL+"/Account/v1/User/";
    //BOOKSTORE
    public String GETALLBOOKS = BASE_URL+"/Bookstore/v1/Books";
    public String GETBOOK = BASE_URL+"/Bookstore/v1/Book";
    public String POSTBOOK = BASE_URL+"/BookStore/v1/Books";
    public String PUTBOOK = BASE_URL+"/BookStore/v1/Books/";
    public String DELETEBOOK = BASE_URL+"/BookStore/v1/Book";
}

package example.grpc.api;


public interface ApiService {

  boolean isUsernameUnique(String username);

  boolean isUsernameValid(String username);


  boolean isPhoneNumberValid(String phoneNumber);


}

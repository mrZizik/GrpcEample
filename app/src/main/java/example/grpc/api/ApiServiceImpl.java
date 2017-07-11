package example.grpc.api;


import api.Api.IsUniqueUsernameRequest;
import api.PublicUserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiServiceImpl implements ApiService {

  public static final String DNOTE_API_ADDRESS = "188.130.155.42";
  public static final int DNOTE_API_PORT = 50051;
  private ManagedChannel channel;
  private PublicUserServiceGrpc.PublicUserServiceBlockingStub publicUserServiceBlockingStub;

  public ApiServiceImpl() {
    channel = ManagedChannelBuilder
        .forAddress(DNOTE_API_ADDRESS, DNOTE_API_PORT)
        .usePlaintext(true)
        .build();
  }


  @Override
  public boolean isUsernameUnique(String username) {
    IsUniqueUsernameRequest isUniqueUsernameRequest = IsUniqueUsernameRequest.newBuilder()
        .setUsername(username)
        .build();
    return getPublicUserServiceBlockingStub().isUniqueUsername(isUniqueUsernameRequest)
        .getIsUnique();
  }

  @Override
  public boolean isUsernameValid(String username) {
    Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,10}$");
    Matcher m = p.matcher(username);
    return m.matches();
  }


  public boolean isPhoneNumberValid(String phoneNumber) {
    Pattern p = Pattern.compile("^[0-9]{10}$");
    Matcher m = p.matcher(phoneNumber);
    return m.matches();
  }


  public PublicUserServiceGrpc.PublicUserServiceBlockingStub getPublicUserServiceBlockingStub() {
    if (publicUserServiceBlockingStub == null) {
      Class lock = ApiServiceImpl.class;
      synchronized (lock) {
        publicUserServiceBlockingStub = PublicUserServiceGrpc
            .newBlockingStub(channel);
      }
    }
    return publicUserServiceBlockingStub;
  }

}

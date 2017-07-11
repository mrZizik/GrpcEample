package example.grpc;

import example.grpc.api.ApiService;
import javax.inject.Inject;

public class ApiUser {

  @Inject
  ApiService apiService;

  public ApiUser() {
    DependencyInjectionInitializer.getInstance().getServiceComponent().inject(this);
  }

  public boolean isUnique(String name) {
    if (apiService.isUsernameValid(name)) {
      if (apiService.isUsernameUnique(name)) {
        return true;
      }
    }
    return false;
  }
}

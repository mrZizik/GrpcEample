package example.grpc.api;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApiServiceModule {

  @Provides
  @Singleton
  public ApiService provideDnoteApi() {
    return new ApiServiceImpl();
  }
}

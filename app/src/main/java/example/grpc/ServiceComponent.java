package example.grpc;


import dagger.Component;
import example.grpc.api.ApiServiceModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiServiceModule.class})
public interface ServiceComponent {

  void inject(ApiUser interactor);


}

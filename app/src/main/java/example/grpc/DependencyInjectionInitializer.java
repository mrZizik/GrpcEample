package example.grpc;


import example.grpc.api.ApiServiceModule;

public class DependencyInjectionInitializer {

  private static DependencyInjectionInitializer mInstance;

  private ServiceComponent serviceComponent;

  static {
    mInstance = new DependencyInjectionInitializer();
  }

  public ServiceComponent getServiceComponent() {
    return serviceComponent;
  }

  private DependencyInjectionInitializer() {
    // Dagger%COMPONENT_NAME%
    serviceComponent = DaggerServiceComponent.builder()
        // list of modules that are part of this component need to be created here too
        .apiServiceModule(
            new ApiServiceModule()) // This also corresponds to the name of your module: %component_name%Module
        .build();
  }


  public static DependencyInjectionInitializer getInstance() {
    return mInstance;
  }
}

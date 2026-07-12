import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
class MyServiceTest{
 @Test
 void testVerifyInteraction(){
   ExternalApi api=mock(ExternalApi.class);
   MyService service=new MyService(api);
   service.fetchData();
   verify(api).getData();
 }
}

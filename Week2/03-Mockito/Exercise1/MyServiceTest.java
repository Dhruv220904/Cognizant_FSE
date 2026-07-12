import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class MyServiceTest{
 @Test
 void testExternalApi(){
   ExternalApi api=mock(ExternalApi.class);
   when(api.getData()).thenReturn("Mock Data");
   MyService service=new MyService(api);
   assertEquals("Mock Data",service.fetchData());
 }
}

import com.teamjw.redis.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest {

    @Autowired
    RedisService redisService;

    @Test
    public void test(){
        //int test = redisService.redisTest();
    }
}

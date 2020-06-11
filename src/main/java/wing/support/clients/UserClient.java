package wing.support.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wing.support.domain.User;

@Component
@FeignClient(url="http://10.178.0.43:8002", value="user")
public interface UserClient {

    @GetMapping("/api/user/{id}")
    User getUser(@PathVariable String id);
}

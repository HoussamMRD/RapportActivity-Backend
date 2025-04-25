package ma.srmanager.srjwt.openfeign;

import ma.srmanager.coreapi.base.SrResponseMessage;
import ma.srmanager.coreapi.base.SrUtils;
import ma.srmanager.coreapi.mail.MailSendDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "SR-MAIL", url = SrUtils.mailHost + "/mail")
public interface MailSendRestClient {

    @PostMapping(path = "/send", consumes = "application/json")
    SrResponseMessage sendMail(@RequestBody MailSendDTO dto,
                               @RequestHeader(name = "Authorization") String token);

}

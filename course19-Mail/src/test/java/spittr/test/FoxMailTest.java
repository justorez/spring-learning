package spittr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.FoxMailConfig;
import spittr.domain.Spitter;
import spittr.domain.Spittle;
import spittr.service.MailService;

import java.util.Date;

/**
 * 请到填写的收件邮箱中查看邮件
 *
 * @author justZero
 * @since 2019-1-27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FoxMailConfig.class)
public class FoxMailTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleSpittleEmail() throws Exception {
        Spitter spitter = new Spitter(1L, "测试哥", null,
                "测试哥", "test@spring1.com", true);
        Spittle spittle = new Spittle(1L, spitter, "你好啊!", new Date());
        mailService.sendSimpleSpittleEmail("alonezero@foxmail.com", spittle);
    }

    @Test
    public void sendSpittleEmailWithAttachment() throws Exception {
        Spitter spitter = new Spitter(1L, "测试妹", null,
                "测试妹", "test@spring2.com", true);
        Spittle spittle = new Spittle(1L, spitter, "收到图片文件了吗？", new Date());
        mailService.sendSpittleEmailWithAttachment("alonezero@foxmail.com", spittle);
    }

    @Test
    public void sendSpittleEmailWithRichText() throws Exception {
        Spitter spitter = new Spitter(1L, "测试弟", null,
                "测试弟", "test@spring3.com", true);
        Spittle spittle = new Spittle(1L, spitter, "看我的头像帅吗？！", new Date());
        mailService.sendSpittleEmailWithRichText("alonezero@foxmail.com", spittle);
    }
}

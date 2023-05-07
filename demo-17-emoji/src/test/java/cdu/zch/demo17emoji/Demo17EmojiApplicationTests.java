package cdu.zch.demo17emoji;

import com.vdurmont.emoji.EmojiParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo17EmojiApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(EmojiParser.parseToAliases("xxxx\uD83D\uDE0E\uD83D\uDE02\uD83E\uDD37\uD83D\uDCAA\uD83D\uDC7D"));
        System.out.println(EmojiParser.parseToUnicode(":sunglasses::joy::shrug::muscle::alien:"));
    }

}

package DelfiArrayListTest;

import org.openqa.selenium.By;

public class CommentPage {
    BaseFunk baseFunk;
    private final By REGISTER = By.xpath(".//a[contains(@class, 'list-a-reg')]/span");
    private final By ANONYMOUS = By.xpath(".//a[contains(@class, 'list-a-anon')]/span");

    public CommentPage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public Integer registerComment() {
        String register = baseFunk.browser.findElement(REGISTER).getText();
        register = register.substring(1, register.length() - 1);
        return Integer.valueOf(register);
    }

    public Integer anonymousComment() {
        String anonymous = baseFunk.browser.findElement(ANONYMOUS).getText();
        anonymous = anonymous.substring(1, anonymous.length() - 1);
        return Integer.valueOf(anonymous);
    }

    public Integer sumCommentOnArticlePage() {
        Integer sum = Integer.valueOf(registerComment() + anonymousComment());
        return sum;
    }
}

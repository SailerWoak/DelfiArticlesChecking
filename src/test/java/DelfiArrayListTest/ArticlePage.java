package DelfiArrayListTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    BaseFunk baseFunk;
    private final By COMMENT_PAGE = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");

    public ArticlePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    WebElement commentPage(int id) {
        List<WebElement> comments = baseFunk.getElements(COMMENT_PAGE);
        for (int i = 0; i < comments.size(); i++) {
            WebElement comment = comments.get(i);
            return comment;
        }
        return null;
    }

    void goToCommentPage(int id) {
        commentPage(id).click();
        return;
    }
}

package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

	private final Deque<String> histories = new ArrayDeque<>();
	private String currentPage = null;

	public void visitPage(String page) {
		if (currentPage != null) {
			histories.push(currentPage);
		}
		currentPage = page;
		System.out.println("방문: " + page);
	}

	public String goBack() {
		if (!histories.isEmpty()) {
			currentPage = histories.pop();
			System.out.println("뒤로 가기: "  + currentPage);
			return currentPage;
		}
		return null;
	}
}

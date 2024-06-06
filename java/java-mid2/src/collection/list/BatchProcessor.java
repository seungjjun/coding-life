package collection.list;

public class BatchProcessor {
	private final MyList<Integer> list; // 추상적인 인터페이스 list에 의존

	public BatchProcessor(MyList<Integer> list) {
		this.list = list;
	}

	public void logic(int size) {
		// ...
	}
}

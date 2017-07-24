package source.structural;

public class SubAbstract {

	private static class Sub1 {
		private final End start = new End() {
		};

		private abstract class End {
		}

	}

	private static class Sub2 {
		private final End start = new End() {
			{
				a = 1;
			}
		};

		private abstract class End {
			public int a;
		}

	}

	private static class Sub3 {

		private final End start = new End() {
			{
				a = 1;
			}

			public void m() {
			};
		};

		private abstract class End {
			public int a;

			public abstract void m();
		}

	}

}
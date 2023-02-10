import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
	
	private TestDemo testDemo;


	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(Arguments.of(2,4,6,false));
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	

}

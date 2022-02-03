package demo;
import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost(){
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Huyen";
//		data[0][1] = "Le";
//		data[0][2] = 2;
//		
//		data[1][0] = "Trinh";
//		data[1][1] = "Tran";
//		data[1][2] = 2;
//		
//		return data;
		
		return new Object[][] {
			{"Tuyen", "Huyen", 1},
			{"Tin", "Dao", 1}
		};
	}
	
	@DataProvider(name = "deletedData")
	public Object[] dataForDelete() {
		return new Object[] {
				4, 5, 6, 7
		};
	}
}

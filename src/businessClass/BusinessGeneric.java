package businessClass;

public class BusinessGeneric {

	
	public void verifyId(int id, String MessageError) {
		if (id <= 0)
			throw new Error(MessageError);
	}
}

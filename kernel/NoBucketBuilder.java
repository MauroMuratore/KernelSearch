package kernel;

import java.util.ArrayList;
import java.util.List;

public class NoBucketBuilder implements BucketBuilder {

	@Override
	public List<Bucket> build(List<Item> items, Configuration config) {
		List<Bucket> ritorno = new ArrayList<Bucket>();
		return ritorno;
	}

}

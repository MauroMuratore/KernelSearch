package kernel;

import java.util.ArrayList;
import java.util.List;

public class NumericBucketBuilder implements BucketBuilder{

	@Override
	public List<Bucket> build(List<Item> items, Configuration config) {
		List<Bucket> buckets = new ArrayList<Bucket>();
		int size = (int) Math.floor(items.size()*config.getBucketSize());
		int number = config.getBucketNumber();
		Bucket b = new Bucket();
		for(Item it : items)
		{
			b.addItem(it);

			if(b.size() == size)
			{
				buckets.add(b);
				if(buckets.size()>=number) {
					break;
				}
				b = new Bucket();
			}

		}
		return buckets;
	}

}

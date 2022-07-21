package kernel;

import java.util.Comparator;
import java.util.List;

public class ItemSorterVW implements ItemSorter {

	@Override
	public void sort(List<Item> items) {
		items.sort(Comparator.comparing(Item::getXrValue ).reversed()
		          .thenComparing(Item::getRc));
	}

}

package eu.theappshop.baseadapter.filterableadapter;

import eu.theappshop.baseadapter.StubVM;
import eu.theappshop.baseadapter.adapterv2.Adapter;
import eu.theappshop.baseadapter.adapterv2.FilterableVmAdapter;
import eu.theappshop.baseadapter.general.AdapterSerializationTestCase;
import java.util.List;

public class FilterableAdapterSerializationTestCase extends AdapterSerializationTestCase {

  @Override protected Adapter<StubVM> getAdapter(List<StubVM> vms) {
    return new FilterableVmAdapter<>(new TestPredicate(), vms);
  }
}
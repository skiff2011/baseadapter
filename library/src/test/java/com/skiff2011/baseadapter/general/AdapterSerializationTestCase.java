package com.skiff2011.baseadapter.general;

import com.skiff2011.baseadapter.AbstractItemAdapter;
import com.skiff2011.baseadapter.ItemAdapter;
import com.skiff2011.baseadapter.TestItem;
import com.skiff2011.baseadapter.utils.ListUtils;
import com.skiff2011.baseadapter.utils.SerializationUtils;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Test correct serialization/deserialization required by some specific architectures
public abstract class AdapterSerializationTestCase {

  private ItemAdapter<TestItem> adapter;

  @Before
  public void setUp() {
    adapter = getAdapter(ListUtils.generateList(10, new TestItem.IntMapper()));
  }

  @Test
  public void testConsistency() throws IOException, ClassNotFoundException {
    byte[] serialized1 = SerializationUtils.serialize(adapter);
    byte[] serialized2 = SerializationUtils.serialize(adapter);
    Object deserialized1 = SerializationUtils.deserialize(serialized1);
    Object deserialized2 = SerializationUtils.deserialize(serialized2);
    assertEquals(deserialized1, deserialized2);
    assertEquals(adapter, deserialized1);
    assertEquals(adapter, deserialized2);
  }

  @Test
  public void testInstance() throws IOException, ClassNotFoundException {
    byte[] serialized = SerializationUtils.serialize(adapter);
    Object deserialized = SerializationUtils.deserialize(serialized);
    assertTrue(deserialized instanceof ItemAdapter<?>);
    assertTrue(((AbstractItemAdapter<?>) deserialized).items().get(0) instanceof TestItem);
    assertEquals(adapter, deserialized);
  }

  protected abstract ItemAdapter<TestItem> getAdapter(List<TestItem> items);
}

package com.apress.ch04.sample06;

import com.apress.ch04.sample05.service.InventoryServiceGrpc;
import com.apress.ch04.sample05.service.InventoryServiceGrpc.InventoryServiceBlockingStub;
import com.apress.ch04.sample05.service.Item;
import com.apress.ch04.sample05.service.ItemList;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class InventoryClient {

	ManagedChannel managedChannel;
	InventoryServiceBlockingStub stub;

	public void updateItems(com.apress.ch04.sample06.model.Item[] items) {

		ItemList itemList = null;

		for (int i = 0; i < items.length; i++) {
			Item item;
			item = Item.newBuilder().setCode(items[i].getCode())
					.setQty(items[i].getQty()).build();
			if (itemList != null && itemList.getItemList().size() > 0) {
				itemList = ItemList.newBuilder(itemList).addItem(i, item).build();
			} else {
				itemList = ItemList.newBuilder().addItem(0, item).build();
			}
		}

		managedChannel = ManagedChannelBuilder.forAddress("localhost", 7000).usePlaintext(true).build();
		stub = InventoryServiceGrpc.newBlockingStub(managedChannel);
		stub.updateItems(itemList);
	}
}

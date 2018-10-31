package com.apress.ch04.sample05.service;

import com.apress.ch04.sample05.service.ItemList;
import com.apress.ch04.sample05.service.UpdateItemsResp;

import java.util.List;

import org.lognet.springboot.grpc.GRpcService;

import com.apress.ch04.sample05.service.InventoryServiceGrpc.InventoryServiceImplBase;
import com.apress.ch04.sample05.service.Item;

import io.grpc.stub.StreamObserver;

@GRpcService
public class Inventory extends InventoryServiceImplBase{

	@Override
	public void updateItems(ItemList request, StreamObserver<UpdateItemsResp> responseObserver) {
		List<Item> items = request.getItemList();
		
		for (Item item : items) {
			System.out.println(item.getCode());
		}
		
		responseObserver.onNext(UpdateItemsResp.newBuilder().setCode("success").build());
		responseObserver.onCompleted();
	}
}

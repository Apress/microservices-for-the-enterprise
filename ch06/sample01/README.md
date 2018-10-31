
# Service discovery with Consul 

This sample from the book shows how you can use Consul REST API for service registration and discovery. 


## Register a Service
- You can register a given service in consul by creating a configuration file and which is used during the Consul startup. 
- For example you can create a consul.d directory and put all your service definitions to that.  In the following example, we have the service definition of the Order service as shown in the following directory structure. 
```sh
my_consul_config
└── consul.d
    └── order_service.json
````
- The content of the service definition (`` order_service.json ``) is as follows. 
```json
{ "service": {"name": "order_service", "tags": ["order-mgt"], "port": 80}}
```
- You can start Consul agent with 

``` 
./consul agent -dev -config-dir=/Users/kasun/Dev/Deploy/consul/my_consul_config/consul.d/ 
```
- If the agent is successfully started, you should see a consol output similar to the following. 
```
    ...
    2018/09/09 09:16:20 [INFO] raft: Node at 127.0.0.1:8300 [Leader] entering Leader state
    2018/09/09 09:16:20 [INFO] consul: cluster leadership acquired
    2018/09/09 09:16:20 [INFO] consul: New leader elected: Kasuns-MBP.attlocal.net
    2018/09/09 09:16:20 [DEBUG] consul: Skipping self join check for "Kasuns-MBP.attlocal.net" since the cluster is too small
    2018/09/09 09:16:20 [INFO] consul: member 'Kasuns-MBP.attlocal.net' joined, marking health alive
    2018/09/09 09:16:21 [DEBUG] agent: Skipping remote check "serfHealth" since it is managed automatically
    2018/09/09 09:16:21 [INFO] agent: Synced service "order_service"
    2018/09/09 09:16:21 [DEBUG] agent: Node info in sync
    2018/09/09 09:16:22 [DEBUG] agent: Skipping remote check "serfHealth" since it is managed automatically
    2018/09/09 09:16:22 [DEBUG] agent: Service "order_service" in sync
    2018/09/09 09:16:22 [DEBUG] agent: Node info in sync
    2018/09/09 09:16:22 [DEBUG] agent: Service "order_service" in sync
    2018/09/09 09:16:22 [DEBUG] agent: Node info in sync 
```


## Service Discovery 
- Once you have started the Consul with the required service definitions, you can discover the service via Consul REST API. 

- You can send an HTTP Get request to the following URI to retrieve the service definition of the `` order_service `` that we have used in the previous step. 
```
curl http://localhost:8500/v1/catalog/service/order_service 
```
- You can obtain the service definition with the following format. 

```
[
    {
        "ID": "d88fa059-908c-3907-68f0-15a89b162098",
        "Node": "Kasuns-MBP.attlocal.net",
        "Address": "127.0.0.1",
        "Datacenter": "dc1",
        "TaggedAddresses": {
            "lan": "127.0.0.1",
            "wan": "127.0.0.1"
        },
        "NodeMeta": {
            "consul-network-segment": ""
        },
        "ServiceID": "order_service",
        "ServiceName": "order_service",
        "ServiceTags": [
            "order-mgt"
        ],
        "ServiceAddress": "",
        "ServiceMeta": {},
        "ServicePort": 80,
        "ServiceEnableTagOverride": false,
        "CreateIndex": 6,
        "ModifyIndex": 6
    }
] 
```

## Updating Service Definitions 

Service definitions can be updated by changing configuration files and sending a SIGHUP to the agent. This lets you update services without any downtime or unavailability to service queries.

Alternatively, the HTTP API can be used to add, remove, and modify services dynamically.